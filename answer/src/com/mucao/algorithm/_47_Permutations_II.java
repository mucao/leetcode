package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * question address: https://leetcode.com/problems/permutations-ii/description/
 *
 * 主要处理重复数字的问题
 *
 */
public class _47_Permutations_II {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result_list = permuteUnique(nums);
        System.out.println(result_list);
    }

    /**
     * 测试用例：
     * 正常：   没有重复的数字，有重复的数字（1个重复数字，2个或多个重复数字，重复次数为2,3，...）
     *
     * 不正常:    nums为null， nums为空数组。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if( nums==null || nums.length==0 ){
            return list;
        }

        boolean[] used = new boolean[nums.length];
        //排序。 为了找出重复的元素，所以得排序
        Arrays.sort(nums);

        //回溯
        backTrace(nums, used, list, new ArrayList<>());
        return list;
    }

    public static void backTrace(int[] nums, boolean[] used, List<List<Integer>> result_list, List<Integer> temp_list){
        if(temp_list.size()==nums.length){
            result_list.add(new ArrayList<>(temp_list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])) continue;
            //使用nums[i]
            used[i] = true;
            temp_list.add(nums[i]);
            backTrace(nums, used, result_list, temp_list);
            temp_list.remove(temp_list.size()-1);
            used[i] = false;
        }
    }

}
