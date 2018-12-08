import org.junit.Test;

public class NetConnectorTest {
    @Test
    public void testConstructor(){
        new NetConnector("123", 1,"");
        new NetConnector("123", 1,"");
        new NetConnector("123", -1,"");
        new NetConnector("123", 1,null);
    }
}
