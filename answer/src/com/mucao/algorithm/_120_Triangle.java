package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. Triangle
 * leetCode 120题目地址：https://leetcode.com/problems/triangle/description/
 * 思路，用到了两个数组进行交替迭代。空间复杂度是O(n)，n就是数字三角形的行数。
 *
 */
public class _120_Triangle {

    public static void main(String[] args){
       int[][] arr_2dim = {
                                {2},
                                {3, 4},
                                {6, 5, 7},
                                {4, 1, 8, 3}
                           };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < arr_2dim.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr_2dim[i].length; j++) {
                list.add(arr_2dim[i][j]);
            }
            triangle.add(list);
        }

        int minimum_path = minimumTotal(triangle);
        System.out.println("最小路径和为："+minimum_path);

    }

    public static int minimumTotal(List<List<Integer>> triangle){
        int[] sum_arr = new int[1];
        sum_arr[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int[] cur_sum_arr = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                if(j-1 < 0){
                    cur_sum_arr[j] = sum_arr[j] + list.get(j);
                }else if(j >= sum_arr.length){
                    cur_sum_arr[j] = sum_arr[j-1] + list.get(j);
                }else if(sum_arr[j-1] < sum_arr[j]){
                    cur_sum_arr[j] = sum_arr[j-1] + list.get(j);
                }else{
                    cur_sum_arr[j] = sum_arr[j] + list.get(j);
                }
            }
            sum_arr = cur_sum_arr;
        }

        int minimum_path = sum_arr[0];
        for (int i = 1; i < sum_arr.length; i++) {
            if (sum_arr[i] < minimum_path) {
                minimum_path = sum_arr[i];
            }
        }
        return minimum_path;
    }
}

