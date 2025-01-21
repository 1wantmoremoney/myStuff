package com.daytime;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2024/08/19/10:03
 */
public class LRUCache {
    private int capacity;
    private int size;
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size= 0;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        //将node移除原来的位置 再移动到首位
        removeNode(node);
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
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
        }else {
            node.value = value;
            removeNode(node);
            move2head(node);
        }
    }

    private void move2head(Node node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int get1 = lruCache.get(1);
        Node pre = lruCache.tail.pre;
        lruCache.put(3, 3);
        int get2 = lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
        System.out.println(get1);
        System.out.println(get2);
    }


}

