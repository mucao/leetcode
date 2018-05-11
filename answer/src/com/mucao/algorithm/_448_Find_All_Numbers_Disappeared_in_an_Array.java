package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 *
 * leecote题目地址：https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 */
public class _448_Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        new _448_Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers(nums);

    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//将每一个数字归位
            if(nums[i] != (i+1)){
                int tmp = nums[i];
                int index = tmp - 1;
                if(nums[index] != tmp){
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    i--;
                }
            }
        }

        List<Integer> result_list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != (i+1)){
                result_list.add((i+1));
            }
        }

        return result_list;
    }
}
