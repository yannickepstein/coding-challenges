public class Subsets {

    /**
     * At each point in time, we can 
     * - add the current element to the current subset or skip it
     * We will generate duplicates if we skip some element, and that element has duplicates afterwards.
     * So if we decide to skip some element, then we need to skip all of the same value.
     */
    public List<List<Integer>> findAllSubsets(int[] nums) {
        var subsets = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        generate(nums, 0, new LinkedList<Integer>(), new HashSet<Integer>(), subsets);
        return subsets;
    }
    
    private void generate(int[] nums, int i, LinkedList<Integer> subset, Set<Integer> skip, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new LinkedList<>(subset));
            return;
        }
        
        if (skip.contains(nums[i])) {
            generate(nums, i+1, subset, skip, subsets);
            return;
        }
        
        subset.add(nums[i]);
        generate(nums, i+1, subset, skip, subsets);
        subset.removeLast();
        skip.add(nums[i]);
        generate(nums, i+1, subset, skip, subsets);
        skip.remove(nums[i]);
    }
}