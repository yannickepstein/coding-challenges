public class CombinationSum {

    /**
     * Integers in nums are unique. We are interested in all unique combinations
     * that sum to target. We may pick any integer in nums an unlimited amount of times.
     * Assumption: Integers are only positive (> 0). If they are not then there can be an
     * infinite number of combinations. A possible restriction would be to pick each integer
     * at most k times in case of negative integers being allowed.
     */
    public List<List<Integer>> findCombinations(int[] nums, int target) {
        var combinations = new LinkedList<List<Integer>>();
        generate(nums, 0, new LinkedList<Integer>(), 0, target, combinations);
        return combinations;
    }
    
    /**
     * There are the following cases:
     * - add the number to the combination
     * - don't add the number and skip to the next one
     * O(2^t) time complexity, because t is the upper bound on the height of the
     * recursion tree.
     */
    private void generate(
        int[] nums,
        int index,
        LinkedList<Integer> combination, 
        int sum,
        int target,
        List<List<Integer>> combinations
    )
    {
        if (sum == target) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        
        if (index >= nums.length || sum > target) {
            return; // cannot improve
        }
        
        combination.add(nums[index]);
        generate(nums, index, combination, sum + nums[index], target, combinations);
        combination.removeLast();
        generate(nums, index+1, combination, sum, target, combinations);
    }
}
