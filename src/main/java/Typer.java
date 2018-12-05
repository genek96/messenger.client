import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Typer implements Runnable{

    private static final Logger log = Logger.getLogger(Typer.class);
    private NetSender sender;

    Typer (NetSender net){
        sender = net;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in, StandardCharsets.UTF_8))){
            String line;

            while ((line = reader.readLine()) != null && !line.equals("/stop") && !Thread.currentThread().isInterrupted()){
                if (sender.sendMessage(line)){
                    System.out.println("delivered");
                } else {
                    System.out.println("not delivered");
                }
            }
        } catch (IOException ex){
            log.error(ex.getMessage() + " : " + Arrays.toString(ex.getStackTrace()));
        }
    }
}
