package leetcode.tree;

import data.TreeNode;

/**
 * 功能描述：给定一棵二叉树，求出最底层的最左边的结点。可采用深度优先遍历/广度优先遍历求解。
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 * @Author SJ
 * @Date 2018-5-22
 */
public class FindBottomLeftTreeValue {

    int maxDepth = 1;
    int bottomLeftValue = 0;

    // 深度优先遍历
    public int findBottomLeftValue(TreeNode root) {
        bottomLeftValue = root.val;
        DLRTraverse(root, 1);
        return bottomLeftValue;
    }

    public void DLRTraverse(TreeNode root, int depth) {
       if(root==null) {
           return;
       }

       if(depth > maxDepth) {
           maxDepth = depth;
           bottomLeftValue = root.val;
       }

       DLRTraverse(root.left, depth+1);
       DLRTraverse(root.right, depth+1);
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue a = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        /*root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);*/
        System.out.println(a.findBottomLeftValue(root));
    }
}
