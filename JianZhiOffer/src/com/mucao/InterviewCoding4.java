package com.mucao;

public class InterviewCoding4 {

    public static void main(String[] args) {
        int[][] numbers = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(IsExist(new int[][]{}, 7));
    }

    public static boolean IsExist(int[][] numbers, int num ){
        //处理无效输入
        if(numbers == null || numbers.length == 0){
            return  false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i].length == 0 || numbers[i].length != numbers[0].length){
                return false;
            }
        }

        //开始查找
        int col = -2;
        for (int i = 0; i < numbers[0].length; i++) {
            if(numbers[0][i] == num) {
                return true;
            }else if(numbers[0][i] > num){
                col = i-1;
                break;
            }
        }

        if(col == -1){
            return  false;
        }
        if(col == -2){
            col = numbers[0].length -1;
        }

        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i][col] == num){
                return true;
            }else if(numbers[i][col] > num){
                return false;
            }
        }
        return false;
    }

}
