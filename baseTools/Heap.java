import java.util.ArrayList;

public class Heap<K,T extends Comparable<T>>{
    private ArrayList<T> heap;
    private  int size;
    private int capacity;
    public Heap(int capacity) {
        this.heap = new ArrayList<T>(capacity);
        this.size = 0;
        this.capacity = capacity;
    }
    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }
    public maxHeaify(){
        maxHeapify(1);
    }
    public void maxHeapify(int index){
        int left = left(index);
        int right = right(index);
        if(left <= heap.size() && heap.get(left(index)).compareTo(heap.get(index)) > 0){
            int larguest =  left;
        }else{
            int larguest =  right;
        }
        if(right <= heap.size() && heap.get(right(index)).compareTo(heap.get(largest)) > 0){
            int larguest =  right;
        }
        if(heap.get(largest) != heap.get(index)){
            swap(heap.get(index), heap.get(largest));
            maxHeapify(largest);
        }
    }
    
    public insert(T node){
        if(isFull()){
            throw new IllegalStateException("Heap is full");
        }
        size++;

    }
    public insert(T node){
        if(isFull()){
            throw new IllegalStateException("Heap is full");
        }
        size++;

    }
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        int removedValue = heap.get(0);
        heap.set(1,heap.get(size));
        size--;
        bubbleDown();
        return removedValue;
    }
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2, temp);
    }
    


    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }
    

} 