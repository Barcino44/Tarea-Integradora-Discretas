package model;

public class PriorityQueue<T> implements IPriorityQueue<T> {

    private IHeap<T> heap;

    public PriorityQueue() {
        heap = new Heap<T>();
    }

    @Override
    public void insert(T obj, double key) throws Exception {
        heap.insertPassenger(obj, key);
    }
    @Override
    public T extract() throws Exception {
        return heap.extract();
    }
    public int getHeapSize(){
        return heap.getHeapsize();
    }
    public T getRoot() throws Exception {
        return heap.getRoot();
    }
}
