public class MergeSortedLists {

    /**
     * Assumption: leftHead and rightHead are both sorted
     * @return list that contains all nodes from leftHead and rightHead in sorted order
     * 
     * We iterate over leftHead and rightHead in parallel (pointers left and right)
     * We also keep track of the previously picked node, because we need to change its
     * next pointer to the next picked node.
     * To have an easy time returning the new list, we can calculate the new head outside
     * the loop.
     * 
     * leftHead = 1 -> 2 -> 4   rightHead = 0 -> 3 -> 5 
     * newHead = 0 (-> 3 -> 5) | prev = 0 (-> 3 -> 5) | left = 1 -> 2 -> 4 | right = 3 -> 5
     * ListNode next = left.val <= right.val ? left : right
     * prev.next = next (newHead = 0 -> 1 (-> 2 -> 4))
     * prev = next
     */
    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode newHead = null;
        ListNode prev = null;
        
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newHead = list1;
                prev = newHead;
                list1 = list1.next;
            } else {
                newHead = list2;
                prev = newHead;
                list2 = list2.next;
            }
        } else if (list1 != null && list2 == null) {
            newHead = list1;
            prev = newHead;
            list1 = list1.next;
        } else if (list1 == null && list2 != null) {
            newHead = list2;
            prev = newHead;
            list2 = list2.next;
        }

        while (leftHead != null && rightHead != null) {
            ListNode next = leftHead.val <= rightHead.val ? leftHead : rightHead;
            if (leftHead.val <= rightHead.val) {
                leftHead = leftHead.next;
            } else {
                rightHead = rightHead.next;
            }
            prev.next = next;
            prev = next;
        }
        
        prev.next = leftHead != null ? leftHead : rightHead; 
        return newHead;
    }
}
