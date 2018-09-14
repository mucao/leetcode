package com.mucao.algorithm;

public class _24_Swap_Nodes_in_Pairs {


    public static void main(String[] args) {
        System.out.println("test");
    }

    /**
     * 测试：
     *
     * 1. 功能
     *      对相邻节点进行交换；奇数个节点；偶数个
     *
     * 2. 边界
     *      停止条件
     *
     * 3. 负面
     *      空指针；只有一个节点；奇数个节点。
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        return null;
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode ppre = null;
        head = head.next;
        while(pre!=null && pre.next!=null){
            ListNode after = pre.next;
            if(ppre == null){
                pre.next = after.next;
                after.next = pre;
                ppre = pre;
                pre = pre.next;
            }else {
                ppre.next = after;
                pre.next = after.next;
                after.next = pre;
                ppre = pre;
                pre = pre.next;
            }
        }

        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

