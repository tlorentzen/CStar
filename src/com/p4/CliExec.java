package com.p4;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.ArrayList;

public class CliExec {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


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

    public CliExec(ErrorBag errors, boolean outputInfo){
        this.errors = errors;
        this.outputInfo = outputInfo;
        File arduinoCli;
        acli = new File(basePath);

        if(SystemInfo.isWindows()){
            baseCommand = "arduino-cli-win.exe";
            arduinoCliFilename = baseCommand;
            arduinoCli = new File(basePath+"/"+baseCommand);
        }else{
            baseCommand = "./arduino-cli-"+SystemInfo.getOsString();
            arduinoCliFilename = "arduino-cli-"+SystemInfo.getOsString();
            arduinoCli = new File(basePath+"/arduino-cli-"+SystemInfo.getOsString());
        }

        if(arduinoCli.exists() && arduinoCli.isFile()){
            arduinoCliPresent = true;
            /*
            ArrayList<Board> boards = getBoards();
            Board board = null;

            int counter = 1;

            if(boards.size() > 0){
                if(boards.size() > 1){
                    System.out.println("Select Arduino:");
                    for (Board b: boards) {
                        System.out.println("  "+counter+" ) "+ b.name+" - "+b.port);
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
                }else{
                    board = boards.get(0);
                }

                checkCoreInstallation(board);
                compileAndUpload(board);
            }else{
                errors.addEntry(ErrorType.ARDUINO_NOT_FOUND, "No Arduino boards found");
            }
             */
        }else{
            errors.addEntry(ErrorType.ARDUINO_CLI_MISSING, "Arduino CLI is missing");
        }
    }

    public void arduinoSelection(){
        initializeCliSetup();

        if(!arduinoCliPresent)
            return;
        
        ArrayList<Board> boards = getBoards();
        int counter = 1;

        if(boards.size() > 0){
            if(boards.size() > 1){
                System.out.println();
                System.out.println("Select Arduino:");
                for (Board b: boards) {
                    System.out.println("  "+counter+") "+ b.name+" - "+b.port);
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

            installBoardCore(board.core);
        }else{
            errors.addEntry(ErrorType.ARDUINO_NOT_FOUND, "No Arduino boards found");
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

                    if(items[0].contains("Bluetooth")){
                        continue;
                    }

                    Board board = new Board();
                    board.port = items[0];
                    board.core = items[items.length-1];
                    board.fqbn = items[items.length-2];

                    for(int j=4; j < items.length-2; j++){
                        board.name = board.name.concat(items[j]+" ");
                    }

                    board.name = board.name.trim();
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

            if(execute("compile --fqbn "+board.fqbn+" output", acli)){
                printIt(ANSI_GREEN+"OK!\n"+ANSI_RESET, true);
                printIt("Uploading to Arduino... ", true);

                if(execute("upload -p "+board.port+" --fqbn "+board.fqbn+" output", acli)){
                    printIt(ANSI_GREEN+"OK!\n"+ANSI_RESET, true);
                }else{
                    printIt(ANSI_RED+"Failed!\n"+ANSI_RESET, true);
                }
            }else{
                printIt(ANSI_RED+"Failed!\n"+ANSI_RESET, true);
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
                printIt(ANSI_GREEN+"OK!\n"+ANSI_RESET, true);
            }else{
                printIt(ANSI_RED+"Failed!\n"+ANSI_RESET, true);
            }
        }
    }

    private void initializeCliSetup(){
        if(arduinoCliPresent){
            printIt("Updating core index... ", true);

            if(execute("core update-index", acli)){
                printIt(ANSI_GREEN+"OK!\n"+ANSI_RESET, true);
            }else{
                printIt(ANSI_RED+"Failed!\n"+ANSI_RESET, true);
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
}
