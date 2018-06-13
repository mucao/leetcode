package com.mucao.Question9;

import java.util.LinkedList;

public class MyQueue <T>{
    private LinkedList<T> stack_tail = new LinkedList<>();
    private LinkedList<T> stack_head = new LinkedList<>();

    public void appendTail(T e){
        stack_tail.push(e);
    }

    public T deleteHead(){
        if(stack_tail.isEmpty()){
            return null;
        }
        while(!stack_tail.isEmpty()){
            T tmp_e = stack_tail.pop();
            stack_head.push(tmp_e);
        }

        T head_e = stack_head.pop();

        while(!stack_head.isEmpty()){
            T tmp_e = stack_head.pop();
            stack_tail.push(tmp_e);
        }
        return head_e;
    }
}
