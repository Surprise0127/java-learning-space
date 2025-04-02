package com.wjb.DataStructure.node;

/**
 * 单向链表-节点类
 */
public class SinglyLinkedListNode<T> {
    T data; // 节点值
    SinglyLinkedListNode<T> next; // 指向下一个节点的指针（引用）
    public SinglyLinkedListNode(T data) {
        this.data = data;
    }
}
