package linkedlist;

public class TraverseLinkedList {

    public static void main(String[] args) {
        traverseLinkedList(ListNode.of());
    }

    public static void traverseLinkedList(ListNode head) {
        var pt = head;
        while (pt != null) {
            System.out.println(pt.val);
            pt = pt.next;
        }
    }

}
