public class PairsToHoundred {

    /**
     * @return all pairs of numbers in nums that sum to 100
     * of course we could iterate over all pairs (i, j) and return all that sum to 100. However,
     * this takes O(n^2) time complexity.
     * Instead we could just iterate over nums from left to right.
     * At index i, we are essentially asking is there some index j < i, s.t. nums[i] + nums[j] = 100?
     * If we find this, we just found a pair. Assume that we don't want any duplicates, we can just transform
     * nums into a set.
     * Assumption: A pair is unique if the corresponding indices are unique. So, if we added
     * (nums[i], nums[j]), we don't add (nums[j], nums[i]).
     */
    public List<int[]> solve(int[] nums) {
        var seen = new HashSet<Integer, Integer>();
        var pairs = new LinkedList<int[]>();j
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(100 - nums[i])) {
                for (int j = 0; j < seen.get(100 - nums[i]); j++) {
                    pairs.add(new int[]{100 - nums[i], nums[i]});
                }
            }
            seen.merge(nums[i], 1, Integer::sum);
        }
        return pairs;
    }
}
