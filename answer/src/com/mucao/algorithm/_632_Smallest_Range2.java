package com.mucao.algorithm;

import java.util.*;
import java.util.function.Consumer;

/**
 * 632. Smallest Range
 * 题目地址：https://leetcode.com/problems/smallest-range/description/
 *
 * 发现使用treeSet无法处理重复数字，现在改用PriorityQueue
 */
public class _632_Smallest_Range2 {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
//        int[] arr_1 = {4,10,15,24,26};
        int[] arr_1 = {1,2,3};
        List<Integer> list_1 = new ArrayList<>();
        Arrays.stream(arr_1).forEach(list_1::add);
//        int[] arr_2 = {0,9,12,20};
        int[] arr_2 = {1,2,3};
        List<Integer> list_2 = new ArrayList<>();
        Arrays.stream(arr_2).forEach(list_2::add);
//        int[] arr_3 = {5,18,22,30};
        int[] arr_3 = {1,2,3};
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

    /**
     * 测试用例：
     * 1. 功能测试：每个列表都有多个数字；有重复数字；没有重复数字；每个列表里面只有一个数字
     *
     * 2. 边界测试： 循环的结束条件
     *
     * 3. 负面测试： 空指针; nums为空；存在某个链表中没有元素。
     */

    private static int[] getSmallestRange(List<List<Integer>> nums) {

        MyCollection<Element> myCollection = new MyCollection<>();

        //初始化优先级队列
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list_i = nums.get(i);
            Integer value = list_i.remove(0);
            myCollection.add(new Element(value, i));
        }

        int[] result_Arr = new int[2];
        result_Arr[0] = myCollection.getMin().value;
        result_Arr[1] = myCollection.getMax().value;
        if(result_Arr[0] == result_Arr[1]){
            return result_Arr;
        }

        //开始查找最小范围
        while(!numsIsEmpty(nums)){
            Element target_ele = null;
            for (Element element:myCollection) {
                if(!nums.get(element.list_num).isEmpty()){
                    target_ele = element;
                    break;
                }
            }
            if(target_ele!=null){
                myCollection.delete(target_ele);
                Integer value = nums.get(target_ele.list_num).remove(0);
                int list_num = target_ele.list_num;
                myCollection.add(new Element(value, list_num));

                //判断是否更新区间
                int low = myCollection.getMin().value;
                int high = myCollection.getMax().value;
                if((high-low)<(result_Arr[1]-result_Arr[0])){
                    result_Arr[0] = low;
                    result_Arr[1] = high;
                    if(result_Arr[0] == result_Arr[1]){
                        return  result_Arr;
                    }
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
     * 有最大元素和最小元素，并且必须能处理重复元素
     * @param <T>
     */
    private static class  MyCollection<T extends Comparable<T>> implements  Iterable<T>{
        TreeSet<T> treeSet = new TreeSet<>();
        List<T>  duplicated_eles = new LinkedList<>();

        public T getMax(){

            return treeSet.last();
        }

        public T getMin(){

            return treeSet.first();
        }

        public boolean delete(T e){
            boolean flag = treeSet.remove(e);
            if(flag){
                if(!duplicated_eles.isEmpty()){
                    List<T> temp_list = new LinkedList<>();
                    for (T ele:duplicated_eles) {
                        if(!treeSet.add(ele)){
                            temp_list.add(ele);
                        }
                    }
                    duplicated_eles = temp_list;
                }
            }

            return flag;
        }

        public boolean add(T e){
            boolean flag = treeSet.add(e);
            if(!flag){
                duplicated_eles.add(e);
            }

            return flag;
        }

        @Override
        public Iterator iterator() {
            return treeSet.iterator();
        }

        @Override
        public void forEach(Consumer action) {
            treeSet.forEach(action);
        }

        @Override
        public Spliterator spliterator() {
            return treeSet.spliterator();
        }
    }

    private static class Element implements  Comparable<Element>{
        Integer value ;
        int list_num;

        public Element(Integer value, int list_num) {
            this.value = value;
            this.list_num = list_num;
        }


        @Override
        public int compareTo(Element e2) {
            return this.value - e2.value;
        }
    }

}
