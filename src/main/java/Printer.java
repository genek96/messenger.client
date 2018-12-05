import java.io.PrintStream;

class Printer {
    private PrintStream stream;

    Printer(){
        stream = System.out;
    }

    void printText(String text){
        stream.println(text);
    }
}
