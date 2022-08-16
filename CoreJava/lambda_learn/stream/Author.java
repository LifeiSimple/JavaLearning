package lambda_learn.stream;

import java.util.List;


public class Author {
    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Author(Long id, String name, Integer age, String intro, List<Book> books) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.intro = intro;
        this.books = books;
    }
}
