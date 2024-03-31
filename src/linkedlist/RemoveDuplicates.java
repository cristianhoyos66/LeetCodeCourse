package linkedlist;

public class RemoveDuplicates {

    public static void main(String[] args) {
        TraverseLinkedList.traverseLinkedList(removeDuplicates(ListNode.of()));
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head != null) {
            var slow = head;
            var fast = head.next;
            while (slow != null) {
                if (fast == null || (slow.val != fast.val)) {
                    slow.next = fast;
                    slow = fast;
                    fast = fast == null ? fast : fast.next;
                } else {
                    fast = fast.next;
                }
            }
        }

        return head;
    }

}
