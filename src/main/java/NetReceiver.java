import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * This class should be used in the special thread.
 * It will receive messages from server.
 */
public class NetReceiver implements Runnable{

    private static final Logger log = Logger.getLogger(NetReceiver.class);

    private DataInputStream reader;
    private Printer printer;

    /**
     *
     * @param input
     *        Stream, from which messages will be read
     * @param printerOut
     *        Stream, which will print this message to user
     */
    NetReceiver(InputStream input, Printer printerOut){
        reader = new DataInputStream(input);
        printer = printerOut;
    }

    /**
     * This method is waiting new messages and print them into printer,
     * defined in the constructor
     */
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
