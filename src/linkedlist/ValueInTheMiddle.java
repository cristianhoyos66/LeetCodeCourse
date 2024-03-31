package linkedlist;

public class ValueInTheMiddle {

    public static void main(String[] args) {
        System.out.println(getValueInTheMiddle(ListNode.of()));
    }

    public static int getValueInTheMiddle(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

}
