package com.mucao.algorithm;

import java.util.*;

/**
 *A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water. Given a list of stones' positions (in units) in
 * sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially,
 * the frog is on the first stone and assume the first jump must be 1 unit. If the frog's last jump was k units, then
 * its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 *
 * 第403题详细描述网址：https://leetcode.com/problems/frog-jump/description/
 *
 * start： 11:14
 *
 */
public class _403_Frog_Jump {

    public static void main(String[] args) {

        int[] stones = {0,1,3,5,6,8,12,17};
        //int[] stones = {0,2};
        boolean result = new _403_Frog_Jump().canCross(stones);
        System.out.println("The frog can cross river ? "+ result);
    }

    public boolean canCross(int[] stones) {

        Set<Integer> stonesSet = new HashSet<Integer>();
        Arrays.stream(stones).forEach( position -> stonesSet.add(position));
        return ensureAble3(stones[0], 0, stonesSet, stones[stones.length - 1]);
    }

    private boolean ensureAble3(int cur_position, int k, Set<Integer> stonesSet, int end_Position){
        if(cur_position == end_Position){
            return true;
        }

        //k
        int next_position = cur_position + k;
        if(k>0 && stonesSet.contains(next_position)){//存在  --> 继续往前走
            if(ensureAble3(next_position, k, stonesSet, end_Position)){
                return true;
            }
        }

        //k-1
        next_position = cur_position + (k-1);
        if((k-1)>0 && stonesSet.contains(next_position)){//存在  --> 继续往前走
            if(ensureAble3(next_position, k-1, stonesSet, end_Position)){
                return true;
            }
        }

        //k+1
        next_position = cur_position + (k+1);
        if(stonesSet.contains(next_position)){//存在  --> 继续往前走
            if(ensureAble3(next_position, k+1, stonesSet, end_Position)){
                return true;
            }
        }

        return false;
    }

    private void ensureAble2(int[] stones, Map<Integer, List<Integer>> stone_steps, int i, int k) {
        if(k <= 0){
            return ;
        }
        int cur_position = stones[i];
        int next_position = cur_position + k;

        if(stone_steps.containsKey(next_position)){
            stone_steps.get(next_position).add(k);
        }
    }

    /*private void ensureAble(int[] stones, List<List<Integer>> stone_steps, int i, int k) {
        if(k <= 0){
            return ;
        }
        int cur_position = stones[i];
        int next_position = cur_position + k;
        for(int j=i+1; j < stones.length; j++){
            if(stones[j] == next_position){
                stone_steps.get(j).add(k);
            }else if (stones[j] > next_position){
                break;
            }
        }
    }*/

}
