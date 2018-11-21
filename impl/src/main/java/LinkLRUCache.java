import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.ArrayList;

/**
 * 表示LRU缓存算法链表实现
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的，当有一个新的数据被访问时，我们从链表头开始顺序遍历链表
 * 1.如果数据已存在链表中，找到数据对应的结点，并将其从原来的位置删除，再插入到链表头部
 * 2.如果此数据没有在链表中，如果链表未满，直将其直接插入链表头部，如果已满，则链表尾结点删除，将新的数据结点插入链表头部
 */
public class LinkLRUCache {

    private final int capacity;
    private Node header;
    private int count;

    public LinkLRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.header = new Node();
    }

    public static void main(String[] args) {
        LinkLRUCache cache = new LinkLRUCache(10);
        for (int i = 0; i < 11; i++) {
            cache.set("name" + i, "jack" + i);
        }

        for (int i = 0; i < cache.getCount(); i++){
            System.out.println(cache.get("name" + i));
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.count;
    }

    public Object get(Object key) {
        KeyValePair pair = this.findKeyValuePair(key);
        return pair == null ? null : pair.getValue();
    }

    public void set(Object key, Object value) {
        KeyValePair pair = this.findKeyValuePair(key);
        if (pair != null) {
            pair.setValue(value);
            return;
        }
        if (this.isFull()) {
            Node current = this.header.getNext();
            Node prev = this.header;
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            this.count--;
        }

        Node newNode = new Node();
        newNode.setKeyValePair(new KeyValePair(key, value));
        newNode.setNext(this.header.getNext());
        this.header.setNext(newNode);
        this.count++;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    private KeyValePair findKeyValuePair(Object key) {
        Node current = header.getNext();
        Node prev = header;
        while (current != null) {
            KeyValePair pair = current.getKeyValePair();
            if (pair.getKey().equals(key)) {
                prev.setNext(current.getNext());
                current.setNext(this.header.getNext());
                this.header.setNext(current);

                return pair;
            }
            prev = current;
            current = current.getNext();
        }

        return null;
    }
}

class Node {
    private KeyValePair keyValePair;
    private Node next;

    public KeyValePair getKeyValePair() {
        return keyValePair;
    }

    public void setKeyValePair(KeyValePair keyValePair) {
        this.keyValePair = keyValePair;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class KeyValePair {
    private Object key;
    private Object value;

    public KeyValePair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
