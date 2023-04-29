package model;
import Exception.*;

public class HashTable<K extends Comparable<K>, T> implements IHashTable<K,T> {
    public static final int arr_size = 127;
    private HNode<K, T>[] hnodes;
    private Plane plane;
    static int counterPassengers=0;
    public HashTable() {
        hnodes = (HNode<K, T>[]) new HNode[arr_size];
    }

    public int hash(K key) {
        String hashkey;
        hashkey = key.toString();
        int result = 0;
        for (int x = 0; x < hashkey.length(); x++){
            result += hashkey.codePointAt(x)*128*Math.exp(x);
        }
        result=result%arr_size;
        return result;
    }
    @Override
    public void insert(K key, T value,int airPlaneCapacity) throws Exception {
        int position = hash(key);
        HNode<K, T> node = new HNode<>(key, value);
        if (hnodes[position] != null) {
            HNode<K, T> current = hnodes[position];
            boolean flag = true;
            while (flag) {
                if (current.getNext() == null) {
                    current.setNext(node);
                    flag = false;
                } else {
                    current = current.getNext();
                }
            }
        } else {
            hnodes[position] = node;
        }
    }

    @Override
    public T search(K key) throws PassengerNotFoundException {
        int position = hash(key);
        T object = null;
        HNode<K, T> node = hnodes[position];
        boolean flag = true;
        if (hnodes[position] != null) {
            while (flag) {
                if (node.getKey().equals(key)) {
                    object = node.getValue();
                    flag = false;
                } else {
                    if (node.getNext() == null) {
                        flag = false;
                    }
                    node = node.getNext();
                }
            }
        }
        return object;
    }
}

