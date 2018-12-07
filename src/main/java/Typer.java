import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Typer implements Runnable{

    private static final Logger log = Logger.getLogger(Typer.class);
    private NetSender sender;

    Typer (NetSender net){
        sender = net;
        log.info("Typer is created");
    }

    @Override
    public void run() {
        log.info("Typer run");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in, StandardCharsets.UTF_8))){
            String line = "";
            log.info("Before while");
            while ((line = reader.readLine()) != null && !line.equals("/stop") && !Thread.currentThread().isInterrupted()){
                log.info("Row was reade");
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
