package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * 地址：https://leetcode.com/problems/4sum/description/
 *
 */
public class _18_4Sum {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);

    }

    /**
     *
     * 测试
     *
     * 1. 功能  存在；不存在；存在一个；存在多个；有重复；无重复；输入元素个数不合法
     *
     * 2. 边界    计算组合的时候，递归的结束条件
     *
     * 3. 负面
     *           空指针；nums.length() < 4; 就找不到组合
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res_list = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return  res_list;
        }

        Arrays.sort(nums);

        //注意：处理重复问题

        return res_list;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res_list = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return  res_list;
        }

        Arrays.sort(nums);

        //注意：处理重复问题
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int low = j+1;
                int high = nums.length-1;
                while (low < high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum == target){
                        res_list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low+1] == nums[low]) low++;
                        low ++;
                        while (low < high && nums[high-1] == nums[high]) high--;
                        high --;
                    }else if(sum > target){
                        while (low < high && nums[high-1] == nums[high]) high--;
                        high--;

                    }else if (sum < target){
                        while (low < high && nums[low+1] == nums[low]) low++;
                        low++;
                    }
                }
            }
        }

        return res_list;
    }

}
