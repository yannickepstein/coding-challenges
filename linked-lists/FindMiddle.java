public class FindMiddle {
    
    /**
     * l0 = n0 -> n1 -> n2 -> n3
     * return n2 because it is the second middle node
     * 
     * l1 = n0 -> n1 -> n2 -> n3 -> n4
     * return n2 because it is the only middle node
     * 
     * we can do it in two passes by finding the length of the list first
     * however, we can also do it in just one pass by having a slow and a fast pointer
     * slow moves one step at the time and fast moves two steps at the time
     * consider l0 (even):
     * slow     |       fast
     * n0       |       n0
     * n1       |       n2
     * n2       |       null -> return slow
     * 
     * consider l1 (odd):
     * slow     |       fast
     * n0       |       n0
     * n1       |       n2
     * n2       |       n4
     * n3       |       null -> return slow.prev
     * In the odd case we always iterate one node over the middle with slow, because fast needs
     * one more iteration to become null.
     * 
     * If we just keep track of length of the list, we can determine if the list is even or odd
     * and either return slow (if even) or prev (if odd).
     */
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode prev = null
        ListNode fast = head;
        int length = 0;
        while (fast != null) {
            length++;
            fast = fast.next;
            if (fast != null) {
                length++;
                fast = fast.next;
            }
            prev = slow;
            slow = slow.next;
        }
        return length % 2 == 0 ? slow : prev;
    }
}
