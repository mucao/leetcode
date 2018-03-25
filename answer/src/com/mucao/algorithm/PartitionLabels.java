package com.mucao.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        String S= "ababcbacadefegdehijhklij";
        S="eccbbbbdec";
        List<Integer> list = new PartitionLabels().partitionLabels(S);
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

        System.out.println("start_index : "+ Arrays.toString(start_index));
        System.out.println("end_index:  "+ Arrays.toString(end_index));

        //对起始位置进行排序
        List<Integer> starts_list = new ArrayList<>();
        List<Integer> end_list = new ArrayList<>();

        for (int i = 0; i < start_index.length; i++) {
            if(start_index[i] != -1){
                starts_list.add(start_index[i]);
                end_list.add(end_index[i]);
            }
        }

        for (int i = 0; i < starts_list.size()-1; i++) {
            int min_index = i;
            for (int j = i; j < starts_list.size(); j++) {
                if(starts_list.get(j) < starts_list.get(min_index)){
                    min_index = j;
                }
            }
            if(min_index != i){
                int tmp = starts_list.get(i);
                starts_list.set(i, starts_list.get(min_index));
                starts_list.set(min_index, tmp);

                //对应的要交换ends_list中的内容
                tmp = end_list.get(i);
                end_list.set(i, end_list.get(min_index));
                end_list.set(min_index, tmp);
            }

        }

        System.out.println("starts_list : "+starts_list.toString());
        System.out.println("end_list: "+end_list.toString());

        List<Integer> part_size_list = new ArrayList<>();
        int part_start = starts_list.get(0);
        int part_end = end_list.get(0);
        for (int i = 0; i < starts_list.size(); i++) {
            int c_start = starts_list.get(i);
            int c_end = end_list.get(i);
            if(c_start > part_end){
                part_size_list.add(part_end - part_start + 1);

                //更新
                part_start = c_start;
                part_end = c_end;
            }else{
                if( c_end > part_end){
                    part_end = c_end;
                }
            }
        }
        part_size_list.add(part_end - part_start + 1);
        return part_size_list;
    }

}
