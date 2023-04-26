public class Queue<T> implements  IQueue<T>{
    private Node<T> first;
    private Node<T> last;
    @Override
    public boolean isEmpty() {
        return first==null;
    }
    @Override
    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if(isEmpty()){
            first=node;
            last=node;
        }
        else{
            last.setNext(node);
            last=node;
        }
    }
    @Override
    public T front() {
        return first.getValue();
    }
    @Override
    public T dequeue() {
        if(!isEmpty()) {
            Node<T> aux = first;
            if (first == last) {
                first=null;
                last=null;
            } else {
                first = first.getNext();
            }
            return aux.getValue();
        }
        else{
            return null;
        }
    }
}
