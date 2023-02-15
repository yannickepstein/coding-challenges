public DetectCycle {

    /**
     * @return true if the list has a cycle
     * we can easily find if the list has a cycle by using extra memory -> we just store the addresses of all visited nodes in a set
     * however, we can also find the same result without using extra memory. we do this by having two pointers slow and fast.
     * because the fast pointer reduces its distance to the slow pointer in the loop by 1 in each iteration, we will detect a cycle in
     * at most 2N, so O(n) steps.
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
