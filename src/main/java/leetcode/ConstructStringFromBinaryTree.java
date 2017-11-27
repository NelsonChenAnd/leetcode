package leetcode;

import data.TreeNode;

/**
 * 前置知识点：二叉树的先序、中序、后序遍历。（递归+非递归）
 * 功能描述：给定一棵树，按照先序遍历顺序变成string。
 * 如Input: Binary tree: [1,2,3,4]
   1
 /   \
 2     3
 /
 4
 Output: "1(2(4))(3)"

 Input: Binary tree: [1,2,3,null,4]
   1
 /   \
 2     3
 \
 4

 Output: "1(2()(4))(3)"
 *
 * @Author SJ
 * @Date 2017-11-27
 */
public class ConstructStringFromBinaryTree {

    private StringBuffer buf = new StringBuffer();

    public String tree2str(TreeNode t) {

        if(t==null) {
            return "";
        }

        preOrder(t);
        return buf.substring(1, buf.length()-1);
    }

    private void preOrder(TreeNode node) {

        if(node!=null) {
            buf.append("(" + node.val);
            preOrder(node.left);
            if(node.left==null && node.right!=null) {
                buf.append("()");
            }
            preOrder(node.right);
            buf.append(")");

        }
    };

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        ConstructStringFromBinaryTree a = new ConstructStringFromBinaryTree();

        System.out.println(a.tree2str(t));
    }

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
