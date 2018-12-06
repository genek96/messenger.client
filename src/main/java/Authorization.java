import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Authorization {

    private static final Logger log = Logger.getLogger(Authorization.class);

    private String login = "";

    public String login(){
        DataInputStream stream = new DataInputStream(System.in);
        String name = "";
        while (name.equals("")){
            try {
                name = stream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            }
        }
        login = name;
        return name;
    }
}
