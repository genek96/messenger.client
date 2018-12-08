import org.junit.Test;

public class TyperTest {
    @Test (timeout = 250)
    public void testTyper(){
        Typer typer = new Typer(new NetSender(System.out));
        Thread testThread = new Thread(typer);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testThread.interrupt();
    }
}
