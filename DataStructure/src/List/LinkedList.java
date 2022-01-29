package List;

public class LinkedList<E> extends AbstractList<E> {
    // 带头结点的实现
    private Node<E> head = new Node<>();
    private int size = 0;

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node() {
            this.next = null;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("非法的插入位置"); // 检查位置是否合法
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<E> temp = node.next;
        node.next = new Node<>(e);
        node.next.next = temp;
        size++;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("arr=[");
        Node<E> cur_node = head;
        while (cur_node.next!=null) {
            if (cur_node.next.next == null) {
                str.append(cur_node.next.e).append("");
                break;
            }
            str.append(cur_node.next.e).append(", ");
            cur_node = cur_node.next;
        }
        return "LinkedList{" +
                str.toString() +
                "], size=" + size +
                '}';
    }
}
