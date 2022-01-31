package v1ch05.MyTest;

public class Test2 extends Test {
    private String t2;

    public Test2(String t, String t2) {
        super(t);
        this.t2 = t2;
    }

    public void getStringT() {
        System.out.println("Test2:t2=" + this.t2);
        super.getStringT();
    }


    public static void main(String[] args) {
        Test T1 = new Test("xiang");
        Test2 T2 = new Test2("wang", "jia");


        System.out.println("1=================1");
        Test[] TT = new Test[2];

        TT[0] = T1;
        TT[1] = T2;

        for (Test t : TT) {
            t.getStringT();
        }

        System.out.println("2=================2");
        System.out.println(T1 instanceof Test2);
        System.out.println(T2 instanceof Test);

        System.out.println("3=================3");
        Object obj = new Test("wangjiaxiang");
        Test T3 = (Test) obj;
//        Test2 T3 = (Test2) obj; obj实际指向的是Test类对象，则obj只能强制转换成Test类
        T3.getStringT();
        System.out.println(obj.equals(T3));
        System.out.println(obj.getClass());
        System.out.println(T1.getClass());
        System.out.println(T2.getClass());
        System.out.println(T3.getClass());
        System.out.println("4=================4");
        Object obj2 = new Object();
        System.out.println(T1 == T1);
        System.out.println("test||"+T3);
    }
}
