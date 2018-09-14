package com.mucao.algorithm;

public class _198_House_Robber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int max_rob_money = new _198_House_Robber().rob3(nums);
        System.out.println("最大可偷钱数："+max_rob_money);

    }

    /**
     * 测试用例
     *
     * 1. 功能
     *      可以计算出最大获得的钱数; 只有一个门；两个门；三个门；门里面的钱都是一样的。
     *
     * 2. 边界
     *      结束条件；动态规划的状态转移
     *
     *
     * 3. 负面
     *
     *      nums为null; 没有元素；元素里面有负数
     *
     *
     * @param nums
     * @return
     */
    public int rob4(int[] nums) {
        if(nums == null|| nums.length == 0){
            return 0;
        }
        int pre_house = -1;
        int pre_max = 0;
        int pre_pre_max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(pre_house == i-1){
                int max_1 = pre_pre_max + nums[i];
                int max_2 = pre_max;
                pre_pre_max = pre_max;
                pre_max = max_1 >= max_2 ?  max_1 : max_2;
                pre_house = max_1 >= max_2 ? i : i-1;
            }else {
                pre_pre_max = pre_max;
                pre_max = pre_max+nums[i];
                pre_house = i;
            }
        }

        return pre_max;
    }

    public int rob3(int[] nums) {

        if(nums == null|| nums.length == 0){
            return 0;
        }

//        Status[] f = new Status[nums.length];

        int pre_house = -1;
        int pre_max = 0;
        int pre_pre_max = 0;
        int current_max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(pre_house != (i-1) ){
                pre_pre_max = pre_max;
                pre_max = pre_max+nums[i];
                pre_house = i;
            }else {// f(i-1)的最后一个房子就是i-1。
                int max_1 = pre_pre_max + nums[i];
                int max_2 = pre_max;
                if(max_1 >= max_2){
                    pre_pre_max = pre_max;
                    pre_max = max_1;
                    pre_house = i;
                }else {
                    pre_pre_max = pre_max;
                    pre_max = max_2;
                    pre_house = i-1;
                }
            }
        }

       /* for (int i = 0; i < nums.length; i++) {
            if((i-1)>=0 && f[i-1].last_house != (i-1) ){
                f[i] = new Status(f[i-1].max_money+nums[i], i);
            }else {// f(i-1)的最后一个房子就是i-1。
                int max_1 = (i-1-1 >= 0 ? f[i-1-1].max_money : 0) + nums[i];
                int max_2 = i-1 >= 0 ? f[i-1].max_money : 0;
                if(max_1 > max_2){
                    f[i] = new Status(max_1, i);
                }else {
                    f[i] = new Status(max_2, i-1);
                }
            }
        }
*/



        return pre_max;
    }


    public int rob2(int[] nums) {

        if(nums == null|| nums.length == 0){
            return 0;
        }

        Status[] f = new Status[nums.length];
        /*f[0] = new Status(nums[0], 0);
        if(nums.length == 1){
            return f[0].max_money;
        }
        if(nums[0] > nums[1]){
            f[1] = new Status(nums[0], 0);
        }else {
            f[1] = new Status(nums[1], 1);
        }
        if(nums.length == 2){
            return f[1].max_money;
        }
        if((nums[0]+nums[2])>nums[1]){
            f[2] = new Status((nums[0] + nums[2]), 2);
        }else {
            f[2] = new Status(nums[1], 1);
        }
        if(nums.length == 3){
            return f[2].max_money;
        }
*/
        for (int i = 0; i < nums.length; i++) {
            if((i-1)>=0 && f[i-1].last_house != (i-1) ){
                f[i] = new Status(f[i-1].max_money+nums[i], i);
            }else {//
                int max_1 = (i-1-1 >= 0 ? f[i-1-1].max_money : 0) + nums[i];
                int max_2 = i-1 >= 0 ? f[i-1].max_money : 0;
                if(max_1 > max_2){
                    f[i] = new Status(max_1, i);
                }else {
                    f[i] = new Status(max_2, i-1);
                }
            }
        }

        return f[nums.length-1].max_money;
    }

    public int rob(int[] nums) {

        if(nums == null|| nums.length == 0){
            return 0;
        }

        Status[] f = new Status[nums.length];
        f[0] = new Status(nums[0], 0);
        if(nums.length == 1){
            return f[0].max_money;
        }
        if(nums[0] > nums[1]){
            f[1] = new Status(nums[0], 0);
        }else {
            f[1] = new Status(nums[1], 1);
        }
        if(nums.length == 2){
            return f[1].max_money;
        }
        if((nums[0]+nums[2])>nums[1]){
            f[2] = new Status((nums[0] + nums[2]), 2);
        }else {
            f[2] = new Status(nums[1], 1);
        }
        if(nums.length == 3){
            return f[2].max_money;
        }

        for (int i = 3; i < nums.length; i++) {
            if(f[i-1].last_house != (i-1) ){
                f[i] = new Status(f[i-1].max_money+nums[i], i);
            }else {//
                int max_1 = f[i-1-1].max_money + nums[i];
                int max_2 = f[i-1].max_money;
                if(max_1 > max_2){
                    f[i] = new Status(max_1, i);
                }else {
                    f[i] = new Status(max_2, i-1);
                }
            }
        }

        return f[nums.length-1].max_money;
    }

    private static class Status{
        int max_money;
        int last_house;

        public Status(int max_money, int last_house) {
            this.max_money = max_money;
            this.last_house = last_house;
        }
    }


}

