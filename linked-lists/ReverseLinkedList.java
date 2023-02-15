public class ReverseLinkedList {
    
    /**
     * n1 -> n2 -> n3 -> n4
     * cur = n1
     * prev = null
     * 
     * Swap logic:
     * next = cur.next
     * cur.next = prev
     * prev = cur
     * cur = next
     * 
     * after cur is null, prev will be n4, so we just return prev
     */
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
