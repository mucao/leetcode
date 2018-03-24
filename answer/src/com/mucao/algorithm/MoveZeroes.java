package com.mucao.algorithm;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 *
 * Problem address: https://leetcode.com/problems/move-zeroes/description/
 *
 * 思路： 一遍扫描，扫描到了多少个零，那么之后的元素就要向前移动多少个位置。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("移动前："+ Arrays.toString(nums));
        new MoveZeroes().moveZeroes(nums);
        System.out.println("移动后："+ Arrays.toString(nums));



    }

    public void moveZeroes(int[] nums) {
        int zeros_num = 0;//0的个数
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeros_num ++;
            }else if (zeros_num != 0){
                nums[i - zeros_num] = nums[i];
            }
        }

        //将后面的零补上
        for(int i=nums.length-1; i>(nums.length - 1 -zeros_num); i--){
            nums[i] = 0;
        }

    }
}
