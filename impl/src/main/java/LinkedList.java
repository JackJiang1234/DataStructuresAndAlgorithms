/**
 *
 * 测试链表特性
 *
 *
 * */
public class LinkedList {

    /**
     * 单链表反转
     * */
    public static Node reverse(Node list) {
        return null;
    }

    /**
     * 检测环
     * 思路1. 把遍历过的链表结点存储到集合或hashtable，每遍历一个结点检查在集合中是否存在，存在则存在环，否则不存在
     * 思路2. 快慢指针，如果存在环，必然有结点相交，相交的结点满足crossNode
     * */
    public static boolean checkCircle(Node list) {
        if (list == null){
            return false;
        }

        Node fast,slow;
        fast = slow = list;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }

        return false;
    }

    /**
     * 有序链表合并
     * */
    public static Node mergeSortedLists(Node la, Node lb) {
       return null;
    }

    /**
     * 删除倒数第K个结点
     * */
    public static Node deleteLastKth(Node list, int k) {
        return null;
    }

    /**
     * 求中间结点
     * */
    public static Node findMiddleNode(Node list) {
        return null;
    }

    /**
     * 链表是否交叉
     * */
    public static boolean checkHasCross(Node list1, Node list2){
        return true;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}
