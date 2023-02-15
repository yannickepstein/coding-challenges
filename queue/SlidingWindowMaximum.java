public class SlidingWindowMaximum {

    public int[] findWindowMax(int[] nums, int k) {
        var maxWindows = new int[nums.length - k + 1];
        var window = new LinkedList<Integer>();
        var right = 0;
        while (right < k-1) {
            while (!window.isEmpty() && nums[window.getLast()] <= nums[right]) {
                window.removeLast();
            }
            window.addLast(right);
            right++;
        }
        var left = 0;
        while (right < nums.length) {
            while (!window.isEmpty() && nums[window.getLast()] <= nums[right]) {
                window.removeLast();
            }
            window.addLast(right);
            if (window.getFirst() < left) {
                window.removeFirst();
            }
            maxWindows[left] = nums[window.getFirst()];
            right++;
            left++;
        }
        return maxWindows;
    }
}
