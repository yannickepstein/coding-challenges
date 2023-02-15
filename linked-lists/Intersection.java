public class Intersection {

    /*
     * By indexing all nodes that we encounter, we can easily find the intersection point.
     * This requires O(n + m) space though.
     * As we have a singly linked list, we know that after the intersection points both
     * lists are equal.
     * So if n is the length of headA and m is the length of list headB, then we know if
     * n > m, then the earliest intersection can be after we have seen m-n nodes in headA
     * (similar the other way around)
     * Starting from this point we can traverse both lists in parallel, because the distance
     * from the intersection point to the end of each list must be the same for both lists.
     */
    public ListNode findIntersection(ListNode headA, ListNode headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        }
        if (lengthB > lengthA) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
