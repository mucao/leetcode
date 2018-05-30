package com.mucao.algorithm;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * leetCode题目地址：https://leetcode.com/problems/add-two-numbers-ii/description/
 * 解题思路，从低位执行加法计算。
 *
 * 使用装饰者模式，将单链表转换成双链表
 *
 */
public class _445_Add_Two_Numbers_II {
    
    public static void main(String[] args) {
        int[] arr1 = {7,2,4,3};
        int[] arr2 = {5,6,4};

        ListNode l1 = createListNode(arr1);
        ListNode l2 = createListNode(arr2);

        ListNode result_node = new _445_Add_Two_Numbers_II().addTwoNumbers3(l1, l2);

        while (result_node != null){
            System.out.print(result_node.val+" -> ");
            result_node = result_node.next;
        }

    }

    private static ListNode createListNode(int[] arr1) {
        ListNode l1 = new ListNode(arr1[0]);
        ListNode pre = l1;
        for (int i = 1; i < arr1.length; i++) {
            ListNode cur = new ListNode(arr1[i]);
            pre.next = cur;
            pre = cur;
        }

        return l1;
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class ListPreNode{
        ListNode node;
        ListPreNode preNode;

        public ListPreNode( ListPreNode preNode, ListNode node) {
            this.node = node;
            this.preNode = preNode;
        }
    }

    /**
     * 使用栈实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null){
            stack1.add(l1);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.add(l2);
            l2 = l2.next;
        }

        //因为l1和l2都是代表非空数字，所以不用判空了；
        if(stack2.size() > stack1.size()){
            Stack<ListNode> tmp_stack = stack1;
            stack1 = stack2;
            stack2 = tmp_stack;
        }

        //执行加法
        ListNode node_L = null;
        ListNode node_S = null;
        int tmp =0; //进位
        while(!stack2.isEmpty()){
            node_L = stack1.pop();
            node_S = stack2.pop();
            int total = node_L.val + node_S.val + tmp;
            node_L.val = total%10;
            tmp = total/10;
        }

        while (!stack1.isEmpty()){
            node_L = stack1.pop();
            int total = node_L.val + tmp;
            node_L.val = total%10;
            tmp = total/10;
        }

        if(tmp > 0){
            ListNode tmp_node = new ListNode(tmp);
            tmp_node.next = node_L;
            node_L = tmp_node;
        }
        return node_L;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode pre1 = null;
        ListNode cur1 = null;
        while(l1 != null){
            cur1 = new ListNode(l1.val);
            cur1.next = pre1;
            pre1 = cur1;
            l1 = l1.next;
        }

        ListNode pre2 = null;
        ListNode cur2 = null;

        while(l2 != null){
            cur2 = new ListNode(l2.val);
            cur2.next = pre2;
            pre2 = cur2;
            l2 = l2.next;
        }

        if(cur1 == null || cur2 == null){
            return null;
        }

        //开始执行加法运算
        ListNode after = null;
        int tmp =0;
        while(cur1 != null && cur2 != null){

            int total = cur1.val + cur2.val + tmp;
            //当前位
            ListNode cur = new ListNode(total%10);
            cur.next = after;
            after = cur;

            //进位
            tmp = total/10;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        //可能还有一个链表没执行完

        ListNode cur = cur1 != null ? cur1 : cur2;
        while(cur != null){
            int total = cur.val + tmp;
            //当前位
            ListNode tmp_cur = new ListNode(total%10);
            tmp_cur.next = after;
            after = tmp_cur;

            //进位
            tmp = total/10;

            cur = cur.next;
        }

        //可能还有最后一个进位没有处理
        if(tmp > 0){
            ListNode tmp_cur = new ListNode(tmp);
            tmp_cur.next = after;
            after = tmp_cur;
        }

        return after;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListPreNode pre1 = null;
        ListPreNode cur1 = null;
        while (l1 != null) {
            cur1 = new ListPreNode(pre1, l1);
            pre1 = cur1;
            l1 = l1.next;
        }

        ListPreNode pre2 = null;
        ListPreNode cur2 = null;
        while (l2 != null) {
            cur2 = new ListPreNode(pre2, l2);
            pre2 = cur2;
            l2 = l2.next;
        }

        if (cur1 == null || cur2 == null) {
            return null;
        }

        //开始执行加法运算
        ListNode after = null;
        int tmp = 0;//进位标志
        while (cur1 != null && cur2 != null) {
            int total = cur1.node.val + cur2.node.val + tmp;
            ListNode cur = new ListNode(total % 10);
            cur.next = after;
            tmp = total / 10;
            after = cur;
            cur1 = cur1.preNode;
            cur2 = cur2.preNode;
        }

        ListPreNode leave = cur1 == null ? cur2 : cur1;

        while (leave != null) {
            int total = leave.node.val + tmp;
            ListNode cur = new ListNode(total % 10);
            cur.next = after;
            tmp = total / 10;
            after = cur;
            leave = leave.preNode;
        }

        if (tmp > 0) {
            ListNode cur = new ListNode(tmp);
            cur.next = after;
            after = cur;
        }

        return after;
    }
}
