import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetConnector {

    private Socket socket;

    public NetConnector(String host, int port) throws IOException {
        socket = new Socket(host, port);
        socket.setSoTimeout(0);
    }

    public InputStream getInputStream() throws IOException{
        return socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException{
        return socket.getOutputStream();
    }
}
