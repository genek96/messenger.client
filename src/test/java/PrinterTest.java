import org.junit.Test;

public class PrinterTest {
    @Test
    public void testPrinter(){
        Printer printer = new Printer();
        printer.printText("");
        printer.printText("123");
        printer.printText(null);
    }
}
