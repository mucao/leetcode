package com.mucao.algorithm;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * 题目地址：https://leetcode.com/problems/3sum-closest/description/
 *
 */
public class _16_3Sum_Closest {

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        System.out.println("-> : "+threeSumClosest2(nums, 82));

    }

    /**
     * 所谓的最接近，其实就是与目标值的差值(取绝对值)最小
     *
     * 结合2-sum 来做
     *
     * 测试用例
     *
     * 1. 功能
     *          能找到最接近的；找不到
     *
     * 2. 边界
     *          寻找组合的时候，结束条件；避免重复组合
     *
     *
     * 3. 负面
     *          空指针；没有元素；元素个数小于3个
     *
     * @param nums
     * @param target
     * @return
     */

    public static int threeSumClosest2(int[] nums, int target) {

        if(nums == null||nums.length < 3){
            return  0 ;//没有找到;应该用全局变量或者异常来处理比较好
        }

        Arrays.sort(nums);

        int min_diff = Integer.MAX_VALUE;
        int target_sum = 0;
        for (int i = 0; i < nums.length-2 ; i++) {
            int low = i+1;
            int high = nums.length - 1;
            int sum = nums[i] + nums[low] + nums[high];
            if(sum == target){
                return sum;
            }else if(sum > target){
                while (low < high && sum >= target){
                    sum = nums[i] + nums[low] + nums[high];
                    high --;
                }
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                }else {// <
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                    sum = nums[i]+nums[low] + nums[high+1];
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                }

            }else if(sum < target){
                while(low < high && sum <=target){
                    sum = nums[i] + nums[low] + nums[high];
                    low ++;
                }
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                }else { // >
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                    sum = nums[i] + nums[low-1] + nums[high];
                    if(Math.abs(sum - target) < min_diff){
                        min_diff = Math.abs(sum - target);
                        target_sum = sum;
                    }
                }

            }

        }

        return target_sum;
    }

    public static int threeSumClosest(int[] nums, int target) {//99ms 5.11%

        if(nums == null||nums.length < 3){
            return  0 ;//没有找到;应该用全局变量或者异常来处理比较好
        }

        int dif = Integer.MAX_VALUE;
        int target_sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int dif2 = Math.abs(sum - target);
                    if(dif2 < dif){
                        dif = dif2;
                        target_sum = sum;
                    }
                }
            }

        }


        return target_sum;
    }

}
