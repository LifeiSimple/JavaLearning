package v1ch04;

public class ConstructorTest {
    public static void main(String[] args) {
        Test t = new Test("xiang", 20);
    }

    static {
        System.out.println("初始化块内容23333");

    }
}

class Test {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static int id = 0;

    {
        name = "wangjiaxiang";
//        age = 25;
        id = id + 1;
        System.out.println("初始化块内容1");
        System.out.println(name);
        System.out.println(age);
        System.out.println(id);
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
        id = id + 1;
        System.out.println("构造器内容2");
        System.out.println(name);
        System.out.println(age);
        System.out.println(id);
    }


}
