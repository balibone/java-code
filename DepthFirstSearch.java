import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class DepthFirstSearch {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(0, null, null);
        depthFirstSearchIter(head, 0);
        depthFirstSearchRecursive(head, 0);
    }

    // iterative depth first search using the right leaves stack trick.
    private static boolean depthFirstSearchIter(TreeNode node, int val) {
        // ArrayList<TreeNode> rightLeaves = new ArrayList<>();
        // IF GONNA USE QUEUE OR STACK, can just use Linked List.
        Stack<TreeNode> rightLeaves = new Stack<>();
        while (node != null) {
            if (node.val == val) {
                return true;
            }
            // push all right sides to stack
            if (node.right != null) {
                rightLeaves.push(node.right);
            }
            // always strive to get left child as the next node
            node = node.left;
            // but if left child dne, try to get the last right leaf that you "touched".
            if (node == null && !rightLeaves.isEmpty()) {
                node = rightLeaves.pop();
            }
        }
        // when through all nodes, but couldn't find.
        return false;
    }

    // recursive dfs
    private static boolean depthFirstSearchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        return depthFirstSearchRecursive(node.left, val) || depthFirstSearchRecursive(node.right, val);
    }
}
