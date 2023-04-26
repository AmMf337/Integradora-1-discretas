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
    

} 