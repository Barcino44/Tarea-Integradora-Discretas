public interface IQueue<T> {
    public boolean isEmpty();
    public void enqueue(T value);
    public T front();
    public T dequeue();
}
