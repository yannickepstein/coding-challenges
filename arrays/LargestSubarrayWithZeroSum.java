/**
 * Given some array nums. We want to find the largest subarray with sum = 0.
 */
public class LargestSubarrayWithZeroSum {

    /**
     * Note that we can compress all subarray sums ending at each index i by maintaining
     * a map prefixSum -> [j0, j1, ...]
     * Now we want to know if there is a subarrary ending at index i that has sum 0.
     * Either prefixSum of i is 0, or there exists some index j < i with
     * prefixSum[i] - prefixSum[j] = 0 <-> prefixSum[j] = -prefixSum[i]
     * 
     * If we want to find the smallest such subarray we only need to keep track of the smallest
     * index j that fulfills the condition. If we iterate in order over the array, this means
     * we only add a new prefixSum -> index mapping if it is not yet present.
     * 
     * @return length of longest subarray or -1 if none is found with sum 0
     */
    public int solve(int[] nums) {
        var prefixSums = new HashMap<Integer, Integer>();
        var prefixSum = 0;
        var maxLength = -1;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == 0) {
                maxLength = Math.max(maxLength, i+1);
            }
            if (prefixSums.containsKey(-prefixSum)) {
                var start = prefixSums.get(-prefixSum);
                var len = i - start;
                maxLength = Math.max(maxLength, len);
            }
            prefixSums.putIfAbsent(prefixSum, i);
        }
        return maxLength;
    }
}
