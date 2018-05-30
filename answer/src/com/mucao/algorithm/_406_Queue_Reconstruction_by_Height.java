package com.mucao.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * startTime : 9:33
 * endTime: 13:40
 * 406. Queue Reconstruction by Height
 * leetCode题目地址：https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * 思路：先排序，然后再找合适的位置
 *
 */
public class _406_Queue_Reconstruction_by_Height {

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result_arr = reconstructQueue2(people);
        for (int i = 0; i < result_arr.length; i++) {
            System.out.print(Arrays.toString(result_arr[i])+", ");
        }

    }


    //18ms  17ms  18ms
    public static int[][] reconstructQueue2(int[][] people) {

        if(people == null){
            return null;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return -(p1[0] != p2[0] ? p1[0] - p2[0] : p2[1] - p1[1]);
            }
        });
        //开始重排
        List<int[]> result_list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            result_list.add(people[i][1], people[i]);
        }

        return result_list.toArray(people);
    }

    //29ms
    public static int[][] reconstructQueue(int[][] people) {

        if(people == null){
            return null;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return -(p1[0] != p2[0] ? p1[0] - p2[0] : p2[1] - p1[1]);
            }
        });

        /*for (int i = 0; i < people.length; i++) {
            System.out.print(Arrays.toString(people[i])+",");
        }*/


        //开始重排
        int pre_greater_num = 0; //在当前元素(第i个)，之前大于当前元素的元素有多少个
        for (int i = 0; i < people.length; i++) {
            int[] p_arr = people[i];

            int move_step = pre_greater_num - p_arr[1];
            for (int j = i; j > (i-move_step); j--) {
                int[] tmp_arr = people[j];
                people[j] = people[j-1];
                people[j-1] = tmp_arr;
            }
            pre_greater_num ++;
        }

       /* System.out.println("重排后：");
        Arrays.stream(people).map(Arrays::toString).map(str -> str+",").forEach(System.out::print);
       */

        return people;
    }
}
