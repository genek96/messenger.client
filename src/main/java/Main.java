import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main (String[] args){

        NetSender sender = null;
        NetReciver reciver = null;
        Printer printer = new Printer();
        Authorization authorization = new Authorization();
        NetConnector connector = new NetConnector("localhost", 12345, authorization.login());
        log.info("Successful connected to server!");
        System.out.println("You are joined the chat!");
        try{
            sender = new NetSender(connector.getOutputStream());
            reciver = new NetReciver(connector.getInputStream(), printer);
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

    void testClassLoader(){
        try {
            Class a = Class.forName("factorial", false, this.getClass().getClassLoader());
            Object b = a.newInstance();
            Method[] methods = a.getMethods();
            a.getMethod("count");
            methods[0].invoke(b);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
