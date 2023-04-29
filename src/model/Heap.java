package model;

public class Heap<T> implements IHeap<T>{

    private HeapNode<T> [] heapA;
    private int heapSize = 0;

    public Heap(){
        heapA = (HeapNode<T>[]) new HeapNode[120];
    }

    @Override
    public void maxHeapify(int i) {

        int left = leftChild(i);
        int right = rightChild(i);
        int largest;

        if(left<=heapA.length && heapA[left]!= null && heapA[left].compareTo(heapA[i]) > 0){
            largest = left;
        }else{
            largest = i;
        }
        if(right<=heapA.length && heapA[right] != null && heapA[right].compareTo(heapA[largest])>0){
            largest = right;
        }
        if(largest != i){
            HeapNode <T> user = heapA[i];
            heapA[i] = heapA[largest];
            heapA[largest] = user;
            maxHeapify(largest);
        }
    }
    @Override
    public int parent(int i) {
        i += 1;
        int parent = i/2;
        return parent-1;
    }

    @Override
    public int leftChild(int i) {
        i+=1;
        int leftC= 2*i;
        return leftC-1;
    }

    @Override
    public int rightChild(int i) {
        i+=1;
        int rightC = 2*i+1;
        return rightC-1;
    }
    @Override
    public void insertPassenger(T passenger,int key) throws Exception{
        HeapNode<T> node = new HeapNode<>(Integer.MIN_VALUE, passenger);
        if(heapSize != heapA.length){
            heapA [heapSize] = node;
            increaseKey(heapSize, key);
            heapSize = heapSize+1;
        }else{
            throw new Exception("The queue is full");
        }
    }

    @Override
    public void increaseKey(int i, int key) {
        if(key<heapA[i].getKey()){
            System.out.println("Error new key is smaller");
        }else{
            heapA[i].setKey(key);

            while(i>0 && heapA[parent(i)].getKey()<heapA[i].getKey()){
                HeapNode<T> node = heapA[parent(i)];
                heapA[parent(i)] = heapA[i];
                heapA[i] = node;
                i = parent(i);
            }
        }
    }
    @Override
    public T getRoot() throws Exception{
        if(heapA[0] == null){
            throw new Exception("The queue is empty");
        }else
            return heapA[0].getValue();
    }
    @Override
    public T extract() throws Exception {
        if (heapA[0] == null) {
            throw new Exception("You cannot extract, queue empty");
        } else {
            HeapNode<T> node = heapA[0];
            heapA[0] = heapA[heapSize - 1];
            heapA[heapSize - 1] = null;
            heapSize = heapSize - 1;
            maxHeapify(0);
            return node.getValue();
        }
    }
    @Override
    public int getHeapsize(){
        return heapSize;
    }
}
