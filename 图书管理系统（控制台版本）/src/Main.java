import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> LIST = new ArrayList<>();

    public static void main(String[] args) {
        readData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======== 图书管理系统 ========");
            System.out.println("1.插入信息");
            System.out.println("2.修改信息");
            System.out.println("3.查询图书列表");
            System.out.println("4.删除图书");
            System.out.println("（按其他任意键退出系统）");
            String str = scanner.nextLine();
            switch (str) {
                case "1":
                    insertBook(scanner);
                    break;
                case "2":

                    break;
                case "3":
                    showBook();
                    break;
                case "4":

                    break;
                default:
                    saveData();
                    scanner.close();
                    return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void readData() {
        File file = new File("图书管理系统（控制台版本）/src/data");
        if (file.exists()) {
            try(ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream("图书管理系统（控制台版本）/src/data"))) {
                LIST = (List<Book>) inputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            LIST = new ArrayList<>();
        }


    }

    private static void saveData() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("图书管理系统（控制台版本）/src/data"))) {
            outputStream.writeObject(LIST);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showBook() {
        LIST.forEach(System.out::println);
    }

    private static void insertBook(Scanner scanner) {
        Book book = new Book()
                .name(scanner.nextLine())
                .author(scanner.nextLine())
                .price(scanner.nextDouble());
        scanner.nextLine();
        LIST.add(book);

    }

    private static class Book implements Serializable{
        String name;
        String author;
        double price;

        //        public Book(String name, String author, double price) {
//            this.name = name;
//            this.author = author;
//            this.price = price;
//        }
        public Book name(String name) {
            this.name = name;
            return this;
        }

        public Book author(String author) {
            this.author = author;
            return this;
        }

        public Book price(double price) {
            this.price = price;
            return this;
        }

        @Override
        public String toString() {
            return "书籍{" +
                    "名称='" + name + '\'' +
                    ", 作者='" + author + '\'' +
                    ", 价格=" + price +
                    '}';
        }
    }
}
