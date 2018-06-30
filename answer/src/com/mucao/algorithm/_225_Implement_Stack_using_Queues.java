package com.mucao.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 */
public class _225_Implement_Stack_using_Queues {



}

class MyStack {
    Queue<Integer> queue1 ;
    Queue<Integer> queue2 ;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size()>1){
            int element = queue1.poll();//从队列1出队
            queue2.offer(element);
        }
        int result_ele = queue1.poll();
        Queue<Integer>  temp_queue = queue1;
        queue1 = queue2;
        queue2 = temp_queue;

        return result_ele;

    }

    /** Get the top element. */
    public int top() {
        while (queue1.size()>1){
            int element = queue1.poll();//从队列1出队
            queue2.offer(element);
        }
        int result_ele = queue1.peek();
        queue1.poll();
        queue2.offer(result_ele);
        //交换queue1和queue2
        Queue<Integer>  temp_queue = queue1;
        queue1 = queue2;
        queue2 = temp_queue;

        return result_ele;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
