package com.mucao.algorithm;

/**
 * 11. Container With Most Water
 * 地址：https://leetcode.com/problems/container-with-most-water/description/
 */
public class _11_Container_With_Most_Water {

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("maxArea: "+maxArea(heights));
    }

    /**
     * 测试用例：
     *
     * 1. 功能： 可能只有一个线，不能装水；可以装水；两个柱子在两头；两个柱子在中间
     *
     *
     * 2. 边界:
     *          结束时条件；怎样判断最大容量
     *
     *
     * 3. 负面： 空指针；零个元素；一个元素；元素为负值；
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height == null||height.length <= 1){
            return 0;
        }
        return getMaxArea(height);
    }

    private static int  getMaxArea(int[] height) {

        int max_volume = 0;
        int r_max_h = 0;
        int left_start = 0;
        for (int right = height.length-1; right > 0 ; right--) {//会运行到 i=1
            if(height[right] <= r_max_h){
                continue;
            }else {
                r_max_h = height[right];
            }
            for (int left = left_start; left < right; left++) {
                if(height[left] >= height[right]){
                    int r2L_v = height[right]*(right-left);
                    if(r2L_v > max_volume){
                        max_volume = r2L_v;
                    }
                    left_start = left;
                    break;
                }else {// <
                    int r2L_v = height[left]*(right - left);
                    if(r2L_v > max_volume){
                        max_volume = r2L_v;
                    }
                }
            }
        }

        return max_volume;
    }

}
