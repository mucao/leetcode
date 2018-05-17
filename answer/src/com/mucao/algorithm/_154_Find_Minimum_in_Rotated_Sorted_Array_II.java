package com.mucao.algorithm;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * leetCode题目地址：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * 思路，由于旋转后，整个数组还是基本有序的，所以可以使用二分查找来找到那个旋转位置，然后提取出最小元素
 *
 */
public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {

    public static void main(String[] args) {
        //[1,2,2,2,0,1,1]
        int[] nums =  {1,2,2,2,0,1,1};
        int min = findMin(nums);
        System.out.println("min = "+min);

    }

    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int low = 0;
        int high= nums.length -1;
        int target = nums[0];//作为初始比较对象
        if(nums[high] > target){
            return  target;
        }else{
            while(high >0 && nums[high] == target ){
                high --;
            }
        }

        if(nums[high] > target){
            return target;
        }

        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] >= target){
                low = mid + 1;
            }else {
                high = mid  ;
            }
        }

        return nums[high];
    }


}
