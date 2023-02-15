public class SubarrayXor {

    /**
     * @return the number of subarrays that have a bitwise XOR of all elements equal to target.
     * 
     * consider a xor b = t <-> b = t xor a
     * thus if we just maintain the prefixXors we can easily find the number of subarrays that
     * match this condition.
     */
    public int solve(int[] nums, int target) {
        int nSubarrays = 0;
        var prefixXors = new HashMap<Integer, Integer>();
        var prefix = 0; // 0 is the neutral element of xor
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix ^ nums[i];
            if (prefix == target) {
                nSubarrays++;
            }
            nSubarrays += prefixXors.getOrDefault(target ^ prefix);
            prefixXors.merge(prefix, 1, Integer::sum);
        }
        return nSubarrays;
    }
}
