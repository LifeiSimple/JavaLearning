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