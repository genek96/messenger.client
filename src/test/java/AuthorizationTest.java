import org.junit.Test;
import org.junit.Assert;

public class AuthorizationTest {
    @Test
    public void testLogin(){
        Authorization a1 = new Authorization();
        try{
            String login = a1.login();
        } catch (NullPointerException e){

        }
    }
}
