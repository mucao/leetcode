package com.mucao.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * leetCode题目的地址：https://leetcode.com/problems/jewels-and-stones/description/
 *
 */
public class _771_Jewels_and_Stones_2 {//进行优化

    public int numJewelsInStones(String J, String S) {

        Set<Character> set = new HashSet<>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }

        int sum = 0;
        for (char c: S.toCharArray()) {
            if(set.contains(c))  sum ++;
        }

        return sum;
    }

}
