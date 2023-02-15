public class NextSmallerElement {

    /**
     * The next smaller element for some element at index i is some index j
     * with i < j and nums[i] > nums[j].
     * We mark all elements which don't have a next smaller element with -1.
     * We can use a monotonic stack to solve this problem. A monotonic stack has the following
     * invariant: If s0, s1, s2, s3, ..., sn are elements on the stack with s0 being the top,
     * then the stack is monotonic if and only if s0 > s1 > s2 > s3 > ... > sn.
     * If we have such a stack and we check for the next number nums[i], then if nums[i] would
     * be the next smaller element of some element sk in the stack, it will also be the next smaller
     * element for s0 ... s_(k-1). -> This can help us find the result in O(n) time.
     */
    public int[] findNextSmallerElements(int[] nums) {
        int[] nextSmallerElements = new int[nums.length];
        Arrays.fill(nextSmallerElements, -1);
        var monotonicStack = new Stack<Integer>();
        for (int n : nums) {
            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] > n) {
                nextSmallerElements[monotonicStack.pop()] = n;
            }
        }
        return nextSmallerElements;
    }
}
