package com.mucao.algorithm;

/**
 * 在Leetcode上的问题地址： https://leetcode.com/problems/trapping-rain-water/description/
 *
 * 解决思想：一层一层的进行判断，看看假如把水装进去了，会不会流走，如果不会流走，那么就是可以保持住这些水的。
 *
 * 使用类似于KMP的算法，进行优化。可以跳过一些单元
 *
 * 进一步优化，其实用两次遍历就可以实现了
 */
public class TrappingRainWater2 {

    public static void main(String[] args) {

        //int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        int trapWater = new TrappingRainWater2().trap(heights);
        System.out.println("可以存储的水是："+trapWater);
    }

    public int trap(int[] heights) {
        int sum_capacity = 0;

        //1、 从左到右
        int max_height = -1;
        int capacity = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] >= max_height){
                sum_capacity += capacity;
                capacity = 0;
                max_height = heights[i];
            } else{
                capacity += max_height - heights[i]; //开始注水
            }
        }

        //2、从右到左
        int max_height_2 = -1;
        capacity = 0;
        for (int i = heights.length - 1 ; i >= 0 ; i--) {

            if(heights[i] > max_height_2){
                sum_capacity += capacity;
                capacity = 0;
                max_height_2 = heights[i];
                if(max_height_2 >= max_height){
                    break;
                }
            }else{
                capacity += max_height_2 - heights[i];//开始注水
            }
        }
        return sum_capacity;
    }
}
