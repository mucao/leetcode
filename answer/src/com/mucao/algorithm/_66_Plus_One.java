package com.mucao.algorithm;

/**
 *66. Plus One
 * leetCode 题目地址：https://leetcode.com/problems/plus-one/description/
 */
public class _66_Plus_One {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] ++;
                break;
            }
        }

        if (digits[0] == 0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else{
            return digits;
        }
    }
}
