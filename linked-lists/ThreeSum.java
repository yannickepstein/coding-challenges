public class ThreeSum {

    /**
     * We are looking for unique triplets [nums[i], nums[j], nums[k]], s.t. i != j, j != k, i != k
     * and nums[i] + nums[j] + nums[k] = 0.
     * Let's say we fix the inter i = 0, then we are just looking for a pair j, k, s.t.
     * i != j, j != k, i != k and nums[j] + nums[k] = -nums[i].
     * This can be done in O(n) time, by starting at index 1 and the checking for every index j
     * if there is some index k < j with nums[k] = -nums[i] - nums[j].
     */
    public List<int[]> findTriplets(int[] nums) {
        var triplets = new LinkedList<int[]>();
        for (int i = 0; i < nums.length-2; i++) {
            var tuples = findTuples(nums, i+1, -nums[i]);
            for (var tuple : tuples) {
                triplets.add(new int[]{nums[i], tuple[0], tuple[1]});
            }
        }
        return triplets;
    }
    
    private List<int[]> findTuples(int[] nums, int start, int target) {
        var index = new HashMap<Integer, List<Integer>>();
        var tuples = new LinkedList<int[]>();
        for (int i = start; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                for (int j : index.get(target - nums[i])) {
                    tuples.add(new int[]{nums[j], nums[i]});
                }
            }
            index.putIfAbsent(nums[i], new LinkedList<Integer>());
            index.get(nums[i]).add(i);
        }
        return tuples;
    }
}
