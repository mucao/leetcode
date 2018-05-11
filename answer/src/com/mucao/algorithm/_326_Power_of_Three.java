package com.mucao.algorithm;

/**
 * 题目地址：https://leetcode.com/problems/power-of-three/description/
 *
 */
public class _326_Power_of_Three {

    public static void main(String[] args) {
        int n = 0;
        //System.out.println("n是3的n次方? "+ isPowerOfThree(n));

        double i = 2;
        System.out.println("->:   "+(i%1));
    }

    public static boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        boolean result = false;
        while(n%3 == 0){
            n = n/3;
        }
        if(n < 3 && n == 1){
            result = true;
        }
        return result;
    }

}
