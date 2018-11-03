import sun.misc.Queue;

class BreadthFirstSearch {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }

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
