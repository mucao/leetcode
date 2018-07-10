package com.mucao.algorithm;

public class _466_Count_The_Repetitions {

    public static void main(String[] args) {
        /*String s1 = "acb";
        String s2 = "cba";
        System.out.println("s2需要由"+s2_Consist_Of_N_S2_optimal(s1, s2)+"个s1来组成");*/
        String s1 = "aaa";
        int n1 = 3;
        String s2 = "aa";
        int n2 = 1;
        int result = getMaxRepetitions2(s1, n1, s2, n2);
        System.out.println("result : "+result);

    }


    public static int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        //错误处理
        if(s1==null||n1<=0||s2==null||n2<=0){
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int n2_old = n2;
        int cycle_start_p1 = -1;
        int n1_num = 0;
        int n2_num = 0;
        int old_n1 = n1;
        int old_n2 = n2;
        while(n1 > 0){
            char c2 = s2.charAt(p2);
            int start = p1;
            while(s1.charAt(p1) != c2){
                p1 ++;
                if(p1 == s1.length()){
                    n1--;
                    n1_num ++;
                    if(n1 == 0){
                       return count;
                    }
                    p1 = p1%s1.length();
                }

                if(p1 == start){//找了一圈都没有找到，则证明c2不存在于s1中
                    return 0;
                }
            }
            if(n2==old_n2&&p2==0&&p1 == cycle_start_p1){//开始循环了。 如果满足了这个条件，那么就证明存在周期
                n1_num = n1_num ;
                n2_num = n2_num ;
                count = (old_n1/n1_num)*(n2_num/old_n2);
                n1 = old_n1%n1_num;
                n2 = old_n2;
                p1 = cycle_start_p1;
                p2 = 0;
            }

            if(cycle_start_p1 == -1){
                cycle_start_p1 = p1;
            }

            p2++;
            if(p2 == s2.length()){
                n2 --;
                n2_num ++;
                if(n2 == 0){
                    count++;
                    n2 = n2_old;
                }
                p2 = p2%s2.length();
            }

            p1++;
            if (p1 == s1.length()) {
                n1--;
                n1_num ++;
                if (n1 == 0) {
                    return count;
                }
                p1 = p1 % s1.length();
            }
        }
        return count;
    }




    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s2_of_m_s1 = s2_Consist_Of_N_S2_optimal(s1, s2);
        if(s2_of_m_s1 <= 0){
            return 0;
        }
        int S2_of_n_s1 = s2_of_m_s1 * n2;
        int M = n1/S2_of_n_s1;
        return M;
    }



    //在遇到有重复字符的时候，下面的方法失效。
    //判断s2(小写)需要由几个s1(小写)来组成。
    //进行优化
    public static int s2_Consist_Of_N_S2_optimal(String s1, String s2) {
        int[] char_index_s1 = new int[256];
        for (int i = 0; i < 256; i++) {
            char_index_s1[i] = -1;
        }
        for (int i = 0; i < s1.length(); i++) {
            char_index_s1[s1.charAt(i)] = i;
        }
        int p1 = 0;
        int count = 1;
        for (int p2 = 0; p2 < s2.length(); p2++) {
            char c = s2.charAt(p2);
            int p1_new = char_index_s1[c];
            if(p1_new == -1){//s2中的字符c，不存在与s1字符串中
                return 0;
            }
            if(p1_new < p1) {//注意要增加一个s1来组成s2
                count++;
            }
            p1 = p1_new + 1;
        }

        return count;
    }


    //判断s2(小写)需要由几个s1(小写)来组成
    public static int s2_Consist_Of_N_S2(String s1, String s2) {

        int p1 = 0;
        int p2 = 0;
        int count = 1;
        while(p2 < s2.length()){
            char c2 = s2.charAt(p2);
            int start = p1;
            while(p1 < s1.length()){
                char c1 = s1.charAt(p1);
                if(c2 == c1){
                    break;
                }
                p1++;
            }

            if(p1 < s1.length() && s2.charAt(p2) == s1.charAt(p1)){
                p1++;
                p2++;
            }else {
                if(start == 0 && p1==s1.length()){//s2.charAt(p2)字符没有出现在s1中
                    return 0;
                }else {
                    if(p1 == s1.length()){
                        p1 = 0;
                        count ++;
                    }
                }

            }

        }
        return count;
    }


}
















