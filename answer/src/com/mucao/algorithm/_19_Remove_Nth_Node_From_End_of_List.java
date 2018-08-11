package com.mucao.algorithm;

/**
 * 19. Remove Nth Node From End of List
 *
 * 题目地址：https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class _19_Remove_Nth_Node_From_End_of_List {

    /**
     * 测试
     *
     * 1. 功能
     *      存在倒数第n个；不存在
     * 2. 边界
     *      查找结束条件是什么？
     * 3. 负面
     *      空指针；n不合法；n大于链表长度
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0){
            return null;
        }

        ListNode p_front = head;
        ListNode p_after2 = null;
        ListNode p_after = head;

        for (int i = 0; i < n-1; i++) {
            p_front = p_front.next;
        }
        //p_front指向第n个节点；
        while(p_front.next != null){
            p_front = p_front.next;
            p_after2 = p_after;
            p_after = p_after.next;
        }

        if(p_after2 == null){
            head = p_after.next;
        }else {
            p_after2.next = p_after.next;
        }

        return head;
    }

}

/**
 * Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

