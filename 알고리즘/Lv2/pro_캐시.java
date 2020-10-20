 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-20
  * URL   : https://programmers.co.kr/learn/courses/30/lessons/17680
  *
  */

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
       LRUCache cache = new LRUCache(cacheSize);
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        for (String city : cities) {
            String str = city.toLowerCase();
            if (cache.get(str) == -1) {
                answer += 5;
                cache.put(str, 1);
            } else {
                answer += 1;
            }
        }
        return answer;
    }
}

class LRUCache {
    private Map<String, node> nodeMap;
    private int capacity;
    private node head;
    private node tail;

    private class node {
        private String key;
        private int value;
        private node prev;
        private node next;

        public node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<String, node>();
        this.capacity = capacity;
        head = new node("", 0);
        tail = new node("", 0);
        head.next = tail;
        tail.prev = head;

    }

    //시간 복잡도 O(1)
    private void remove(node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        nodeMap.remove(node.key);
    }

    //시간 복잡도 O(1)
    private void insertToHead(node node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;

        nodeMap.put(node.key, node);
    }

    //시간 복잡도 O(1)
    public int get(String key) {
        if (!nodeMap.containsKey(key))
            return -1;
        node getNode = nodeMap.get(key);
        remove(getNode);
        insertToHead(getNode);
        return getNode.value;

    }

    //시간 복잡도 O(1)
    public void put(String key, int value) {
        node newNode = new node(key, value);
        if (nodeMap.containsKey(key)) {
            node oldNode = nodeMap.get(key);
            remove(oldNode);
        } else {
            if (nodeMap.size() >= this.capacity) {
                node delNode = tail.prev;
                remove(delNode);
            }
        }
        insertToHead(newNode);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "nodeMap=" + nodeMap +
                ", capacity=" + capacity +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}