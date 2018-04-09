package com.mucao.algorithm;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 在Leetcode上的问题地址： https://leetcode.com/problems/trapping-rain-water/description/
 *
 * 解决思想：一层一层的进行判断，看看假如把水装进去了，会不会流走，如果不会流走，那么就是可以保持住这些水的。
 *
 * 使用类似于KMP的算法，进行优化。可以跳过一些单元
 */
public class TrappingRainWater {

    public static void main(String[] args) {

//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        int trapWater = new TrappingRainWater().trap(heights);
        System.out.println("可以存储的水是："+trapWater);
    }

    public int trap(int[] heights) {

        //找到最高的海拔
        int max_height = -1;
        for (int height : heights) {
            if(height > max_height){
                max_height = height ;
            }
        }


        int sum_capacity = 0;
        int[] next_unit = new int[heights.length];
        for (int i = 0; i < next_unit.length; i++) {
            next_unit[i] = i+1; //初始化，就是正常的下标迭代。
        }


        while(max_height > 0 ){
            boolean left_flag = false;
            int capacity = 0;
            int start_index = -1;
            for (int i = 0; i < heights.length; i = next_unit[i]) {

                if(heights[i] >= max_height){

                    if(start_index == -1){
                        start_index = i;
                    }else{
                        next_unit[start_index] = next_unit[i];
                    }

                    left_flag = true;

                    sum_capacity += capacity;
                    capacity = 0;
                }else{
                    if(left_flag == true){ //计算水容量
                        capacity += max_height - heights[i];

                    }

                }

            }
            max_height --;
        }

        return sum_capacity;
    }

}
