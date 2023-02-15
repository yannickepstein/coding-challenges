public class TwoSumBST {
    
    /**
     * We note that because root is a BST, all nodes have unique values.
     *
     * Consider any node n in the tree.
     * It is part of the tuple, if there is a key != n in the BST that has value target - n.val (so if that is n, we don't need to look).
     * If target - n.val is < n.val, then it can only be in the left subtree of n.
     * If however target - n.val > n.val, then it can be hidden in the whole tree.
     */
    public static boolean solve(TreeNode root, int target) {
        return twoSum(root, root, target);
    }
    
    private static boolean twoSum(TreeNode root, TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        var found = solve(node.left, target) || solve(node.right, target);
        var searchKey = target - node.val; 
        if (searchKey != node.val) {
            if (searchKey < node.val) {
                found |= containsKey(node.left, searchKey);
            } else {
                found |= containsKey(root, searchKey);
            }
        }
        return found;
    }
    
    private static boolean containsKey(TreeNode root, int target) {
        if (root == null) {
            return false;
        } 
        if (root.val == target) {
            return true;
        }
        return root.val > target ? containsKey(root.right, target) : containsKey(root.left, target);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

