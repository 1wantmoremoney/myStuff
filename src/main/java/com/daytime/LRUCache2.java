package com.daytime;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2025/01/20/17:46
 */
public class LRUCache2 {
    private int size;
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    private  class  Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node(){}
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        //node存在先移动到头部
        removeNode(node);
        move2Head(node);
        return node.value;
    }

    private void move2Head(Node node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node nodeNew = new Node(key, value);
            move2Head(nodeNew);
            cache.put(key, nodeNew);
            size++;
            if (size > capacity){
                //超出容量，移除尾部节点
                Node removeNode = tail.pre;
                removeNode(removeNode);
                cache.remove(removeNode.key);
                --size;
            }
        }else {
            node.value = value;
            removeNode(node);
            move2Head(node);
        }


    }

    private void removeNode(Node removeNode) {
        removeNode.pre.next = removeNode.next;
        removeNode.next.pre = removeNode.pre;
    }

}
