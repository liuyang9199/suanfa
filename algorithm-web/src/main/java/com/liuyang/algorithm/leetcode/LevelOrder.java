package com.liuyang.algorithm.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/20 下午4:55
 */
public class LevelOrder {

    public static void main(String[] args) {

        TreeNode listNode1 = new TreeNode(1);
        TreeNode listNode2 = new TreeNode(2);
        TreeNode listNode3 = new TreeNode(3);
        TreeNode listNode4 = new TreeNode(4);
        TreeNode listNode5 = new TreeNode(5);
        TreeNode listNode6 = new TreeNode(6);
        TreeNode listNode7 = new TreeNode(7);
        TreeNode listNode8 = new TreeNode(8);
        listNode1.left = listNode2;
        listNode1.right = listNode3;
        listNode2.left = listNode4;
        listNode2.right = listNode5;
        listNode3.left = listNode6;
        listNode3.right = listNode7;
        listNode4.right = listNode8;
        
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> r = levelOrder.levelOrder(listNode1);
        for (List<Integer> l : r) {
            for (Integer i : l) {
                System.out.print(i);
            }
            System.out.println("----");
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> rlist = new ArrayList();
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int nextCount = 0;
            List<Integer> oneRecord = new ArrayList();
            for (int i = 0; i < count; i++) {
                TreeNode t = queue.poll();
                oneRecord.add(t.val);
                if (t.left != null) {
                    nextCount++;
                    queue.add(t.left);

                }
                if (t.right != null) {
                    nextCount++;
                    queue.add(t.right);
                }
            }
            rlist.add(oneRecord);
            count = nextCount;


        }
        return rlist;

    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
