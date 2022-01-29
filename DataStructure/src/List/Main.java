package List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A", 0);
        list.add("B", 0);
        list.add("C", 0);
        list.add("D", 0);
        list.add("E", 0);
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.get(3));

        System.out.println("=========================");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("A", 0);
        list2.add("B", 0);
        list2.add("C", 0);
        list2.add("D", 0);
        list2.add("E", 0);
        System.out.println(list2);
    }
}
