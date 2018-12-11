import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import jdk.internal.loader.Loader;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main (String[] args){
        final int port;
        final String host;
        //Initialization of properties
        Properties properties = new Properties();
        try{
            properties.load((new URL(Loader.getSystemResource("config.properties").getFile())).openStream());
        } catch (MalformedURLException e){
            log.error("Can not find config file! "+e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
            return;
        } catch (IOException e) {
            log.error("Can not open config file!" + e.getMessage() + " : "+ Arrays.toString(e.getStackTrace()));
        }
        port = Integer.parseInt(properties.getProperty("port"));
        host = properties.getProperty("host");

        NetSender sender = null;
        NetReceiver reciver = null;
        Printer printer = new Printer();
        Authorization authorization = new Authorization();
        NetConnector connector = new NetConnector(host, port, authorization.login());

        log.info("Successful connected to server!");
        System.out.println("You are joined the chat!");

        try{
            sender = new NetSender(connector.getOutputStream());
            reciver = new NetReceiver(connector.getInputStream(), printer);
        } catch (IOException ex){
            log.error(ex.getMessage() + " : " + Arrays.toString(ex.getStackTrace()));
            return;
        }

        Typer typer = new Typer(sender);
        Thread outputThread = new Thread(typer);
        Thread inputThread = new Thread (reciver);

        inputThread.start();
        outputThread.start();

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage()+" : "+ Arrays.toString(e.getStackTrace()));
        }
        outputThread.interrupt();
        System.out.println("Connection closed");
    }
}
