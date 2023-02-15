/**
 * Note that the discovery algorithm for the LCA extends to the any number of nodes.
 * So if root == pi, then there cannot be lower common ancestor to all nodes p1, ..., pn.
 * Similarly, if the left or right subtrees report to be an LCA, then the root must be the LCA.
 */
public class MultiNodeLCA {

    // optimization turn p into a set before calling the recursive method
    public TreeNode findLCA(TreeNode root, TreeNode[] p) {
        if (root == null || contains(p, root)) {
            return root;
        }
        var left = findLCA(root.left, p);
        var right = findLCA(root.right, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    private boolean contains(TreeNode[] nodes, TreeNode node) {
        for (var n : nodes) {
            if (n.val == node.val) {
                return true;
            }
        }
    }
}
