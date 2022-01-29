// reuse/Cartoon.java
// 继承时调用构造器

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class JiCheng extends Drawing {
    public static void main(String[] args) {
        JiCheng x = new JiCheng();
    }
}
/* 输出：
Art constructor
Drawing constructor
Cartoon constructor
*/

class Super {
    public int field = 0;
    public int getField() { return field; }
}

class Sub extends Super {
    public int field = 1;
    @Override public int getField() { return field; }
    public int getSuperField() { return super.field; }
}

class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // 向上转型
        System.out.print("sup.field = " + sup.field);
        System.out.println(", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.print("sub.field = " + sub.field);
        System.out.print(", sub.getField() = " + sub.getField());
        System.out.println(", sub.getSuperField() = " + sub.getSuperField());
    }
}