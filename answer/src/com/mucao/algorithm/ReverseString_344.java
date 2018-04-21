package com.mucao.algorithm;

/**
 * leetcode 第344题
 * 题目地址：https://leetcode.com/problems/reverse-string/description/
 *
 * 需要将字符串反转。
 *
 * hello -> olleh
 *
 */
public class ReverseString_344 {

    public static void main(String[] args){

        String s = "hello";



        String re_s = reverseString(s);
        System.out.println("反转后s为："+re_s);

    }

    public  static String reverseString(String s) {

        StringBuilder sb = new StringBuilder();
        /*for(int i= s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }*/
        sb.append(s);//测试证明，使用StringBuilder来完成字符串的反转，速度更快
        return sb.reverse().toString();
    }

}
