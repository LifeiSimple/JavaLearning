import java.sql.SQLOutput;
import java.util.*;

public class JiHe {
    public static void main(String[] args) {
        Queue<String> expressLane = new ArrayDeque<>(100);
        expressLane.add("wangjiaxiang");

        expressLane = new LinkedList<>();
        expressLane.add("wangjiaxiang");
        expressLane.add("wangjiaxiang");
        expressLane.add("wangjiaxiang");
        expressLane.add("wangjiaxiang");
        expressLane.add("wangjiaxiang");

        Iterator<String> iter = expressLane.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }

        for (String s : expressLane) {
            System.out.println(s);
        }

        LinkedList<String> staff = new LinkedList<String>();
        staff.add("1");
        staff.add("2");
        staff.add("3");
        Iterator<String> iterator = staff.iterator();
        String first = iterator.next();
        String second = iterator.next();
        iterator.remove();
        staff.add("4");
        System.out.println(staff.toString()); // [1, 3, 4]

        ListIterator<String> listIterator = staff.listIterator();
        listIterator.next();
        listIterator.add("5");
        System.out.println(staff.toString()); // [1, 5, 3, 4]

        ListIterator<String> listIterator1 = staff.listIterator();
        listIterator1.next();
        listIterator1.set("300");
        System.out.println(staff.toString()); // [300, 5, 3, 4]

        TreeSet<String> sorter = new TreeSet<>();
        sorter.add("Bob");
        sorter.add("Amy");
        sorter.add("Carl");
        for (String s : sorter) System.out.print(s + " ");

        HashMap<String, Integer> strint = new HashMap<String, Integer>();
        strint.put("144-25-5464", 5230);
        strint.put("567-24-2546", 3242);
        strint.put("157-62-7935", 32424);
        strint.put("456-62-5527", 2340);


        System.out.println();
        Set<String> keys = strint.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        Collection<Integer> values = strint.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        Set<Map.Entry<String, Integer>> entrys = strint.entrySet();
        for (Map.Entry<String, Integer> entry : entrys) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        strint.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        HashSet<String> staff2 = new HashSet<>();
        staff2.add("1");
        staff2.add("2");
        staff2.add("3");
        staff2.add("4");
        String[] values2 = staff2.toArray(new String[0]);
        System.out.println(Arrays.toString(values2));
        System.out.println(values2.length);
        String[] values3 = new String[0];
        System.out.println(values3.length);
    }
}
