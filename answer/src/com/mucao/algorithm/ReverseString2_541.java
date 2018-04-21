package com.mucao.algorithm;

public class ReverseString2_541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        String re_s = reverseStr2(s, 2);
        System.out.println("逆转之后的字符串为："+re_s);
    }

    public  static String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2*k) {
            int start = i;
            int end = Math.min(i+(k-1), chars.length-1);
            while( start < end){
                char tmp_c = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp_c;
                start ++;
                end --;
            }
        }

        return new String(chars);
    }

    public  static String reverseStr(String s, int k) {
        StringBuilder reverse_sb = new StringBuilder();
        StringBuilder result_sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if((i/k)%2 == 0){   //前k要进行逆转
                reverse_sb.append(s.charAt(i));
            }else {
                result_sb.append(reverse_sb.reverse());
                result_sb.append(s.charAt(i));
                reverse_sb = new StringBuilder();
            }
        }

        result_sb.append(reverse_sb.reverse());

        return result_sb.toString();
    }



}
