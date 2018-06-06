package com.mucao.algorithm;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * 题目地址：https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * 这个题的思路就是，反向从右向左进行排序，然后插入当前遍历元素，找到插入位置，
 * 就可以知道在当前元素右边有多少个小于它的元素了。
 */
public class _315_Count_of_Smaller_Numbers_After_Self {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};

        /**
         * 保存两个信息：
         * 顺序，在左侧还是在右侧
         *
         */
        List<Integer> result_list = countSmaller2(nums);
        System.out.println(result_list);

    }

    public static List<Integer> countSmaller3(int[] nums) {
        Map<Integer, Integer> map_num_right = new HashMap<>();//数字 -> 右边小于它的数字个数
        Map<Integer, Integer> map_num_orderIndex = new HashMap<>();//数字 -> 排序后的下标位置

        int[] order_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(order_nums);
        for (int i = 0; i < order_nums.length; i++) {
            map_num_orderIndex.put(order_nums[i], i);
            map_num_right.put(order_nums[i], 0);
        }
        Set<Integer> visited_set = new HashSet<>();
        visited_set.add(nums[nums.length-1]);
        for (int i = nums.length-2; i >= 0 ; i--) {
            int num = nums[i];
            int order_index = map_num_orderIndex.get(num);
            for (int j = order_index-1; j >= 0 ; j--) {

            }
        }





        return  null;
    }

    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> result_list = new LinkedList<>();//保存结果
        if(nums == null || nums.length == 0){
            return result_list;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        for (int i = nums.length -1 ; i >= 0 ; i--) {
            int origin_index = map.get(nums[i]);
            int offset = i - origin_index;
            result_list.add(offset);
        }

        return result_list;
    }

    /**
     *
     *测试用例：
     *    没有相等的数字。
     *    有相同的数字。
     *    无效输入： nums为null，或者为空
     *
     */

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result_list = new LinkedList<>();//保存结果
        if(nums == null || nums.length == 0){
            return result_list;
        }

        List<Integer> list  = new LinkedList<>();//用来排序   升序

        for (int i = nums.length - 1; i >= 0; i--) {
            int j = 0;
            for(;j<list.size() && nums[i]>list.get(j);j++){}
            list.add(j, nums[i]);
            result_list.add(0, j);
        }
        return result_list;
    }
}
