package 并发;

import java.util.HashMap;
import java.util.TreeSet;

public class ThreadTest {
    public static void main(String[] args) {
//        int a = 0;
//
//        Runnable task1 = () -> {
//            System.out.println(a);
//        };
//
//        Thread thread1 = new Thread(task1);
//        thread1.start();
//        String s = "a";
//        s.intern();
//
//

        HashMap<Test, Integer> map = new HashMap<>();
        for (int i = 1; i < 16; i++) {
            map.put(new Test(), i);
        }

//        TreeSet

//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> next = iterator.next();
//            System.out.println(next.getKey());
//            System.out.println(next.getValue());
//        }

    }

    static class Test {

        @Override
        public int hashCode() {
            return "3434".hashCode();
        }
    }
}
