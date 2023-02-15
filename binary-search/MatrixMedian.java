public class MatrixMedian {
    /**
     * Each row in the matrix is sorted.
     * Let min(matrix) and max(matrix) be the smallest and largest element in the matrix.
     * Then we know the matrix median must be in the range [smallest, largest].
     * Assume for some value x nSmaller(x) and nLarger(x) are the number of smaller
     * and larger values than x in the matrix. Then x is the median if
     * |nSmaller(x) - nLarger(x)| <= 1 
     * 
     * We note that nSmaller and nLarger can be determined by iterating over all rows,
     * finding the position of the first element >= x in each row.
     * Then summing the nSmaller and nLarger for each row.
     */
    public int findMedian(int[][] matrix) {}
}
