/**
 * Invariant of a heap: First element is always the smallest.
 * Inserting and element should work in O (log n) time.
 * Heaps are implemented as binary trees, where a node is a parent of two other nodes
 * if it is smaller than its too children (or larger if we implement a max heap).
 * By defining the binary tree with this property, we can actually implement it without any
 * pointers. We just store it in a flat array.
 */
public class MinHeap {
    
    private final List<Integer> elements = new ArrayList<Integer>();

    /**
     * @return top element (smallest element in the heap)
     */
    public Integer top() {
        return elements.get(0);
    }

    /**
     * Removes the current top element and makes sure the invariant still holds.
     * @return smallest element in the heap at time of calling the method
     */ 
    public Integer pop() {
        var topEl = top();
        if (elements.size() > 1) {
            elements.set(0, elements.get(elements.size() - 1));
        }
        elements.removeLast();
        bubbleDown(0);
        return topEl;
    }
    
    /**
     * Inserts the element into the heap and makes sure that the invariant holds.
     */
    public void insert(int el) {
        elements.add(el);
        bubbleUp(elements.size() - 1);
    }
    
    private int bubbleUp(int pos) {
        var parentPos = findParentPos(pos);
        if (parentPos == -1) {
            return;
        }
        
        if (elements.get(parentPos) > elements.get(pos)) {
            swap(parentPos, pos);
            bubbleUp(parentPos);
        }
    }
    
    private int bubbleDown(int pos) {
        var leftChildPos = findLeftChildPos(pos);
        if (leftChildPos == -1) {
            return;
        }
        
        if (elements.get(leftChildPos) < elements.get(pos)) {
            swap(leftChildPos, pos);
            bubbleDown(leftChildPos);
        }
    }
    
    private int findLeftChildPos(int pos) {
        return 2 * pos < elements.size() ? 2 * pos : -1;
    }
    
    private int findParentPos(int pos) {
        return pos == 1 ? -1 : ((int) Math.floor(pos / 2));
    }
    
    private void swap(int pos1, int pos2) {
        int tmp = elements.get(pos1);
        elements.set(pos1, elements.get(pos2));
        elements.set(pos2, elements.get(pos1));
    }
}
