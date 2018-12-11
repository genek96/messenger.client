import java.io.PrintStream;

/**
 * This class is required to print information for users
 */
class Printer {
    private PrintStream stream;

    Printer(){
        stream = System.out;
    }

    /**
     *
     * @param text
     *        Message, which will be shown for the user
     */
    void printText(String text){
        stream.println(text);
    }
}
