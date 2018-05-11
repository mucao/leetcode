package com.mucao.algorithm;

/**
 * leetCode题目地址：https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * 这个题的解题思路要根据二叉搜索树的性质来解
 * 主要是找到一个树结点的降序，其实就是二叉搜索树的反序遍历！
 *
 */
public class _538_Convert_BST_to_Greater_Tree {

    public static void main(String[] args) {

       // [2,0,3,-4,1]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        TreeNode new_root = new _538_Convert_BST_to_Greater_Tree().convertBST(root);

    }

    public  TreeNode convertBST(TreeNode root) {

        if(root != null){
            visitBST(root, 0);
        }


        return root;
    }

    public int visitBST(TreeNode root, int sum){


        //访问右子树
        if(root.right != null){
            sum = visitBST(root.right, sum);
        }

        //根
        root.val += sum;
        sum = root.val;

        //左子树
        if(root.left != null){
            sum = visitBST(root.left, sum);
        }

        return sum;
    }

 // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
