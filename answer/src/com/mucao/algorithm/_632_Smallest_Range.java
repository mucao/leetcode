package com.mucao.algorithm;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 632. Smallest Range
 * 题目地址：https://leetcode.com/problems/smallest-range/description/
 *
 */
public class _632_Smallest_Range {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        int[] arr_1 = {4,10,15,24,26};
//        int[] arr_1 = {1,2,3};
        List<Integer> list_1 = new ArrayList<>();
        Arrays.stream(arr_1).forEach(list_1::add);
        int[] arr_2 = {0,9,12,20};
//        int[] arr_2 = {1,2,3};
        List<Integer> list_2 = new ArrayList<>();
        Arrays.stream(arr_2).forEach(list_2::add);
        int[] arr_3 = {5,18,22,30};
//        int[] arr_3 = {1,2,3};
        List<Integer> list_3 = new ArrayList<>();
        Arrays.stream(arr_3).forEach(list_3::add);
        nums.add(list_1);
        nums.add(list_2);
        nums.add(list_3);

        int[] result_Arr = smallestRange(nums);
        System.out.println(Arrays.toString(result_Arr));


    }


    public static int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == null||nums.get(i).isEmpty()){
                return null;
            }
        }

        /**
         * 为了每次都可以找到最小的元素，可以使用的容器有：
         * TreeSet  TreeMap   PriorityQueue
         *
         * 由于有重复的元素，所以TreeMap不行
         * TreeSet内部是使用TreeMap实现的，所以也是不行的。
         *
         * PriorityQueue内部使用的是优先级堆
         *
         * 题目中说的是"升序"，也就是没有重复数字。
         *
         */
        int[] result_Arr = getSmallestRange(nums);


        return result_Arr;
    }

    private static int[] getSmallestRange(List<List<Integer>> nums) {

        TreeSet<Element> treeSet = new TreeSet<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e1.value - e2.value;
            }
        });

        //初始化优先级队列
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list_i = nums.get(i);
            Integer value = list_i.remove(0);
            treeSet.add(new Element(value, i));
        }

        int[] result_Arr = new int[2];
        result_Arr[0] = treeSet.first().value;
        result_Arr[1] = treeSet.last().value;


        //开始查找最小范围
        while(!numsIsEmpty(nums)){
            Element target_ele = null;
            for (Element element:treeSet) {
                if(!nums.get(element.list_num).isEmpty()){
                    target_ele = element;
                    break;
                }
            }
            if(target_ele!=null){
                treeSet.remove(target_ele);
                Integer value = nums.get(target_ele.list_num).remove(0);
                int list_num = target_ele.list_num;
                treeSet.add(new Element(value, list_num));

                //判断是否更新区间
                int low = treeSet.first().value;
                int high = treeSet.last().value;
                if((high-low)<(result_Arr[1]-result_Arr[0])){
                    result_Arr[0] = low;
                    result_Arr[1] = high;
                }
            }

        }


        return result_Arr;
    }

    public static boolean numsIsEmpty(List<List<Integer>> nums){

        boolean isEmpty = true;
        for (List<Integer> list:nums) {
            isEmpty = isEmpty && (list.isEmpty());
            if(!isEmpty){
                return  isEmpty;
            }
        }

        return isEmpty;
    }

    /**
         * 测试用例：
         * 1. 功能测试：每个列表都有多个数字；有重复数字；没有重复数字；每个列表里面只有一个数字
         *
         * 2. 边界测试： 循环的结束条件
         *
         * 3. 负面测试： 空指针; nums为空；存在某个链表中没有元素。
         */


    private static class Element{
        Integer value ;
        int list_num;

        public Element(Integer value, int list_num) {
            this.value = value;
            this.list_num = list_num;
        }

    }

}
