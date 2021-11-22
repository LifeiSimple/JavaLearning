package v1ch04;

public class StaticMethod {
    public static void main(String[] args) {
        st s = new st("wangjiaxiang", 25);
        System.out.println(st.getId());
        st.ageaddidandreturn(5);
        System.out.println(st.getId());
    }
}

class st {
    private String name;
    private int age;

    public static int getId() {
        return id;
    }

    static int id = 1;

    public st(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void ageaddidandreturn(int number) {
        id = id + number;
    }

}
