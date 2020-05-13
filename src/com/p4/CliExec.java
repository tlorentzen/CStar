package com.p4;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.*;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.ZipFile;

public class CliExec {

    // Ansi colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    String basePath = System.getProperty("user.dir");
    String baseCommand = "";
    String arduinoCliFilename;
    BufferedReader stdInput;
    BufferedReader stdError;
    Process p;
    File acli;
    Boolean arduinoCliPresent = false;
    boolean outputInfo = false;
    ErrorBag errors;
    Board board;
    File arduinoCli;

    public CliExec(ErrorBag errors, boolean outputInfo){
        this.errors = errors;
        this.outputInfo = outputInfo;
        acli = new File(basePath);

        if(SystemInfo.isWindows()){
            baseCommand = "arduino-cli.exe";
            arduinoCliFilename = baseCommand;
            arduinoCli = new File(basePath+"/"+baseCommand);
        }else{
            baseCommand = "./arduino-cli";
            arduinoCliFilename = "arduino-cli";
            arduinoCli = new File(basePath+"/arduino-cli");
        }

        checkCliInstallation();

        if(arduinoCli.exists() && arduinoCli.isFile()){
            arduinoCliPresent = true;
        }else{
            errors.addEntry(ErrorType.ARDUINO_CLI_MISSING, "Arduino CLI is missing");
        }
    }

