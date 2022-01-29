package FileClass;


import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:/");
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.listFiles()));
        for (File f : file.listFiles()) {
            System.out.println(f.getAbsoluteFile());
        }
        
    }
}