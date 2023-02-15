public class KthLargest {

    public findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>();
        for (int n : nums) {
            if (heap.size() >= k) {
                if (heap.peek() < n) {
                    heap.poll();
                    heap.offer(n);    
                }
            } else {
                heap.offer(n);
            }
        }
        return heap.peek();
    }
}