package leetcode.tree;

import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述：之字形遍历二叉树。
 * 思想：也是层次遍历，只是隔层遍历顺序一样，相邻层遍历顺序相反。通过引入标记位tag，
 * 遍历完一层修改tag值，换个方向遍历。
 * For example:
 Given binary tree [3,9,20,null,null,15,7],
   3
  / \
 9  20
   /  \
  15  7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 *
 * @Author SJ
 * @Date 2018-1-8
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) { // ！！！！！！！！！！特殊测试用例一定要记得。
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        boolean tag=true;

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode p = queue.poll();

                if(p.left!=null) {
                    queue.offer(p.left);
                }
                if(p.right!=null) {
                    queue.offer(p.right);
                }

                if(tag==true) {
                    temp.add(p.val);
                } else {
                    temp.add(0, p.val);
                }

            }
            tag= tag==true? false: true;
            ans.add(temp);
        }
        return ans;
    }
}
