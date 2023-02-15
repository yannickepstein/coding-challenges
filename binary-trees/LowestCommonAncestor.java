public class LowestCommonAncestor {

    // assumption: each key in the tree is unique and p and q are != null
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (!containsKey(root, p.val) || !containsKey(root, q.val)) {
            return null;
        }
        return findLCA(root, p.val, q.val);
    }
    
    // assumption: p and q exits
    private TreeNode findLCA(root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            // there cannot be a lower LCA then root itself
            return root;
        }
        var left = findLCA(root.left, p, q);
        var right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            // left and right contain p and q, but not both keys can be in the same subtree
            // -> root is LCA
            return root;
        }
        return left != null ? left : right;
    }
    
    public boolean containsKey(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        return containsKey(root.left, key) || containsKey(root.right, key);
    }
}
