public class ReverseGroup {

    /**
     * @return the head of the new list
     * Reverses the list in groups of k elements.
     * k = 2, head = 0 -> 1 -> 2 -> 3 -> 4
     * reverse(head, k) = (1 -> 0) -> (3 -> 2) -> 4
     * 
     * Idea have a pointer that tries to jump k steps to the end node of the group.
     * Then reverse the group, and set previousEnd.next to start of the reversed group.
     * Note we need to handle the case of the newHead.
     */
    public ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null) {
            ListNode start = fast;
            for (int i = 1; i < k; i++) {
                fast = fast != null ? fast.next : null;
            }
            if (fast != null) {
                ListNode next = fast.next;
                reverseGroup(start, fast); // fast will be the new start
                if (newHead == null) {
                    newHead = fast;
                }
                if (prev != null) {
                    prev.next = fast;
                }
                prev = start;
                start.next = next; // make sure that if there is no next reversal, the remaining sublist is reachable
                fast = next;
            }
        }
        return newHead != null ? newHead : head;;
    }
    
    // reverse the given list in between start and end
    private void reverseGroup(ListNode start, ListNode end) {
        ListNode cur = start;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur == end ? null : cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
