public class ReversePairs {
    
    /**
     * @return the number of reverse pairs
     * 
     * A reverse pair is a pair of indices i, j where i < j and arr[i] > 2 * arr[j].
     * 
     * Approach 1) Sorted data structure
     * While iterating over the array, store each encountered number in a sorted data structure (e.g. Red Black Tree).
     * We note that this approach will only be O(n log n), if there are no duplicates in the array.
     * As soon as we have duplicates, we also need to keep track if their frequencies and iterate over the whole
     * left subtree of the obtained parent node of 2 * arr[i].
     * Note that this is solvable in O(n log n) time by applying a modified merge sort.
     */
    public int count(int[] nums) {
        int nReversePairs = 0;
    }
}
