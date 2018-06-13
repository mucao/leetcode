package com.mucao;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("斐波那契数列的第10项为："+fibonacci_recursive(100));
    }

    public static long fibonacci_recursive(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;

        return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
    }

}
