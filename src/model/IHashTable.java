package model;

public interface IHashTable<K,T> {
    public void insert(K key, T value) throws Exception;
    public T search(K key);
}
