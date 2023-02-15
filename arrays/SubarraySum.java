public class SubarraySum {
    
    /**
     * @return the number of subarrays whose sum equals k
     * 
     * Definition Subarray: nums[i:j] is the subarray between index i and j
     *
     * Definition "Prefix Sum": The prefix sum of an index i is sum(nums[0:i])
     * 
     * Consider the prefix sum at index i.
     * The number of subarrays ending at index i and having sum k
     * is equal to the number of indices j <= i with
     * prefixSum[j] = prefixSum[i] - k. 
     * This is because each such index defines a subarray
     * nums[j, i] with sum = prefixSum[i] - prefixSum[j].
     * Essentially we compress all subarray sum ending at some index i
     * into a hash map.
     */
    public static int solve(int[] nums, int k) {
        var prefixSums = new HashMap<Integer, Integer>();
        var prefixSum = 0;
        var nSubarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) { // covers nums[0:i]
                nSubarrays++;
            }
            nSubarrays += prefixSums.getOrDefault(prefixSum - k, 0);
            prefixSums.merge(prefixSum, 1, Integer::sum);
        }
        return nSubarrays;
    }
}
