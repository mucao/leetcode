package com.mucao.algorithm;

/**
 * 459. Repeated Substring Pattern
 * 题目地址：https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * 用两个串来搞！
 *
 * 改用char数组来作为基本的数据结构，提交代码的运行时间：
 * 18ms  21 ms   18 ms
 *
 */
public class _459_Repeated_Substring_Pattern_3 {

    public static void main(String[] args) {

        //String s = "abaababaab";
//        String s = "aabaaba";
//        String s = "abababaabababaabababa";
        String s = "aaaa";
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

        char[] s_chars = s.toCharArray();

        //找到一个合适的子串
        int sub_end=0;
        while (sub_end<(s_chars.length/2)){

            if(findSubString(s_chars, sub_end)){//验证0-sub_end是不是一个合格子串
                //开始验证找到的字串是否符合题目要求
                if(checkSubString(s_chars, sub_end)){
                    return true;
                }
            }
            sub_end++;
        }


        return false;
    }

    public static boolean checkSubString(char[] s_chars, int sub_end){

        if(s_chars.length%(sub_end+1)!=0)  return false;

        for (int i = sub_end+1; i <= (s_chars.length-sub_end-2); i++) {
            if(s_chars[i]!=s_chars[i%(sub_end+1)]) {
                return false;
            }
        }

        //测试github提交代码



        return true;
    }

    public static boolean findSubString(char[] s_chars, int sub_end){

        for (int p_1 = sub_end, p_2 = s_chars.length-1; p_1 >=0&&p_2>sub_end ; p_1--,p_2--) {
            if(s_chars[p_1]!=s_chars[p_2]){
                return false;
            }

            if(p_1==0&&p_2>sub_end){
                return  true;
            }
        }
        return false;
    }


  /*  public static boolean checkSubString(String s, String subStr){

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
    }*/

   /* public static String findSubString(String s, int p_head){
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
            p_head_c++;
            p_head = p_head_c;

        }

        return null;
    }*/


}
