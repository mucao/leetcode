package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Problem address: https://leetcode.com/problems/permutations/description/
 * 使用回溯法
 *
 */
public class _46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute2(nums);
        System.out.println(lists.toString());
    }


    public static List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if(nums == null||nums.length == 0){
            return list;
        }
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;

    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /**
     * 每一步都是有多个选择的。
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result_list = new ArrayList<>();
        if(nums == null||nums.length == 0){
            return result_list;
        }

        //获取每一个可能的排列
        getPermute(nums, result_list, new ArrayList<>());

        return result_list;
    }

    public static void getPermute(int[] nums, List<List<Integer>> result_list, List<Integer> selected_list){
        if(selected_list.size() == nums.length){
            result_list.add(selected_list);
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!selected_list.contains(nums[i])){
                List<Integer> selected_list_2 = new ArrayList<>(selected_list);
                selected_list_2.add(nums[i]);
                getPermute(nums, result_list, selected_list_2);
            }
        }

    }


}
