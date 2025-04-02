package com.wjb.DataStructure.node;

/**
 * 双向链表-节点类
 */
public class DoublyLinkedListNode<T> {
    T data; // 节点值
    DoublyLinkedListNode<T> next; // 指向下一个节点的指针（引用）
    DoublyLinkedListNode<T> prev; // 指向上一个节点的指针（引用）
    public DoublyLinkedListNode(T data) {
        this.data = data;
    }
}
