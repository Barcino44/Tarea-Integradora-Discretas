package model;

public class HashTable<K,T> implements IHashTable<K,T> {
    public static final int arr_size = 127;
    private HNode<K, T>[] hnodes;

    public HashTable() {
        hnodes = (HNode<K, T>[]) new HNode[arr_size];
    }

    public int hash(K key) {
        int hashkey;
        hashkey = key.hashCode() % arr_size;
        return hashkey;
    }

    @Override
    public void insert(K key, T value) {
        int position = hash(key);
        HNode<K, T> node = new HNode<>(key, value);
        if (hnodes[position] != null) {
            HNode<K, T> node2 = hnodes[position];
            node.setNext(node2);
            hnodes[position] = node;
        } else {
            hnodes[position] = node;
        }
    }

    @Override
    public T search(K key) {
        int position = hash(key);
        System.out.println(position);
        T object = null;
        HNode<K, T> node = hnodes[position];
        boolean flag = true;
        if (hnodes[position] != null) {
            while (flag) {
                if (node.getKey().equals(key)){
                    object = node.getValue();
                    flag = false;
                } else {
                    node = node.getNext();
                }
            }
        }
        return object;
    }


}

