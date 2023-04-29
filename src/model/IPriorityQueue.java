package model;

public interface IPriorityQueue<T> {

    void insert(T obj, int key) throws Exception;

    public T extract() throws Exception;

}

