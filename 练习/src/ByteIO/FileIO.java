package ByteIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) throws FileNotFoundException {

//        FileInputStream inputStream = null;
//
//        try {
//            inputStream = new FileInputStream("D:\\学习\\代码\\Java\\java基础学习\\练习\\src\\IO\\File.txt");
//
//        } catch (FileNotFoundException f) {
//            f.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        try (FileInputStream inputStream =
                     new FileInputStream("练习/src/IO/File.txt");
             FileOutputStream outputStream =
                     new FileOutputStream("练习/src/IO/File2.txt", true)) {
            int temp;
            byte[] bytes = new byte[16];
            while ((temp = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
