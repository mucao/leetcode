package com.mucao.algorithm;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * leetCode题目地址：https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 *  采用逆序数的方式，来做。
 *
 */
public class _581_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {
        int right = 0;
        int left = nums.length - 1;
        //找左边第一个逆序
        int tmp_r = right;
        for (; right < nums.length - 1; right++) {
            if(nums[right] > nums[right+1]) {
                right = tmp_r;
                break;
            }else if(nums[right] < nums[right + 1]){
                tmp_r = right + 1;
            }
        }
        if(right == left) return 0;
        //找右边第一个逆序
        int tmp = left;
        for (; left > 0 ; left--) {
            if(nums[left] < nums[left-1]){
                left = tmp;
                break;
            }else if(nums[left] > nums[left-1]){
                tmp = left-1;
            }
        }

        //对找到的位置进行校正
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = right; i <= left; i++) {
            if(nums[i] > max ) {
                max = nums[i];
            }else if(nums[i] < min){
                min = nums[i];
            }
        }

        int right_2 = right;
        int left_2 = left;
        for (int i = 0; i < right; i++) {
            if(nums[i] > min){
                right_2 = i;
                break;
            }
        }

        for (int i = nums.length -1 ; i > left; i--) {
            if(nums[i] < max){
                left_2 = i;
                break;
            }
        }

        return (left_2 - right_2 + 1);
    }
}
