import sun.misc.Queue;

class BreadthFirstSearch {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // bfs performs a breadth first search on a binary tree, given a reference to
    // the root node and a value to be searched.
    public static boolean bfs(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        Queue<TreeNode> nodes = new Queue<>();
        nodes.enqueue(node);
        while (!nodes.isEmpty()) {
            node = nodes.dequeue();
            if (node.val == val) {
                return true;
            }
            if (node.left != null) {
                nodes.enqueue(node.left);
            }
            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
        // exhausted all nodes, and yet still not found!!
        return false;
    }
}
