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

    // depthFirstSearchIter performs an iterative depth first search on a binary
    // tree,
    // given a reference to the head of the tree.
    // it uses a stack to keep track of the right leaves as it goes down each level.
    // this provides a "reference" to go down the right side once the left side
    // has been exhausted.
    private static boolean depthFirstSearchIter(TreeNode node, int val) {
        // Note to self: for stacks and queues, can just use a LinkedLists.
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

    // depthFirstSearchRecursive performs the standard recursive dfs.
    private static boolean depthFirstSearchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        return depthFirstSearchRecursive(node.left, val) || depthFirstSearchRecursive(node.right, val);
    }
}
