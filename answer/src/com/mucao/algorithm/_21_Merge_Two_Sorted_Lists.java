package com.mucao.algorithm;

public class _21_Merge_Two_Sorted_Lists {

    /**
     * 测试
     *
     * 1. 功能
     *          有一个是空指针；一个刚好接在另一个后面
     *
     * 2. 边界
     *          结束条件；结束后的处理
     *
     * 3. 负面
     *          另个都是空指针；一个是空指针；重复元素怎么处理?
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//击败 100%
        if(l1 == null && l2 == null){
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode o_head = head;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        while (l1 != null){
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null){
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }


        return o_head.next;
    }

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


}
