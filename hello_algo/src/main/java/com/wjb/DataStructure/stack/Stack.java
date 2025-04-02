package com.wjb.DataStructure.stack;

/**
 * 栈
 */
public class Stack<T> {
    // 栈有栈顶和长度
    private Node<T> top;
    private int size;

    public Stack() {}

    // 获取栈长度
    public int getSize(){
        return size;
    }

    // 获取栈顶
    public T peek(){
        if (getSize() == 0){
            throw new IndexOutOfBoundsException();
        }
        return top.data;
    }

    // 入栈
    public void push(T data){
        Node<T> node = new Node<>(data);
        top.next = top;
        top = node;
        size++;
    }

    // 出栈
    public T pop(){
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }
        T data = peek();
        top = top.next;
        size--;
        return data;
    }

    /**
     * 内部类节点类
     * @param <T> 任意类型
     */
    private class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);


        System.out.println("pop "+ integerStack.pop());

        System.out.println("size "+ integerStack.getSize());

        System.out.println("peek "+ integerStack.peek());

    }


}
