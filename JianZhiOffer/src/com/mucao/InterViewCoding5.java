package com.mucao;

import java.util.Arrays;

/**
 * 剑指Offer中的，第五个面试题
 */
public class InterViewCoding5 {

    public static void main(String[] args) {
        char[] chars = "hello world !".toCharArray();
        System.out.println(chars.length);
        char[] str =  Arrays.copyOf(chars, 20);
        ReplaceBlank(str, chars.length);
        System.out.println(new String(str));

    }

    /**
     *
     * @param str  字符数组
     * @param char_len  真正有字符的长度
     */
    static  void ReplaceBlank(char str[], int char_len){
        if(str == null || str.length < char_len || char_len < 1){
            return ;
        }

        int blank_num = 0;
        for(int i=0; i<char_len;i++){
            if(str[i] == ' '){
                blank_num ++;
            }
        }

        int new_length = char_len + blank_num*2;

        if(new_length > str.length){
            return ;
        }

        int p_1 =char_len - 1;
        int p_2 = new_length - 1;

        while(p_2 > p_1){
            if(str[p_1] != ' '){
                str[p_2] = str[p_1];
                p_1 --;
                p_2 --;
            }else {
                str[p_2--] = '0';
                str[p_2--] = '2';
                str[p_2--] = '%';
                p_1 --;
            }
        }
    }

}
