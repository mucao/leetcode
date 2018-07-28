package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class _9_Palindrome_Number {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 回文数字的判断，用两个指针来做
     *
     * 测试用例
     *
     * 1. 功能
     *        数字是回文；不是回文；
     *
     * 2. 边界
     *         判断结束条件；结束时情况，需要特殊处理吗？
     *
     * 3. 负面
     *         数字有问题；可以采用反转判断吗？
     *
     * @param x
     * @return
     */

    public boolean isPalindrome3(int x) {
        if(x < 0){
            return false;
        }
        if(x<10 && x>=0){
            return true;
        }

        ArrayList<Integer> digits = new ArrayList<>();
        int ori_x = x;
        int re_val = 0;
        while(x!=0){
            if(re_val > Integer.MAX_VALUE/10 || (re_val == Integer.MAX_VALUE/10 && x%10 > 7)){
                return false;
            }
            re_val = re_val*10+x%10;
            x=x/10;
        }

        return re_val == ori_x;
    }

    public boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        if(x<10 && x>=0){
            return true;
        }

        ArrayList<Integer> digits = new ArrayList<>();
        while(x!=0){
            digits.add(x%10);
            x=x/10;
        }

        int left = 0;
        int right = digits.size()-1;
        while(left < right){
            if(digits.get(left) == digits.get(right)){
                left ++;
                right --;
            }else {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(int x) {

        String str = Integer.toString(x);
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left) == str.charAt(right)){
                left ++;
                right --;
            }else {
                return false;
            }
        }
        return true;
    }


}
