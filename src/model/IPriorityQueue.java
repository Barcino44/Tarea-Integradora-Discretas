package model;

public interface IPriorityQueue<T> {

    void insert(T obj, double key) throws Exception;

    public T extract() throws Exception;

}

