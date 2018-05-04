package com.mucao.algorithm;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between
 * the values of any two different nodes in the tree.
 *
 * 第783题目详细地址：https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 *在二叉搜索树种，每一个顶点都有一个最接近它左侧子节点和右侧子节点
 */
public class Minimum_distance_between_bstnodes_783 {


    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;

        if(root.left != null){
            TreeNode pre_node = root.left;
            TreeNode cur_node = root.left;
            while(cur_node != null){
                pre_node = cur_node;
                cur_node = cur_node.right;
            }

            int  L_diff = Math.abs(root.val - pre_node.val);
            if(L_diff < minDiff){
                minDiff = L_diff;
            }

            int L_minDiff = minDiffInBST(root.left);
            if(L_minDiff < minDiff){
                minDiff = L_minDiff;
            }

        }

        if(root.right != null){
            TreeNode pre_node = root.right;
            TreeNode cur_node = root.right;
            while(cur_node != null){
                pre_node = cur_node;
                cur_node = cur_node.left;
            }

            int  R_diff = Math.abs(root.val - pre_node.val);
            if(R_diff < minDiff){
                minDiff = R_diff;
            }

            int R_minDiff = minDiffInBST(root.right);
            if(R_minDiff < minDiff){
                minDiff = R_minDiff;
            }

        }


        return minDiff;
    }

}

/**
 * Definition for a binary tree node.
 */

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
