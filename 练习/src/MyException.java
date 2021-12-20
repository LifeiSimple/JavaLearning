import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class MyException {
    public void readData(String a) {
        try {
            if (a.length() < 5) throw new FileFormatException("sdf sdf");
        } catch (FileFormatException ffe) {
            ffe.printStackTrace();
            System.out.println(ffe.getMessage());
            System.out.println(ffe.getClass().getName());
        }
    }

    public static void main(String[] args) throws FileFormatException {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.next();
//        scan.close();
        MyException me = new MyException();
        me.readData("12");
        System.out.println("23232323");

        System.out.println("========================");
        Throwable t = new Throwable();
        StringWriter out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        System.out.println(description);
    }
}

class FileFormatException extends IOException {
    public FileFormatException() {
    }

    public FileFormatException(String gripe) {
        super(gripe);
    }
}