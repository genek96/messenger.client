import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetConnector {

    private Socket socket;

    NetConnector(String host, int port, String login) throws IOException {
        socket = new Socket(host, port);
        socket.setSoTimeout(0);
        //sending login
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF(login);
//        output.close();

    }

    InputStream getInputStream() throws IOException{
        return socket.getInputStream();
    }

    OutputStream getOutputStream() throws IOException{
        return socket.getOutputStream();
    }
}
