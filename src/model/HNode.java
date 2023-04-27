package model;

public class HNode<K,T> {

    private K key;
    private T value;
    private HNode<K, T> next;
    private HNode<K, T> previous;

    public HNode(K key, T value) {
        this.key = key;
        this.value = value;
        next = null;
        previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public HNode<K, T> getNext() {
        return next;
    }

    public void setNext(HNode<K, T> next) {
        this.next = next;
    }

    public HNode<K, T> getPrevious() {
        return previous;
    }

    public void setPrevious(HNode<K, T> previous) {
        this.previous = previous;
    }

}
