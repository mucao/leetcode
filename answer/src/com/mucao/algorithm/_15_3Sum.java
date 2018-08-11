package com.mucao.algorithm;

import java.util.*;

public class _15_3Sum {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        nums = new int[]{0, 0, 0, 0};
        List<List<Integer>> triplets = threeSum_optimal(nums);
        System.out.println(triplets);

    }

    /**
     * 测试用例
     *
     * 1. 功能
     *      存在三元组；不存在三元组;有重复三元组;三个0;input [0,0,0,0]
     *
     * 2. 边界
     *      结束条件
     *
     * 3. 负面
     *
     *      空指针；数组长度小于3;重复问题
     *
     *      1,1,1
     *      1,1,5
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum_optimal(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if(nums == null||nums.length < 3){
            return triplets;
        }
        //1. 三元组  2. 去重复
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(i>0 && a == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                if(j>(i+1) && b == nums[j-1]){
                    continue;
                }
                if(b > (0-a)){
                    break;
                }

                //确定c
                int c = 0-(a+b);
                if( c < b){
                    continue;
                }
                if(map.containsKey(c)){
                    int count = map.getOrDefault(c, 0);
                    if(c == a){
                        count --;
                    }
                    if (c == b){
                        count --;
                    }
                    count --;
                    if(count >= 0){
                        triplets.add(Arrays.asList(a, b, c));
                    }

                }


            }

        }

        return triplets;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if(nums == null||nums.length < 3){
            return triplets;
        }
        //1. 三元组  2. 去重复
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(i>0 && a == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {

                int b = nums[j];
                if(j>(i+1) && b == nums[j-1]){
                    continue;
                }
                if(b > (0-a)){
                    break;
                }
                for (int k = j+1; k < nums.length; k++) {
                    int c = nums[k];
                    if(k > (j+1) && c == nums[k-1]){
                        continue;
                    }
                    if((a+b+c) == 0){
                        triplets.add(Arrays.asList(a, b, c));
                    }else {
                        if(b+c > (0-a)){
                            break;
                        }
                    }
                }
            }
        }

        return triplets;
    }


}
