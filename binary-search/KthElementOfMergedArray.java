public class KthElementOfMergedArray {

    /**
     * Both arr1 and arr2 are sorted.
     * We want to find the k-th element in the final merged array of arr1 and arr2.
     * We note that this element must be in the range [min(arr1[0], arr2[0]), max(arr1[-1], arr2[-1])].
     * Further an element x in said range is the corresponding element, if the
     * sum of elements < x in arr1 + sum of element < x in arr2 is in the range == [k-freq(x), k-1].
     * If there above sum falls above the range, then x is too large. Otherwise too small.
     */
    public int findElement(int[] arr1, int[] arr2) {
        int left = Math.min(arr1[0], arr2[0]);
        int right = Math.max(arr1[arr1.length - 1], arr2[arr2.length - 1]);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // find first index and last index in arr1 and arr2
            // -> gives the metric
        }
    }
}
