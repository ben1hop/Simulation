package base.simulation.gameLogic.Tools;

import java.io.*;

public class FileStream {

    public BufferedReader reader = null;
    public BufferedWriter writer = null;

    public FileStream(FileStreamDirection direction , File file) {

        if(direction == FileStreamDirection.Read) {
            try{
                reader = new BufferedReader(new FileReader(file));
            }catch(IOException err){
                System.err.format("File output error: "+err);
            }
        }
        else if(direction == FileStreamDirection.Write){
            try{
                writer = new BufferedWriter(new FileWriter(file));
            }catch(IOException err){
                System.err.format("File output error: "+err);
            }
        }else{
            System.out.println("Shet");
        }
    }

}
