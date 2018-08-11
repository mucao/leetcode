package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * 题目地址：https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 */
public class _17_Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    /**
     *
     * 测试
     *
     * 1.功能   有多个组合
     *
     * 2. 边界  计算所有组合
     *
     * 3.负面 空指针；没有元素；元素不合法
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {//击败了 96%

        List<String> res_list = new ArrayList<>();
        if(digits == null||digits.length() == 0){
            return  res_list;
        }

        res_list.add("");

        for (int i = digits.length()-1; i >=  0; i--) {
            String letters = getLetters(digits.charAt(i));
            List<String> list = new ArrayList<>();
            for (int j = 0; j < letters.length(); j++) {
                for (String combine : res_list) {
                    list.add(letters.charAt(j)+combine);
                }
            }
            res_list = list;

        }

        return res_list;
    }

    private static String getLetters(char digit) {//获得数字对应的字符串
        switch (digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return null;
        }

    }


}
