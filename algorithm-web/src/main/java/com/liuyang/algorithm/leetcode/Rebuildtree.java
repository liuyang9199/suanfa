package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/30 上午7:47
 */
public class Rebuildtree {

    public static void main(String[] args) {


        /*TreeNode root = new TreeNode(1);
        TreeNode TreeNode2 = new TreeNode(2);
        TreeNode TreeNode3 = new TreeNode(3);
        TreeNode TreeNode4 = new TreeNode(4);
        TreeNode TreeNode5 = new TreeNode(5);
        TreeNode TreeNode6 = new TreeNode(6);
        TreeNode TreeNode7 = new TreeNode(7);
        TreeNode TreeNode8 = new TreeNode(8);
        TreeNode TreeNode9 = new TreeNode(9);

        root.left = TreeNode2;
        root.right = TreeNode3;
        TreeNode2.left = TreeNode4;
        TreeNode2.right = TreeNode5;
        TreeNode3.left = TreeNode6;
        TreeNode2.right = TreeNode7;
        TreeNode5.left = TreeNode8;
        TreeNode5.right = TreeNode9;*/

        int[] prenums = new int[]{1};
        int[] innums =  new int[]{1};

        Rebuildtree rebuildtree = new Rebuildtree();
        TreeNode root = rebuildtree.buildTree(prenums, innums);

        System.out.println(1);


    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length ==0 || inorder.length == 0) {
            return null;
        }
        return rebuildCode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length -1);
    }

    public TreeNode rebuildCode(int[] prenums, int[] innums, int start1, int end1, int start2, int end2) {
        if (prenums == null || innums == null || prenums.length != innums.length) {
            return null;
        }

        if (start1 >= end1) {
            return new TreeNode(prenums[start1]);
        }

        int parentval = prenums[start1];
        TreeNode parent = new TreeNode(parentval);

        int index = findIndexForInorder(innums, parentval);

        int leftsize = index - start2;
        int rightsize = end2 - index;

        if (leftsize > 0) {
            parent.left = rebuildCode(prenums, innums, start1 + 1, start1 + leftsize, start2, index -1);

        }
        if (rightsize > 0) {
            parent.right = rebuildCode(prenums, innums, start1 + 1 + leftsize, end1, index + 1, end2);

        }

        return parent;
    }

    public int findIndexForInorder(int[] innums, int val) {
        for (int i = 0; i < innums.length; i++) {
            if (innums[i] == val) {
                return i;
            }
        }
        return -1;
    }



    public static class TreeNode {

        public int val;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }




}
