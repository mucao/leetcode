package com.mucao.Question9;

public class InterviewCoding9 {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        queue.appendTail(5);
        Integer e = null;
        while((e=queue.deleteHead())!=null){
            System.out.println(e);
        }

    }
}
