package com.p4;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.ArrayList;

public class CliExec {

    String basePath = System.getProperty("user.dir");
    String baseCommand = "";
    String arduinoCliFilename;
    BufferedReader stdInput;
    BufferedReader stdError;
    Process p;
    File acli;

    public CliExec(ErrorBag errors){
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
        }else{
            errors.addEntry(ErrorType.ARDUINO_CLI_MISSING, "Arduino CLI is missing");
        }
    }

    private ArrayList<Board> getBoards(){

        ArrayList<Board> boards = new ArrayList<>();

        try{
            p = Runtime.getRuntime().exec(baseCommand+" board list", null, acli);

            stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String s = null;
            int counter = 0;
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
        }catch(Exception e){
            System.out.println(e);
        }

        return boards;
    }

    private void checkCoreInstallation(Board board){
        try{
            p = Runtime.getRuntime().exec(baseCommand+" core install "+board.core, null, acli);

            stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String s = null;
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void compileAndUpload(Board board){

        board.printInfo();
        System.out.println("### Compiling ###");

        try{
            p = Runtime.getRuntime().exec(baseCommand+" compile --fqbn "+board.fqbn+" output", null, acli);

            stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println();
            System.out.print("Uploading...");

            p = Runtime.getRuntime().exec(baseCommand+" upload -p "+board.port+" --fqbn "+board.fqbn+" output", null, acli);

            stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.out.print(" Done!");
            System.out.println();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
