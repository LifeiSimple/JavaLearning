// 链表结构
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode203 {
    /**
     * 用于删除指定内容的节点，返回剩余链表的头节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode fakehead = new ListNode(Integer.MAX_VALUE, head);// 人为设置一个头节点
        ListNode cur_node = fakehead;
        while (cur_node.next != null) {
            if (cur_node.next.val == val) {
                cur_node.next = cur_node.next.next;
            }
            else cur_node = cur_node.next;
        }
        return fakehead.next;
    }

    /**
     * 用来遍历输出链表内容
     * @param head  需要遍历输出的链表头节点
     */
    public static void ListPrint(ListNode head) {
        ListNode cur_node = new ListNode(0, head);
        while (cur_node.next != null) {
            System.out.println(cur_node.next.val);
            cur_node = cur_node.next;
        }
    }

    // 测试
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6, null)))))));
        ListNode head2 = new ListNode(7,
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7, null))));
        ListPrint(head2);
        System.out.println("=================");
        ListPrint(removeElements(head, 6));
    }
}