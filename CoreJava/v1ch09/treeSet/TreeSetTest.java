package v1ch09.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Item> parts = new TreeSet<Item>();
        parts.add(new Item("b", 1234));
        parts.add(new Item("c", 4562));
        parts.add(new Item("A", 9912));
        parts.add(new Item("d", 1224));
        parts.add(new Item("B", 4564));
        parts.add(new Item("G", 9999));
        System.out.println(parts);

        TreeSet<Item> sortByDescription =
                new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
