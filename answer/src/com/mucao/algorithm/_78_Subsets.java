package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. Subsets
 * leetCode题目地址：https://leetcode.com/problems/subsets/description/
 */
public class _78_Subsets {

    public static void main(String[] args) {
         int[] nums = {1,2,3};
        List<List<Integer>> result_lists = subsets3(nums);
        System.out.println(result_lists.toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result_lists = new LinkedList<>();
        for (int count = 0; count < Math.pow(2, nums.length); count++) {
            //转换成二进制
            String count_bin = Integer.toBinaryString(count);

            //找到对应的元素, 组成子集
            List<Integer> list = new LinkedList<>();
            char[] chars = count_bin.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(chars[chars.length -1 - i] == '1'){
                    list.add(nums[i]);
                }
            }
            result_lists.add(list);
        }
        return result_lists;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result_lists = new LinkedList<>();
        for (int count = 0; count < Math.pow(2, nums.length); count++) {
            //转换成二进制
            //找到对应的元素, 组成子集
            List<Integer> list = new LinkedList<>();
            int tmp = count;
            for (int i = 0; tmp!=0&&i < nums.length; i++, tmp = tmp/2) {
                if(tmp%2 == 1){
                    list.add(nums[i]);
                }
            }
            result_lists.add(list);
        }
        return result_lists;
    }

    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); //因为在这个for循环中，只有这一个tempList在不停的被使用，所以当再次被使用的
            //时候，需要将前面的内容清除掉
        }
    }

}
