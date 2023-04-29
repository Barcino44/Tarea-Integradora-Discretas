package model;

public class HeapNode <T> implements Comparable<HeapNode <T>>  {
    private T value;
    private double key;
    private HeapNode<T> next;

    public HeapNode(double key,T value) {
        this.value = value;
        this.next = null;
        this.key=key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HeapNode<T> getNext() {
        return next;
    }

    public void setNext(HeapNode<T> next) {
        this.next = next;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }
    @Override
    public int compareTo(HeapNode <T>  o) {
        if (key < o.getKey()) {
            return -1;
        } else if (key > o.getKey()) {
            return 1;
        } else {
            return 0;
        }
    }
}
