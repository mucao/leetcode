package com.mucao.algorithm;

import java.util.*;

/**
 * 697. Degree of an Array
 * leetCode题目地址：https://leetcode.com/problems/degree-of-an-array/description/
 */
public class _697_Degree_of_an_Array {


    //43ms
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> frequency_map = new HashMap<>();
        //map:   num ->[次数， 第一次位置，最后一次位置]
        int max_frequency = 1;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = frequency_map.get(nums[i]);
            if(list == null){
                list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                frequency_map.put(nums[i], list);
            }else{
                int new_frequency = list.get(0) + 1;
                if(new_frequency > max_frequency){
                    max_frequency = new_frequency;
                }
                list.set(0, new_frequency);
                list.set(2, i);
            }
        }
        int smallest_length = 50000;
        for (Map.Entry<Integer, List<Integer>> entry : frequency_map.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.get(0) == max_frequency){
                int length = list.get(2) - list.get(1) + 1;
                if(length < smallest_length){
                    smallest_length = length;
                }
            }

        }
        return smallest_length;
    }

}
