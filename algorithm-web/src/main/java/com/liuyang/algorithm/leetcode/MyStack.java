package com.liuyang.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/31 上午7:33
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.top());



    }

    /** Initialize your data structure here. */
    public Queue<Integer> queue1 = null; //用于加入
    public Queue<Integer> queue2 = null;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty()) return -1;
        int size = queue1.size();

        for (int i = 0; i < size -1 ; i++) {
            queue2.offer(queue1.poll());
        }
        int num = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return num;
    }

    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty()) return -1;
        int size = queue1.size();
        int num = 0;

        for (int i = 0; i < size ; i++) {
            if (i == size - 1) {
                num = queue1.element();
            }
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&& queue2.isEmpty();
    }
}
