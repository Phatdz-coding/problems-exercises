package Leetcode;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.add(x);
    }

    // move to s2 to pop or peek
    private void moveToStack2(){
        s2.clear();

        while (!s1.empty()) {
            s2.add(s1.pop());
        }
    }

    private void moveToStack1(){
        s1.clear();

        while (!s2.empty()) {
            s1.add(s2.pop());
        }
    }

    public int pop() {
        moveToStack2();
        int val = s2.pop();
        moveToStack1();
        return val;
    }

    public int peek() {
        moveToStack2();
        int val = s2.peek();
        moveToStack1();
        return val;
    }

    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class LC232 {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(2);
    }
}
