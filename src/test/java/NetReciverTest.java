import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NetReciverTest {
    private NetReciver reciver;
    private Printer printer;

    @Before
    public void constructor(){
        InputStream input = mock(InputStream.class);
        printer = new Printer();
        reciver = new NetReciver(input, printer);
    }

    @Ignore //TODO think, how to solve this test
    @Test (timeout = 250)
    public void testRun(){
        Thread testThread = new Thread(reciver);
        reciver.run();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testThread.interrupt();
    }
}
