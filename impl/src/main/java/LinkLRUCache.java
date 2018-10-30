import java.util.ArrayList;

/**
 * 表示LRU缓存算法链表实现
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的，当有一个新的数据被访问时，我们从链表头开始顺序遍历链表
 * 1.如果数据已存在链表中，找到数据对应的结点，并将其从原来的位置删除，再插入到链表头部
 * 2.如果此数据没有在链表中，如果链表未满，直将其直接插入链表头部，如果已满，则链表尾结点删除，将新的数据结点插入链表头部
 */
public class LinkLRUCache {

    private Node header;
    private int count;
    private int capacity;

    public LinkLRUCache(int capacity){
        this.capacity = capacity;
        this.count = 0;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getCount(){
        return this.count;
    }

    public Object getData(){
        return  null;
    }

    public void setData(){

    }

    public static void main(String[] args) {

    }
}

class Node {
    private Object data;
    private Node next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
