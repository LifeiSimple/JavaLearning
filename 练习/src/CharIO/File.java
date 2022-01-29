package CharIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("练习/src/CharIO/File.txt");
             FileWriter writer = new FileWriter(("练习/src/CharIO/File2.txt"))) {
            char[] chars = new char[16];
            int temp;
            while ((temp = reader.read(chars)) != -1) {
                System.out.println(temp);
                writer.write(chars, 0, temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
