package lambda_learn.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        stream
                .distinct()
                .filter(author -> author.getAge()<18)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 36, "一个菜刀祖安人", null);
        Author author3 = new Author(3L, "易建联", 5, "一个明悟哲理的祖安人", null);
        Author author4 = new Author(4L, "易", 5, "菜刀中明悟哲理的祖安人", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "那风吹不到的地方", "哲学，爱情", 85, "带你用思维去领略世界的尽头"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长，爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情，个人传记", 55, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books1.add(new Book(5L, "你的剑就是我的剑", "哲学", 36, "无法想象一个武者能对她的伴侣这么的宽容"));
        books1.add(new Book(6L, "风雨剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books1.add(new Book(6L, "风雨剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;
    }

}
