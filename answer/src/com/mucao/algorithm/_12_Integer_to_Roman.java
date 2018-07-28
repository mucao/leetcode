package com.mucao.algorithm;

public class _12_Integer_to_Roman {

    public static void main(String[] args) {
        System.out.println(intToRoman(27));
    }

    /**
     * 测试
     *
     * 1. 功能：   数字转罗马数字；注意4和9的情况要特殊处理；其实主要还是1-9怎么转换；1；3999
     *
     * 2. 边界：   结束条件；结束情况，需要特殊处理吗？
     *
     * 3. 负面：   输入的数字范围不在 1 to 3999.
     * @param num
     * @return
     */
    private static String[] str_1000 = {"", "M", "MM", "MMM"};//千位
    private static String[] str_100 = {"", "C", "CC", "CCC","CD","D","DC","DCC","DCCC","CM"};//百位
    private static String[] str_10 = {"", "X", "XX", "XXX","XL","L","LX","LXX","LXXX","XC"};//十位
    private static String[] str_1 = {"", "I", "II", "III","IV","V","VI","VII","VIII","IX"};//个位

    public static String intToRoman2(int num) {//使用 String 48ms
        if(num < 1 || num >3999){
            return null;
        }

        String result = "";
        //千 -> 个位

        if(num/1000 > 0){
            result += str_1000[num/1000];
            num = num %1000;

        }

        if(num/100 > 0){
            result += str_100[num/100];
            num = num %100;
        }

        if(num/10 > 0){
            result += str_10[num/10];
            num = num %10;
        }

        if(num > 0){
            result += str_1[num];
        }


        return result;
    }

    public static String intToRoman(int num) {//使用StringBuilder 46ms
        if(num < 1 || num >3999){
            return null;
        }

        StringBuilder strB = new StringBuilder();
        //千 -> 个位

        if(num/1000 > 0){
            strB.append(str_1000[num/1000]);
            num = num %1000;

        }

        if(num/100 > 0){
            strB.append(str_100[num/100]);
            num = num %100;
        }

        if(num/10 > 0){
            strB.append(str_10[num/10]);
            num = num %10;
        }

        if(num > 0){
            strB.append(str_1[num]);
        }


        return strB.toString();
    }
}
