public class BinaryTreeLongestConsecutiveSequence {

    public int findLengthOfLongestConsecutiveSequence(TreeNode root) {
        return root != null ? helper(root, root.val-1, 0) : 0;
    }
    
    private int helper(TreeNode root, int prev, int curLength) {
        if (root == null) {
            return curLength;
        }
        
        if (root.val != prev.val + 1) {
            return Math.max(
                curLength,
                Math.max(helper(root.left, root.val, 1), helper(root.right, root.val, 1))
            );
        } else {
            return Math.max(helper(root.left, root.val, curLength+1), helper(root.right, root.val, curLength+1));
        }
    }
}
