public class SingleElementFind {

    /**
     * nums is sorted and each element, except one appears twice.
     * [1, 1, 2, 2, 3, 4, 4, 5, 5]
     * Note that the element can only be in the range [min(nums), max(nums)].
     * So we can perform a modified binary search, where we try to find the index of each element.
     * If it does not exist, we just return -1, and know its not the single element, we then need
     * get the first element that is larger than x. [left, [x, x, tail]] = [left, right]
     * Either left or right contains the single element. The one with odd length is the one that
     * contains the single element.
     * If it exists, we can just check, if it occurs twice.
     * Now if it occurs twice, then we can take a look at the subarrays left and right to it:
     * [left, x, x, right]. Once of those will contain the single element, the others will only
     * contain pairs of elements. The one that contains pairs has even length, the other odd length,
     * so this gives us the choice, if we need to search for a larger or a smaller element.
     * This is actually equivalent to just looking into the array and then deciding if
     * the element is in the left sublist or right sublist.
     */
    public int findSingleElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = nums[mid];
            if (mid-1 >= 0 && nums[mid-1] == element) {
                mid--;
            } 
            if (mid+1 < nums.length && nums[mid+1] == element) {
                var leftLength = mid;
                if (leftLength  % 2 != 0) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else {
                return element;
            }
        }
    }
}
