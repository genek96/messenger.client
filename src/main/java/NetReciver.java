import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class NetReciver implements Runnable{

    private static final Logger log = Logger.getLogger(NetReciver.class);

    private DataInputStream reader;
    private Printer printer;

    public NetReciver (InputStream input, Printer printerOut){
        reader = new DataInputStream(input);
        printer = printerOut;
    }

    @Override
    public void run() {
        String message;
        while (!Thread.currentThread().isInterrupted()){
            try{
                message = reader.readUTF();
                printer.printText(message);
            } catch (IOException ex){
                log.error(ex.getMessage()+" : "+ Arrays.toString(ex.getStackTrace()));
                return;
            }
        }
    }
}
