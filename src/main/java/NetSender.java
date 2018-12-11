import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;

/**
 * This class is required to send messages to the server
 */
class NetSender {

    private static final Logger log = Logger.getLogger(NetSender.class);

    private DataOutputStream output;

    /**
     *
     * @param stream
     *        Stream, in which we will write messages
     */
    NetSender(OutputStream stream) {
        output = new DataOutputStream(stream);
    }

    /**
     *
     * @param message
     *        Message which should be sent on the server
     * @return
     *        {true} if message successfully sent
     *        {false} if message was not delivered
     */
    boolean sendMessage(String message){
        try {
            output.writeUTF(message);
            return true;
        }catch (IOException | NullPointerException ex){
            log.error(ex.getMessage()+" : "+ Arrays.toString(ex.getStackTrace()));
            return false;
        }
    }
}
