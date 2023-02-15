public class NextGreaterElement {

    /**
     * Idea: maintain a monotonic increasing stack. This means that for all elements in the stack
     * x0 | x1 | x2 | x3 it holds nums[x0] < nums[x1] < nums[x2] < nums[x4] (where x0 is the top)
     * when observing a new index i, we pop all x_j with nums[x_j] < x_0 and assign
     * their nextGreaterElements index as i.
     * We then push i onto the stack (only elements nums[x_k] > nums[i]) are then on the stack.
     * In order to deal with the wrap around property, we will just visit every index twice.
     * Afterwards there is no change to be expected.
     */
    public int[] findNextGreaterElements(int[] nums) {
        int[] nextGreaterElements = new int[nums.length];
        Arrays.fill(nextGreaterElements, -1);
        var wrapAroundCount = 0;
        var monotonicStack = new Stack<Integer>();
        for (int i = 0; i < nums.length && wrapAroundCount < 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nextGreaterElements[stack.pop()] = nums[i];
            }
            monotonicStack.push(i);
            if (i == nums.length - 1) {
                i = 0;
                wrapAroundCount++;
            }
        }
        return nextGreaterElements;
    }
}
