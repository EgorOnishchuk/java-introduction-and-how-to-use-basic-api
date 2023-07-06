package ru.geekbrains;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListQueue {
    
    static LinkedList linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList();
    }

    public LinkedListQueue(Collection collection) {
        linkedList = new LinkedList(collection);
    }

    public void add(Object element) {
        linkedList.addFirst(element);
    }

    public Object get() {
        return linkedList.getLast();
    }

    public Object remove() {
        return linkedList.removeLast();
    }

}
