public class InorderTraversal {

    // inorder traversal of a binary tree is then [...left, root, ...right]
    public List<Integer> findInorderTraversal(TreeNode root) {
        if (root == null) {
            return Collection.emptyList();
        }
        
        var inorderTraversal = new LinkedList<Integer>();
        inorderTraversal.addAll(findInorderTraversal(root.left));
        inorderTraversal.add(root.val);
        inorderTraversal.addAll(findInorderTraversal(root.right));
        return inorderTraversal;
    }
}
