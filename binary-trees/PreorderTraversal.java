public class PreorderTraversal {

    public List<Integer> findPreorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        var preorderTraversal = new LinkedList<Integer>();
        preorderTraversal.add(root.val);
        preorderTraversal.addAll(findPreoorderTraversal(root.left));
        preorderTraversal.addAll(findPreorderTraversal(root.right));
        return preorderTraversal;
    }
}
