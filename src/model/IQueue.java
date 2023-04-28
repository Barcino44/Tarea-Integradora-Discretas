package model;
import Exception.QueueException;
public interface IQueue<T> {
    public boolean isEmpty();
    public void enqueue(T value);
    public T front() throws QueueException;
    public T dequeue() throws QueueException;
}
