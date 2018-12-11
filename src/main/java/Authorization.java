import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class is required for authorizing.
 */
class Authorization {

    private static final Logger log = Logger.getLogger(Authorization.class);

    private String login = "";

    /**
     *
     * @return string with login, derived from system input
     */
    String login(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        login = "1";
        String name;
        do {
            name = "";
            System.out.println("Please, enter your name: ");
            try {
                name = reader.readLine();
            } catch (IOException e) {
                log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            }
        } while (name.equals(""));
        login = name;
        return name;
    }
}
