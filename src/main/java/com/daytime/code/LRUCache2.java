package com.daytime.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2025/01/20/17:46
 */
public class LRUCache2 {

   private int capacity;
   private int size;

   private Map<Integer,Node> cache;

    private Node head;
    private Node tail;

    public LRUCache2( int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre= head;
    }


    private class Node{
        private int key;
        private int value;

        private Node pre;
        private Node next;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
        public Node()
        {
        }

    }

    private  int get(int key){
        Node node = cache.get(key);

        if (node == null){
            return -1;
        }
        removeNode(node);
        move2head(node);
        return node.value;
    }

    private void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node saveNode = new Node(key, value);
            move2head(saveNode);
            cache.put(key, saveNode);
            ++size;
            if (size > capacity){
                Node removeNode = tail.pre;
                removeNode(removeNode);
                cache.remove(removeNode.key);
                --size;
            }
        } else {
            node.value = value;
            removeNode(node);
            move2head(node);
        }

    }

    private void move2head(Node node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next= node;
    }

    private static void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }


}
