package com.wjb;

/* 基于链表实现的栈 */
public class LinkedListStack {

    private Node stackHead; // 头节点
    private int size; // 栈的长度

    public LinkedListStack() {
        stackHead = null;
    }

    /**
     * 获取栈的长度
     * @return 返回栈的长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 入栈
     * @param value 节点值
     */
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = stackHead;
        stackHead = newNode;
        size++;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 访问栈顶
     * @return 栈顶值
     */
    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stackHead.val;
    }

    /**
     * 出栈
     * @return 返回出栈的节点值
     */
    public int pop(){
        int peek = peek();
        stackHead = stackHead.next;
        size--;
        return peek;
    }


    /**
     * 链表节点类
     */
    class Node {
        int val;
        Node next;
        public Node(int value) {
            this.val = value;
        }
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        int peek = stack.peek();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());

    }

}
