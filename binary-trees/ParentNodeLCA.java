public class ParentNodeLCA {

    /**
     * We want to find the LCA of the two nodes.
     * Assumption: p != q and all values are unique and p != null and q != null
     * The LCA of the two nodes will be a node that is reachable from both
     * p and q through traversing up the tree or one of the two nodes itself.
     * Assume we look at the node to root path of p and q:
     * [p, p1, p2, ...] = path(p)
     * [q, q1, q2, ...] = path(q)
     * the LCA is the node pi that first occurs in path(q).
     * So if we first discover path(p) and then while discovering path(q),
     * we check if it is in path(p), we will find our answer.
     */
    public Node findLCA(Node p, Node q) {
        var toRootPath = new HashSet<Integer>();
        while (p != null) {
            toRootPath.add(p.val);
            p = p.parent;
        }
        while (q != null) {
            if (toRootPath.contains(q.val)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
        
    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }
}
