package model;

public interface IHeap<T> {

    public void maxHeapify(int i);

    public int parent(int i);

    public int leftChild(int i);

    public int rightChild(int i);

    public void increaseKey(int i, int key);

    public void insertPassenger(T t, int key) throws Exception;

    public T getRoot() throws Exception;

    public T extract() throws Exception;


    public int getHeapsize();
}
