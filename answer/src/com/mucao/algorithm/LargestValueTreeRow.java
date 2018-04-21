package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode problem :515. Find Largest Value in Each Tree Row
 *
 * problem address:https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * 思路：对于每一层都会建立一个保存最大元素的位置，然后使用中序遍历、先序遍历和后序遍历中的一种方式遍历二叉树，
 * 在遍历的过程中更新每一层的最大值记录，遍历完二叉树后，就可以得到每一层的最大元素。
 *
 * 时间复杂度：O(n)
 * 空间复杂度: log(n)
 *
 */
public class LargestValueTreeRow {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        traverseTree(root, 0, list);

        return list;
    }

    public void traverseTree(TreeNode node, int current_level, List<Integer> max_List){

        //处理边界情况（递归的结束条件）
        if(node == null)
            return ;

        if(current_level > max_List.size()-1){  //表明当前的node是current_level层访问到的第一个元素，所以直接加入就行了
            max_List.add(node.val);
        }else if(node.val > max_List.get(current_level)){//使用先序遍历方式
            max_List.set(current_level, node.val);
        }

        traverseTree(node.left, current_level+1, max_List);
        traverseTree(node.right, current_level+1, max_List);
    }
}
