package com.mucao.algorithm;

public class _7_Reverse_Integer {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        int x = 120;
        System.out.println(reverse(x));
    }

    /**
     * 测试用例
     *
     * 1. 功能
     *         反转；正数；负数；零；只有一个数字；反转后第一个数字是0
     *
     * 2. 边界
     *          注意循环结束条件；还有结束时的情况处理
     *
     * 3. 负面
     *          溢出；
     *
     * @param x
     * @return
     */
    public static  int reverse(int x) {
        if(-10 < x && x <10){
            return x;
        }

        return getReverse(x);
    }

    private static  int getReverse(int x) {
        int value = x;
        long re_val = 0;
        while(value!=0){
            re_val = re_val*10+value%10;
            value = value/10;
        }

        if(re_val>Integer.MAX_VALUE||re_val<Integer.MIN_VALUE){
            return 0;
        }
        return (int)re_val;
    }

}
