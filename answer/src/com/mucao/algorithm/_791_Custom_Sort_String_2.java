package com.mucao.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _791_Custom_Sort_String_2 {
    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        String result = customSortString(S, T);
        System.out.println("定制顺序的字符串T为："+result);
    }

    public  static String customSortString(String S, String T) {
        StringBuilder result = new StringBuilder();

        char[] S_chars = S.toCharArray();
        Map<Character, Integer> char_count_map = new HashMap<>();

        for (Character c:S_chars) {
            char_count_map.put(c, 0);
        }

        char[] T_chars = T.toCharArray();

        for (Character c:T_chars) {
            Integer c_count = char_count_map.get(c);
            if(c_count != null){
                char_count_map.put(c, (c_count+1));
            }else {
                result.append(c);
            }
        }

        for (char c : S_chars) {

            int count = char_count_map.get(c);

            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

}
