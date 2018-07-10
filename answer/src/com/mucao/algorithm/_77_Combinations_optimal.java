package com.mucao.algorithm;

import java.util.*;

/**
 * 77. Combinations
 * 题目地址：https://leetcode.com/problems/combinations/description/
 *
 * 新的优化思路，已经用过的元素，后面就不能再用了。
 */
public class _77_Combinations_optimal {

    public static void main(String[] args) {
        List<List<Integer>> listList = combine(4, 2);
        System.out.println("组合结果： "+listList);
    }

    /**
     * 测试用例：
     * 1.  功能测试：
     * n>=1, 0<k<=n;  n=1, k=1; k=1
     *
     * 2.  边界测试
     * 递归的结束条件
     *
     *
     * 3.  负面测试
     *
     * n<1; k<1; k>n
     *
     * @param n
     * @param k
     * @return
     */

    public static List<List<Integer>> combine(int n, int k) {
        if(n<1||k<1||k>n){
//注意
              return null;
        }


        List<List<Integer>> result_list = new ArrayList<>();
        computeCombine(n, k, 1, new LinkedList<>(), result_list);
        return result_list;
    }


    public static  void computeCombine(int n, int k, int start, LinkedList<Integer> stack, List<List<Integer>> result_list){
        for (int i = start; i <=(n-k+1) ; i++) {
            stack.push(i);
            if(k==1){
                result_list.add(new ArrayList<>(stack));
            }else {//递归调用
                computeCombine(n, k-1, i+1, stack, result_list);
            }
            stack.pop();
        }
    }

    public static List<List<Integer>> computeCombine(int[] nums, int k, LinkedList<Integer> stack){
        List<List<Integer>> result_list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > -1){
                stack.push(nums[i]);
                nums[i] = -1;
                if(k-1 == 0){//不需要再添加元素了
                    List<Integer> Arr_list = new ArrayList<>();
                   Arr_list.addAll(stack);
                    result_list.add(Arr_list);
                }else {
                    int[] nums2 = Arrays.copyOf(nums, nums.length);
                    result_list.addAll(computeCombine(nums2, k-1, stack));
                }
                stack.pop();
            }
        }
        return result_list;
    }

}
