import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;

class NetSender {

    private static final Logger log = Logger.getLogger(NetSender.class);

    private DataOutputStream output;

    NetSender(OutputStream stream) {
        output = new DataOutputStream(stream);
    }

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
