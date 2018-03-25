package com.mucao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**leecode problem address: https://github.com/mucao/leetcode/tree/master/answer
 *
 * 思想：先找到每一个字符在字符串中出现的第一个位置和最后一个位置
 *      然后，按照第一次出现位置从小到大的顺序遍历涉及到的字符。
 *      一个part的结束位置，一定包含所有这个part结束位置，所以
 *      遍历的时候，更新当前part的结束位置。直到某一个字符的开始位置大于当前part的结束位置，
 *      那么则找到了一个part。
 */
public class PartitionLabels2 {

    public static void main(String[] args) {
        String S= "ababcbacadefegdehijhklij";
        S="eccbbbbdec";
        List<Integer> list = new PartitionLabels2().partitionLabels(S);
        System.out.println("result: "+list);


    }


    public List<Integer> partitionLabels(String S) {
        int[] start_index = new int[26];
        Arrays.fill(start_index, -1);
        int[] end_index = new int[26];
        Arrays.fill(end_index, -1);

        //建立每个字符的开始--结束索引
        for (int i = 0; i < S.length(); i++) {
            int c_index = S.charAt(i) - 'a';
            if(start_index[c_index] == -1){
                start_index[c_index] = i;
            }
            end_index[c_index] = i;
        }

        //System.out.println("start_index : "+ Arrays.toString(start_index));
        //System.out.println("end_index:  "+ Arrays.toString(end_index));

        int[] indices = new int[500];
        Arrays.fill(indices, -1);
        for (int i = 0; i < start_index.length; i++) {
            if(start_index[i] != -1){
                indices[start_index[i]] = end_index[i];
            }

        }


        List<Integer> part_size_list = new ArrayList<>();
        int part_start = -1;
        int part_end = -1;
        for (int i = 0; i < indices.length; i++) {
            if(indices[i] != -1){
                int c_start = i;
                int c_end = indices[i];
                if(c_start > part_end){
                    if(part_end != -1){
                        part_size_list.add(part_end - part_start + 1);
                    }
                    //更新
                    part_start = c_start;
                    part_end = c_end;
                }else{
                    if( c_end > part_end){
                        part_end = c_end;
                    }
                }
            }
        }
        part_size_list.add(part_end - part_start + 1);
        return part_size_list;
    }

}