    public void arduinoSelection(){
        if(!arduinoCliPresent)
            return;
        
        ArrayList<Board> boards = getBoards();
        int counter = 1;

        if(boards.size() > 0){
            if(boards.size() > 1){
                initializeCliSetup();
                System.out.println();
                System.out.println("Select Arduino:");

                for (Board b: boards) {
                    System.out.println("  "+counter+") "+ b.getName()+" - "+b.getCore());
                    counter++;
                }

                System.out.print("> ");

                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    int index = Integer.parseInt(reader.readLine());
                    board = boards.get(index-1);
                }catch(Exception e){
                    System.out.println();
                }

                System.out.println();
            }else{
                board = boards.get(0);
            }

            installBoardCore(board.getCore());
        }else{
            errors.addEntry(ErrorType.ARDUINO_NOT_FOUND, "No Arduino boards found. The program has still been compiled and is located in the 'output' folder");
        }
    }

    private ArrayList<Board> getBoards(){

        ArrayList<Board> boards = new ArrayList<>();

        if(execute("board list", acli)){
            String s = null;
            int counter = 0;

            try{
                while ((s = stdInput.readLine()) != null) {
                    if(counter == 0 || s.equals("")){
                        counter++;
                        continue;
                    }

                    String[] items = s.split("\\s+");
                    //Does not add bluetooth option and unknown boards
                    if(items[0].contains("Bluetooth") || items[3].contains("Unknown")){
                        continue;
                    }

                    String boardname = "";
                    for(int j=4; j < items.length-2; j++){
                        boardname = boardname.concat(items[j]+" ");
                    }

                    Board board = new Board(boardname.trim(), items[items.length-1], items[0], items[items.length-2]);
                    boards.add(board);
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }

        return boards;
    }


    public void compileAndUpload(){
        if(arduinoCliPresent && board != null){
            printIt("Compiling C-code... ", true);

            if(execute("compile --fqbn "+board.getFqbn()+" output", acli)){
                printOk();
                printIt("Uploading to Arduino... ", true);

                if(execute("upload -p "+board.getPort()+" --fqbn "+board.getFqbn()+" output", acli)){
                    printOk();
                }else{
                    printFailed();
                }
            }else{
                printFailed();
            }
        }
    }

    public boolean execute(String cmd, File path){
        try{
            if(stdInput != null && stdError != null){
                stdInput.close();
                stdError.close();
            }

            p = Runtime.getRuntime().exec(baseCommand+" "+cmd, null, path);

            stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            while(p.isAlive()){}

            String s;
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            return p.exitValue() == 0;
        }catch(Exception e){
            System.out.println(e);
        }

        return false;
    }

    public void installBoardCore(String core){
        if(arduinoCliPresent){
            printIt("Installing core... ", true);

            if(execute("core install "+core, acli)){
                printOk();
            }else{
                printFailed();
            }
        }
    }

    private void initializeCliSetup(){
        if(arduinoCliPresent){
            printIt("Updating core index... ", true);

            if(execute("core update-index", acli)){
                printOk();
            }else{
                printFailed();
            }
        }
    }

    private void printIt(String text, boolean skipNewline){
        if(outputInfo){
            if(skipNewline){
                System.out.print(text);
            }else{
                System.out.println(text);
            }
        }
    }

    public void checkCliInstallation() {
        String downloadUrl = "";
        String fileName = "";
        if(!arduinoCli.exists() || !arduinoCli.isFile()){
            System.out.println("The Arduino CLI does not exist on your system");
            System.out.println("Would you like to have it downloaded?");
            System.out.println("Y/N");
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if(answer.equals("Y") || answer.equals("y")){
                    switch(SystemInfo.getOsString()){
                        case "win":
                            downloadUrl = "https://downloads.arduino.cc/arduino-cli/arduino-cli_latest_Windows_64bit.zip";
                            fileName = "arduino-cli_latest_Windows_64bit.zip";
                            break;
                        case "mac":
                            downloadUrl = "https://downloads.arduino.cc/arduino-cli/arduino-cli_latest_macOS_64bit.tar.gz";
                            fileName = "arduino-cli_latest_macOS_64bit.tar.gz";
                            break;
                        case "unix":
                            downloadUrl = "https://downloads.arduino.cc/arduino-cli/arduino-cli_latest_Linux_64bit.tar.gz";
                            fileName = "arduino-cli_latest_Linux_64bit.tar.gz";
                            break;
                        default:
                            downloadUrl = "";
                            fileName = "";
                    }

                    if(!downloadUrl.equals("")){
                        File output = new File(basePath+"/"+fileName);

                        Connection.Response response= Jsoup.connect(downloadUrl)
                                .ignoreContentType(true)
                                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                                .timeout(5000)
                                .maxBodySize(0)
                                .execute();

                        try (FileOutputStream fos = new FileOutputStream(output)) {
                            fos.write(response.bodyAsBytes());
                        }

                        if(SystemInfo.getOsString().equals("win")){
                            unpackZip(output);
                        }else{
                            unpackGZip(output);
                        }
                        output.deleteOnExit();
                    } else {
                        //TODO error
                    }
                }

            }catch(Exception e){
                System.out.println();
            }
        }
    }

    private void unpackGZip(File zipFile){

        //https://stackoverflow.com/questions/7128171/how-to-compress-decompress-tar-gz-files-in-java
        try{
            InputStream fis = new FileInputStream(zipFile);
            GzipCompressorInputStream gzipIn = new GzipCompressorInputStream(fis);
            try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
                TarArchiveEntry entry;

                while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
                    /** If the entry is a directory, create the directory. **/
                    if (entry.isDirectory()) {
                        File f = new File(entry.getName());
                        boolean created = f.mkdir();
                        if (!created) {
                            System.out.printf("Unable to create directory '%s', during extraction of archive contents.\n", f.getAbsolutePath());
                        }
                    } else {
                        int count;
                        byte data[] = new byte[1024];
                        FileOutputStream fos = new FileOutputStream(entry.getName(), false);
                        try (BufferedOutputStream dest = new BufferedOutputStream(fos, 1024)) {
                            while ((count = tarIn.read(data, 0, 1024)) != -1) {
                                dest.write(data, 0, count);
                            }
                        }
                    }
                }

                File f = new File(basePath+"/"+arduinoCliFilename);

                if(f.exists() && f.isFile()){
                    f.setExecutable(true);
                }

                System.out.println("Installed successfully!");
            }catch(Exception e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void printOk(){
        printIt(setColor(ANSI_GREEN)+"OK!\n"+setColor(ANSI_RESET), true);
    }

    private void printFailed(){
        printIt(setColor(ANSI_RED)+"Failed!\n"+setColor(ANSI_RESET), true);
    }

    private void unpackZip(File file){
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(basePath);
            System.out.println("Installed successfully!");
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    private String setColor(String color){
        if(!SystemInfo.isWindows())
            return color;
        return "";
    }

}
