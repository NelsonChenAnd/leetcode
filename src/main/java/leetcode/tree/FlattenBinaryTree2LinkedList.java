package leetcode.tree;

import data.TreeNode;

/**
 * Author: SJ
 * Date: 2018/12/6
 */
public class FlattenBinaryTree2LinkedList {
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }
        postOrder(root, null);
        System.out.println(root.val);
        System.out.println(root.right==null);
    }

    public void postOrder(TreeNode root, TreeNode last) {
        if(root==null) {
            return;
        }

        postOrder(root.right, last);
        System.out.println("right+"+root.val +"\t"+last);
        postOrder(root.left, last);
        System.out.println("left+" + root.val +"\t"+last);
        root.right = last;
        root.left = null;
        last = root;
        System.out.println("22:"+root.val + "\t"+last);
    }

    public static void main(String[] args) {
        FlattenBinaryTree2LinkedList f = new FlattenBinaryTree2LinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        f.flatten(root);
    }
}
