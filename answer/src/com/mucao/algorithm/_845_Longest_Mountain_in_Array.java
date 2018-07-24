package com.mucao.algorithm;

public class _845_Longest_Mountain_in_Array {

    public static void main(String[] args) {
        int[] A = {2,1,4,7,3,2,5};
        int longestMountain = longestMountain(A);
        System.out.println("longestMountain : "+longestMountain);

    }

    public static final int UP = 0;
    public static final int DOWN = 1;

    /**
     * 测试用例
     * 1. 功能测试：有mountain;没有mountain; 整个数组就是一个mountain
     *
     * 2. 边界测试：for循环的结束条件；结束时的情况，以及还需要后续处理吗？
     *
     * 3. 负面测试： 数组长度不满足length>=3；存在相同的数字；所有数字都相等
     *
     * (如果是面试的话，还要考虑抛出异常的问题)
     *
     * @param A
     * @return
     */
    public static int longestMountain(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }

        int direction = DOWN;
        int left = A.length;
        int right = A.length;
        int longest_length = 0;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i] < A[i+1]){
                if(direction == DOWN){
                    left = right;
                    right = i;
                    if((right-left+1)>longest_length){
                        longest_length = right - left+1;
                    }
                    direction = UP;
                }
            }else if (A[i] == A[i+1]){
                if(direction == DOWN){
                    left = right;
                    right = i;
                    if((right-left+1)>longest_length){
                        longest_length = right - left+1;
                    }
                    left = A.length;
                    right = A.length;
                }

                if(direction == UP){
                    left = A.length;
                    right = A.length;
                    direction = DOWN;
                }
            }else {//A[i] > A[i+1]
                if(direction == UP){
                    direction = DOWN;
                }
            }

        }

        if(direction == DOWN){
            left = right;
            right = A.length-1;
            if((right - left+1) > longest_length){
                longest_length = right - left+1;
            }
        }

        return longest_length;
    }

}
