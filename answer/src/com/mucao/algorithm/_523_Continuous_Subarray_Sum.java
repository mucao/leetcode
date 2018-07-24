package com.mucao.algorithm;

public class _523_Continuous_Subarray_Sum {


    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        boolean check = checkSubarraySum(nums, 6);
        System.out.println("是否存在满足要求的连续子数组："+check);
    }

    /**
     * 测试用例：
     *
     * 1. 功能测试： 存在一个连续子数组满足条件；不存在；整个数组刚好满足条件；所有的数字都相等
     *
     *
     * 2. 边界测试：循环的结束条件；是不是可以有办法缩小搜索范围
     *
     * 3. 负面测试：数组长度<2; nums为空；nums没有元素；K小于0；有一个特殊情况：数组中有0，k也是0
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum(int[] nums, int k) {//accepted time : 619ms

        if(nums.length<2||nums==null){
            return false;
        }

        for (int i = 2; i <=nums.length ; i++) {//子数组长度
            for (int j = 0; j <= nums.length-i; j++) {//子数组起始位置
                int sum = 0;
                for (int m = 0; m < i; m++) {//子数组求和
                    sum += nums[j+m];
                }
                if (Check(k, sum)) return true;
            }
        }



        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {//accepted time :52ms  击败4.76%

        if(nums.length<2||nums==null){
            return false;
        }

        for (int i = 2; i <=nums.length ; i++) {//子数组长度
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            if (Check(k, sum)) return true;

            for (int j = i; j < nums.length; j++) {//子数组起始位置
                sum -= nums[j-i];
                sum += nums[j];
                if (Check(k, sum)) return true;
            }
        }
        return false;
    }

    private static boolean Check(int k, int sum) {
        if(sum == 0){
            return true;
        }else {
            if(k!=0){
                if(sum%k == 0){
                    return true;
                }
            }
        }
        return false;
    }

}
