/**
 * Idea maintain two heaps: left and right
 * left is a min heap and right is a max heap
 * The median is defined as:
 * if (left.size() > right.size()) -> -left.peek()
 * if (right.size() > left.size()) -> right.peek()
 * if (right.size() == left.size()) -> ((double) (-left.peek() + right.peek())) / 2.0
 * 
 * When inserting el:
 * if (left.peek() > el) -> left.offer(el); -> balance()
 * else right.offer(el); -> balance()
 *
 * Balance:
 * if (left.size() - right.size() > 1) -> right.offer(left.poll())
 * if (right.size() - left.size() > 1) -> left.offer(right.poll())
 */
public class MedianFinder {
    
    private final PriorityQueue<Integer> left = new PriorityQueue<Integer>();
    private final PriorityQueue<Integer> right = new PriorityQueue<Integer>();

    public void addNum(int num) {
        if (left.size() > 0 && -left.peek() >= num) {
            left.offer(-num);
        } else if (right.size() > 0 && right.peek() < num) {
            right.offer(num);
        } else {
            left.offer(-num);
        }
        balance();
    }
    
    private void balance() {
        if (left.size() - right.size() > 1) {
            right.offer(-left.poll());
        }
        if (right.size() - left.size() > 1) {
            left.offer(-right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return (double) (-left.peek());
        }
        if (right.size() > left.size()) {
            return (double) (right.peek());
        }
        return ((double) -left.peek() + right.peek()) / 2.0;
    }
}