package com.mucao.algorithm;

/**
 * 459. Repeated Substring Pattern
 * 题目地址：https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 */
public class _459_Repeated_Substring_Pattern {

    public static void main(String[] args) {

        String s = "abaababaab";
        boolean result = repeatedSubstringPattern(s);
        System.out.println("result -> :"+result);
    }

    /**
     * 测试用例：
     * 1. 功能：   字符串可以被一个子串重复组成；不可以;只有一个字符的情况
     *
     * 2. 边界：   循环结束条件
     *
     * 3. 负面：   空指针；字符串内容为空。
     *
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        if(s==null||s.trim().isEmpty()||s.trim().length()==1){
            return false;
        }

            //寻找子串
        int p_head = 0;
        String subStr = null;
        while((subStr=findSubString(s, p_head))!=null){
            //开始检验
            if (checkSubString(s, subStr)){
                return true;
            }else {
                p_head = p_head+subStr.length();
            }
        }

        return false;
    }

    public static boolean checkSubString(String s, String subStr){

        int s_cur=0;
        int sub_len = subStr.length();
        while ((s_cur+sub_len)<=s.length()){
            if(s.substring(s_cur, s_cur+sub_len).equals(subStr)){
                s_cur = s_cur+sub_len;
            }else {
                return  false;
            }
        }
        if(s_cur==s.length()){
            return  true;
        }else {
            return false;
        }
    }

    public static String findSubString(String s, int p_head){
        int p_tail = s.length()-1;
        int p_head_c = p_head;
        while(p_head_c<p_tail){
            while (p_head_c<p_tail&&s.charAt(p_head_c)!=s.charAt(p_tail)){
                p_head_c++;
            }

            if (p_head_c==p_tail){
                return null;
            }

            //开始匹配
            for (int i = p_head_c, j = p_tail; i>=0&&j>p_head_c  ; i--, j--) {
                if(s.charAt(i)!=s.charAt(j)){
                    break;
                }

                if(i==0){
                    return s.substring(0, p_head_c+1);
                }
            }
            p_head = p_head_c;

        }

        return null;
    }


}
