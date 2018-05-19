package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * leetCode题目地址：https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * 二叉树的中序遍历
 *
 */
public class _94_Binary_Tree_Inorder_Traversal {


    // Definition for a binary tree node.
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){
            return null;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }

    //使用迭代的方法

    /**
     * 思路： 先向左走到头，然后在访问中间节点，再访问右边节点
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list2.add(cur.val);
            cur = cur.right;
        }

        return list2;
    }

    public static void main(String[] args) {
        _94_Binary_Tree_Inorder_Traversal _94 = new _94_Binary_Tree_Inorder_Traversal();
        TreeNode root = _94.new TreeNode(1);
        root.right = _94.new TreeNode(2);
        root.right.left = _94.new TreeNode(3);
        List<Integer> result_list = _94.inorderTraversal2(root);
        System.out.println("中序遍历结果是："+result_list.toString());

    }

}
