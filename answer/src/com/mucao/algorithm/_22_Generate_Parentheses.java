package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * 地址：https://leetcode.com/problems/generate-parentheses/description/
 *
 */
public class _22_Generate_Parentheses {

    public static void main(String[] args) {

        List<String> list = generateParenthesis(3);
        System.out.println("result: "+list);


    }

    /**
     * 测试
     *
     * 1. 功能   找得到；找不到
     *
     * 2. 边界   结束条件；结束后生成结果
     *
     * 3. 负面    n非法；
     *
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
            return null;
        }

        List<String> list = new ArrayList<>();
        LinkedList<Character> stack = new LinkedList<>();

        getParenthesis(stack, '(', n-1, n, ""+"(", list);
        return list;
    }

    public static void getParenthesis(LinkedList<Character> stack, char select,int left_limit, int right_limit, String parenthesis, List<String> parentheses_list){

        if(select == '('){
            stack.push(select);
            //多项选择；递归
            if(left_limit > 0){
                getParenthesis(stack, '(', left_limit-1, right_limit, parenthesis+"(", parentheses_list);
            }
            if(right_limit > 0){
                getParenthesis(stack, ')', left_limit, right_limit-1, parenthesis+")", parentheses_list);
            }
            stack.pop();
        }else {
            if(stack.isEmpty()){
                return;
            }
            Character pop_c = stack.pop();
            if(pop_c == '('){//继续
                if(left_limit==0 && right_limit==0){//符合
                    if(stack.isEmpty()){
                        parentheses_list.add(parenthesis);
                    }else {
                        return;
                    }

                }else {//多项选择；递归
                    if(left_limit > 0){
                        getParenthesis(stack, '(', left_limit-1, right_limit, parenthesis+"(", parentheses_list);

                    }
                    if(right_limit > 0){
                        getParenthesis(stack, ')', left_limit, right_limit-1, parenthesis+")", parentheses_list);

                    }
                }

            }
            stack.push(pop_c);
        }

    }

}
