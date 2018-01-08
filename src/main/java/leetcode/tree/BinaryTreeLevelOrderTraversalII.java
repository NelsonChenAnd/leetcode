package leetcode.tree;

import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述：
 *Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]

 * @Author SJ
 * @Date 2017-12-27
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(root!=null) {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            TreeNode endNode = new TreeNode(Integer.MIN_VALUE);
            queue.add(endNode);
            List<Integer> list = new ArrayList<Integer>();
            while(!queue.isEmpty() && queue.size()>1) {
                TreeNode node = queue.poll();

                if(node.val==Integer.MIN_VALUE) {
                    ans.add(0, new ArrayList<Integer>(list));
                    list = new ArrayList<Integer>();
                    System.out.println(ans);
                    queue.add(node);
                    continue;
                }

                list.add(node.val);
                System.out.println("list=>" + list);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        BinaryTreeLevelOrderTraversalII a = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> ans = a.levelOrderBottom(root);
        System.out.println(ans);
    }
}
