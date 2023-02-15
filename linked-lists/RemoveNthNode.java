public class RemoveNthNode {

    /**
     * @return linked list with the n-th from the back removed
     * it is quite obvious how to do it in two pass (find length, then go to the n-th node from the back and remove it)
     * 
     * one pass:
     * we are essentially looking for the node at index len(head) - n
     * we can do so in one pass by using extra space:
     * we just index the nodes and then jump into the one that we are looking for to remove it
     * 
     * Another possibility is to give a fast pointer a jump start of n nodes.
     * If that pointer reaches null, it will be exactly n nodes before a slow pointer that
     * started at the head -> this finds the desired node.
     * To find the node before it, we stop once fast.next == null.
     */
    public ListNode remove(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast != null ? fast = fast.next : null;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next != null ? slow.next.next : null;
        return head;
    }
}
