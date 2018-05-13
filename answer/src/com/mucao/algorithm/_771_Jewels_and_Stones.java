package com.mucao.algorithm;

/**
 * 771. Jewels and Stones
 * leetCode题目的地址：https://leetcode.com/problems/jewels-and-stones/description/
 *
 */
public class _771_Jewels_and_Stones {

    public int numJewelsInStones(String J, String S) {
        int[] map = new int['z' - 'A' + 1];
        for (char c:S.toCharArray()) {
            map[c - 'A'] ++;
        }
        int sum_Jewels = 0;
        for (char c:J.toCharArray()) {
            sum_Jewels += map[c - 'A'];
        }
        return sum_Jewels;
    }

}
