package com.p4;

import com.p4.errors.*;
import com.p4.gui.*;
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
    public static ArrayList<Board> boards;
    String basePath = System.getProperty("user.dir");
    String baseCommand = "";
    String arduinoCliFilename;
    BufferedReader stdInput;
    BufferedReader stdError;
    Process process;
    File acli;
    File arduinoCli;
    Boolean arduinoCliPresent = false;
    boolean outputInfo = false;
    ErrorBag errors;
    Board board;

    public CliExec(ErrorBag errors, boolean outputInfo) {
        this.errors = errors;
        this.outputInfo = outputInfo;
        acli = new File(basePath);

        //Enters if the OS is windows
        if (SystemInfo.isWindows()) {
            baseCommand = "arduino-cli.exe";
            arduinoCliFilename = baseCommand;
            arduinoCli = new File(basePath+"/"+baseCommand);
        }
        //Enters if the OS is mac or linux
        else {
            baseCommand = "./arduino-cli";
            arduinoCliFilename = "arduino-cli";
            arduinoCli = new File(basePath+"/arduino-cli");
        }

        checkCliInstallation();

        //Enters if the cli file exist
        if (arduinoCli.exists() && arduinoCli.isFile()) {
            arduinoCliPresent = true;
        }
        else {
            errors.addEntry(ErrorType.ARDUINO_CLI_MISSING, "Arduino CLI is missing");
        }
    }

    public void arduinoSelection() throws IOException {
        if (!arduinoCliPresent) {
            return;
        }
        boards = getBoards();
        
        //Enters if there are any boards
        if (boards.size() > 0) {
            //Enters if there are more than one board
            if (boards.size() > 1) {
                MainWindowController.showStage();
                board = ShowArduinoController.chosenBoard;
            }
            else {
                board = boards.get(0);
            }

            installBoardCore(board.getCore());
        }
        else {
            errors.addEntry(ErrorType.ARDUINO_NOT_FOUND, "No Arduino boards found. The program has still " +
                                                                 "been compiled and is located in the 'output' folder");
        }
    }

    private ArrayList<Board> getBoards() {
        ArrayList<Board> boards = new ArrayList<>();
        int portIndex = 0, nameIndex = 3;

        if (execute("board list", acli)) {
            String input = null;
            boolean firstEntry = true;

            try {
                //Runs while there still is input from the user
                while ((input = stdInput.readLine()) != null) {
                    //Enters if the input is the first or empty
                    if (firstEntry || input.equals("")) {
                        firstEntry = false;
                        continue;
                    }

                    String[] items = input.split("\\s+");
                    //Does not add bluetooth option and unknown boards
                    if (items[portIndex].contains("Bluetooth") || items[nameIndex].contains("Unknown")) {
                        continue;
                    }

                    String boardName = "";

                    for (int j = 4; j < items.length - 2; j++) {
                        boardName = boardName.concat(items[j]+" ");
                    }
                    Board board = new Board(boardName.trim(), items[items.length - 1], items[portIndex], items[items.length - 2]);
                    boards.add(board);
                }
            }
            catch(IOException e) {
                System.out.println(e);
            }
        }
        return boards;
    }

    public void compileAndUpload() {
        //Enters if a cli file and a board is present
        if (arduinoCliPresent && board != null) {
            CmdPrint.print("Compiling Arduino C code... ", true);

            //Enters if it is possible to compile
            if (execute("compile --fqbn " + board.getFqbn() + " output", acli)) {
                CmdPrint.printOk();
                CmdPrint.print("Uploading to Arduino... ", true);

                //Enters if it is possible to upload
                if (execute("upload -p " + board.getPort() + " --fqbn " + board.getFqbn() + " output", acli)) {
                    CmdPrint.printOk();
                }
                else {
                    CmdPrint.printFailed();
                }
            }
            else {
                CmdPrint.printFailed();
            }
        }
    }

    //Tries to execute a process
    //Returns true if the execution was successful
    public boolean execute(String cmd, File path) {
        try {
            //Enters if there is a standard input and error
            if (stdInput != null && stdError != null) {
                stdInput.close();
                stdError.close();
            }

            process = Runtime.getRuntime().exec(baseCommand + " " + cmd, null, path);
            //Initializes new standard input and error
            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while (process.isAlive()) { }

            //Prints all errors
            String error;
            while ((error = stdError.readLine()) != null) {
                System.out.println(error);
            }
            //Returns true if the execution was successful
            return process.exitValue() == 0;
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public void installBoardCore(String core) {
        if (arduinoCliPresent) {
            CmdPrint.print("Checking core... ", true);

            //Enters if it is possible to install the core
            if (execute("core install " + core, acli)) {
                CmdPrint.printOk();
            }
            else {
                CmdPrint.printFailed();
            }
        }
    }

    private void initializeCliSetup() {
        if (arduinoCliPresent) {
            CmdPrint.print("Updating core index... ", true);

            //Enters if it is possible to update the core index
            if (execute("core update-index", acli)) {
                CmdPrint.printOk();
            }
            else{
                CmdPrint.printFailed();
            }
        }
    }


    public void checkCliInstallation() {
        String downloadUrl = "";
        String fileName = "";
        
        if (!arduinoCli.exists() || !arduinoCli.isFile()) {
            System.out.println("The Arduino CLI does not exist on your system");
            System.out.println("Would you like to have it downloaded?");
            System.out.println("Y/N");

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    switch(SystemInfo.getOsString()) {
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

                    if (!downloadUrl.equals("")) {
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

                        if (SystemInfo.getOsString().equals("win")) {
                            unpackZip(output);
                        }
                        else {
                            unpackGZip(output);
                        }
                        output.deleteOnExit();
                    } 
                    else {
                        System.out.println("Download failed!");
                        System.out.println("Please try again");
                    }
                }
            }
            catch(Exception e) {
                System.out.println();
            }
        }
    }

    private void unpackGZip(File zipFile) {
        //https://stackoverflow.com/questions/7128171/how-to-compress-decompress-tar-gz-files-in-java
        try {
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
                    } 
                    else {
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

                if (f.exists() && f.isFile()) {
                    f.setExecutable(true);
                }

                System.out.println("Installed successfully!");
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private void unpackZip(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(basePath);
            System.out.println("Installed successfully!");
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}
