package com.mucao;

public class P_99_Excel_question {

    public static void main(String[] args) {
//        String str;
//        System.out.println(str+"在Excel中表示第"+parse(str)+"列");
          int num = 28;
        System.out.println("第"+num+"列在Excel中的字符表示为："+reverseParse(num));

    }

    public static int parse(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num += (str.charAt(i)-'A'+1)*(Math.pow(26, str.length()-1-i));
        }
        return num;
    }

    //对上面那个函数的反向解析
    public static String reverseParse(int num){
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            char low = (char)(num%26 - 1 + 'A');
            sb.append(low);
            num = num/26;
        }

        return sb.reverse().toString();
    }

}
