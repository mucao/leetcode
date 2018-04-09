package com.mucao.algorithm;

/**
 * 在LeetCode上的题目是407，描述网址为：https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * 思路：假设已经把一个单元的水放进去了，然后判断它周围是否可维持出这个单元的水。
 * 其实就是找到漏水的缺口
 *
 */
public class TrappingRainWater2_407 {

    public static void main(String[] args){

        int[][] elevation_map = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}    };



    }

    public int trapRainWater(int[][] heightMap) {

        //找到最高的海拔
        int max_height = -1;
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if(heightMap[i][j] > max_height){
                    max_height = heightMap[i][j];
                }
            }
        }


        for (int level = 1; level <= max_height; level++) {
            boolean[][]  flags = new boolean[heightMap.length][heightMap[0].length];//标志是否计算过某个单元的水
            for (int i = 0; i < heightMap.length; i++) {
                for (int j = 0; j < heightMap[0].length; j++) {
                    //判断单元[i,j]的前后左右四个方向是否会漏水
                    //会漏水：将周围已经计算了水单元中水漏掉
                    //不会漏水，或者判断不了，则加上该单元的水量

                    if(heightMap[i][j] == (level - 1)){
                        if(i-1 <0 || heightMap[i-1][j] < (level -1)){//上方，会漏水
                            System.out.println("哈哈哈");
                        }

                    }

                }
            }

        }


        return 0;
    }

}
