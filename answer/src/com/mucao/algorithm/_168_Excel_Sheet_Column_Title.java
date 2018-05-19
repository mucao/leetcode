package com.mucao.algorithm;

/**
 * 168. Excel Sheet Column Title
 * leetCode题目地址：https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 *
 */
public class _168_Excel_Sheet_Column_Title {

    String[] chacters = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                        "R","S","T","U","V","W","X","Y","Z"};
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            if(n%26 == 0 ){
                sb.append("Z");
                n = n/26 - 1;
            }else {
                sb.append(chacters[n % 26]);
                n = n/26;
            }

        }

        return sb.reverse().toString();
    }

    public String convertToTitle2(int n) {

        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

}
