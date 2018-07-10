package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. Subsets II
 * 题目地址：  https://leetcode.com/problems/subsets-ii/description/
 */
public class _90_Subsets_II {

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 5};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println("指定数组的所有子集为："+lists);
    }


    /**
     *  测试用例：
     *  1. 功能测试：   多个元素；元素全都不同；元素有相同的；所有元素都相同；只有一个元素
     *  2. 边界测试：    递归的结束条件是什么？
     *  3. 负面测试：    数组中没有元素。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<List<Integer>>(new ArrayList<>());
        }
        Arrays.sort(nums);
        return computeSubsets(nums, 0);
    }

    private static List<List<Integer>> computeSubsets(int[] nums, int cur_index) {
        //递归结束条件
        if(cur_index == nums.length){
            List<List<Integer>> result_list = new ArrayList<List<Integer>>();
            result_list.add(new ArrayList<>());
            return result_list;
        }
        //因为有重复的元素，所以要防止干重复的事情
        int duplicate_nums = 1;
        while((cur_index+1) < nums.length && nums[cur_index] == nums[cur_index+1]){
            cur_index++;
            duplicate_nums++;
        }

        //1. 不选择当前元素
        List<List<Integer>> result_list = computeSubsets(nums, cur_index + 1);

        //2. 选择当前元素
        // 注意要处理重复元素
        int size = result_list.size();
        for (int i=0; i < size; i++) {
            //防止发生重复
            for (int j = 1; j <= duplicate_nums; j++) {
                List<Integer> arr_list = new ArrayList<>(result_list.get(i));
                for (int k = 0; k < j; k++) {
                    arr_list.add(nums[cur_index]);
                }
                result_list.add(arr_list);
            }
        }

        return result_list;
    }

}
