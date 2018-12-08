import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class NetConnector {

    private static final Logger log = Logger.getLogger(NetConnector.class);
    private Socket socket;

    NetConnector(String host, int port, String login) {
        try {
            socket = new Socket(host, port);
            socket.setSoTimeout(0);
            //sending login
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(login);
        } catch (IOException e) {
            log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            System.err.println(e.getMessage());
        } catch (Throwable e) {
            log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }

    }

    InputStream getInputStream() throws IOException{
        return socket.getInputStream();
    }

    OutputStream getOutputStream() throws IOException{
        return socket.getOutputStream();
    }
}
