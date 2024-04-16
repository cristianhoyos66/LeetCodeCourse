package linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = ListNode.of();

        ListNode curr = head;
        ListNode p = null;
        ListNode f = head;

        while (curr != null) {
            f = curr.next;
            curr.next = p;
            p = curr;
            curr = f;
        }

        var pt = p;
        while (pt != null) {
            System.out.println(pt.val);
            pt = pt.next;
        }

    }

}
