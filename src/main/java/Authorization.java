import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Authorization {

    private static final Logger log = Logger.getLogger(Authorization.class);

    private String login = "";

    String login(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        while (name.equals("")) {
            System.out.println("Please, enter your name: ");
            try {
                name = reader.readLine();
            } catch (IOException e) {
                log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            }
        }
        login = name;
        return name;
    }
}
