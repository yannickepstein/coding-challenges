public class SubsetSum {

    public List<Integer> subsetSums(int[] nums) {
        Arrays.sort(nums);
        var sums = new LinkedList<Integer>();
        findAllSubsetSums(nums, 0, sums);
    }
    
    private void findAllSubsetSums(int[] nums, int i, int sum, List<Integer> sums) {
        if (i >= nums.length) {
            sums.add(sum);
            return;
        }
        findAllSubsetSums(nums, i+1, sum + nums[i], sums);
        findAllSubsetSums(nums, i+1, sum, sums);
    }
}
