class Insect {
    private int i = 9;
    protected int j;
    private static int xx;
    private int xxx;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);					// [6]
//        System.out.println(xx);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");					// [1]

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

    static {
//        System.out.println(xx);
        xx = printInit("static Insect.xx static block initialized");	// [2]
    }

    {
//        System.out.println(xxx);
        xxx = printInit("static Insect.xxx block initialized");			// [5]
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");					// [7]

    public Beetle() {
        System.out.println("k = " + k);									// [8]
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");					// [3]

    public static void main(String[] args) {
        System.out.println("Beetle constructor");						// [4]
        Beetle b = new Beetle();
    }
}

/* 输出如下：
static Insect.x1 initialized
static Insect.xx static block initialized
static Beetle.x2 initialized
Beetle constructor
static Insect.xxx block initialized
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*/