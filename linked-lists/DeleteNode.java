public class DeleteNode {

    /**
     * Deletes the given node from the corresponding linked list.
     * This is not really possible, because we don't have the reference to the node.
     * Instead we could modify the current node to equal the next node and just delete the
     * next node. This only works if the next node is not null.
     */
    public void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next; // sufficient for GC to kick in
    }
}
