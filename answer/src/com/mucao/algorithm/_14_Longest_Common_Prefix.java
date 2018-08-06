package com.mucao.algorithm;

/**
 * 14. Longest Common Prefix
 *
 */
public class _14_Longest_Common_Prefix {

    public static void main(String[] args) {
       String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));;
    }

    /**
     * 测试：
     *
     * 1. 功能： 有最长公共前缀子串；没有；只有一个元素
     *
     * 2. 边界： 查找的结束条件
     *
     * 3. 负面： 空指针；没有元素；元素不符合题目要求
     *
     * @param strs
     * @return
     */
    public static  String longestCommonPrefix2(String[] strs) {//竖着求解

        if(strs == null|| strs.length == 0){
            return "";
        }


        int index = 0;
        for (; index < strs[0].length(); index++) {
            boolean break_flag = false;
            for (int j = 1; j < strs.length; j++) {
                if(index >= strs[j].length()||strs[j].charAt(index) != strs[0].charAt(index)){
                    break_flag = true;
                    break;
                }
            }
            if(break_flag){
                break;
            }
        }

        return strs[0].substring(0, index);
    }

    public static  String longestCommonPrefix(String[] strs) {//9ms

        if(strs == null|| strs.length == 0){
            return "";
        }

        String common_prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int end = 0;
            for (; end < Math.min(common_prefix.length(), strs[i].length()); end++) {
                if(common_prefix.charAt(end) != strs[i].charAt(end)){
                    break;
                }
            }
            if(end == 0){
                return "";
            }
            common_prefix = common_prefix.substring(0, end);

        }


        return common_prefix;
    }

}
