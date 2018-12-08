import org.junit.Before;
import org.junit.Test;


public class NetSenderTest {
    private NetSender sender;

    @Before
    public void init(){
        sender = new NetSender(System.out);
    }

    @Test
    public void testSend(){
        sender.sendMessage("");
        sender.sendMessage("asd");
        sender.sendMessage(null);
    }
}
