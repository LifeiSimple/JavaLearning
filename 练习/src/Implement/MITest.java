package Implement;

public class MITest implements MyImplement {
    private String tString;

    public MITest(String s) {
        this.settString(s);
    }

    public String gettString() {
        return tString;
    }

    public void settString(String tString) {
        this.tString = tString;
    }

    @Override
    public String testString(String s) {
        String s1 = this.gettString() + s + "add string test";
        return s1;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClonePerson tcp = new TestClonePerson("wang",24,"2333332");
        TestClonePerson tcp2 = (TestClonePerson) tcp.clone();
        System.out.println(tcp.toString());
        System.out.println(tcp2.toString());
        System.out.println(tcp == tcp2);
        tcp2.ds.setDescribe("jia");
        tcp.ds.setDescribe("wangjiaxiang");
        System.out.println(tcp.toString());
        System.out.println(tcp2.toString());
    }
}

class TestClonePerson implements Cloneable{
    private String name;
    private int age;
    DescribePerson ds;

    TestClonePerson(String name, int age, String ds) {
        setAge(age);
        setName(name);
        this.ds = new DescribePerson(ds);
    }

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TestClonePerson cloned = (TestClonePerson) super.clone();
        cloned.ds = new DescribePerson(this.ds.getDescribe());
        return cloned;
    }

    @Override
    public String toString() {
        return "Implement.TestClonePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ds=" + ds.getDescribe() +
                '}';
    }
}

class DescribePerson implements Cloneable{
    private String describe;
    DescribePerson(String ds) {
        this.describe = ds;
    }
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}