package com.mucao.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 *
 * 题目地址：https://leetcode.com/problems/valid-parentheses/description/
 *
 */
public class _20_Valid_Parentheses {


    public static void main(String[] args) {
        String s = "]";

        System.out.println(isValid(s));
    }


    /**
     * 就是括号匹配
     *
     * 测试用例
     *
     * 1. 功能  可以匹配；不可以；空字符串也是匹配的
     *
     * 2. 边界
     *          匹配结束条件
     *
     *
     * 3. 负面
     *
     *          空指针；字符串元素不是括号类型
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if(s == null){
            return false;
        }

        if(s.trim().isEmpty()){
            return true;
        }

        //进行括号匹配
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('||c == '{' || c == '['){
                stack.push(c);
            }else {//开始匹配

                Character top_c =  stack.peek();

                if(top_c == null){
                    return  false;
                }else {
                    stack.pop();
                    if(c == ')' && top_c == '('){
                        continue;
                    }else if(c == '}' && top_c == '{'){
                        continue;
                    }else if(c == ']' && top_c == '['){
                        continue;
                    }else {
                        return false;
                    }
                }


            }
        }


        return stack.isEmpty();
    }

}
