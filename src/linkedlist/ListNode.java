package linkedlist;

public class ListNode {
    
    public ListNode next;
    public int val;
    
    public static ListNode of() {
        var listNode = new ListNode();
        var childNode1 = new ListNode();
        listNode.next = childNode1;
        listNode.val = 1;

        var childNode2 = new ListNode();
        childNode1.next = childNode2;
        childNode1.val = 2;

        var childNode3 = new ListNode();
        childNode2.next = childNode3;
        childNode2.val = 3;

        var childNode4 = new ListNode();
        childNode3.next = childNode4;
        childNode3.val = 4;

        var childNode5 = new ListNode();
        childNode4.next = childNode5;
        childNode4.val = 5;

        childNode5.val = 10;
        
        return listNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
