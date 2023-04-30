public class Heap<V,P extends Comparable<P>> implements IPriorityQueue<V,P>{
    private NodeQueue<V,P> [] heap;
    private  int size;
    private int capacity;
    public Heap(NodeQueue<V,P>[] heap) {
        this.heap = heap;
        this.size = heap.length;
        this.capacity = heap.length-1;
    }
    public void maxHeapify(int index){
        int largest = index;
        int left = left(index);
        int right = right(index);
        if(left <= heap.length && heap[left(index)].compareTo(heap[index]) > 0){
            largest =  left;
        }
        if(right <= heap.length && heap[right(index)].compareTo(heap[largest]) > 0){
            largest =  right;
        }
        if(heap[largest] != heap[index]){
            swap(index, largest);
            maxHeapify(largest);
        }
    }
    public void minHeapify(int index){
        int smallest = index;
        int left = left(index);
        int right = right(index);
        if(left <= heap.length && heap[left(index)].compareTo(heap[index]) < 0){
            smallest =  left;
        }
        if(right <= heap.length && heap[right(index)].compareTo(heap[smallest]) < 0){
            smallest =  right;
        }
        if(heap[smallest] != heap[index]){
            swap(index, smallest);
            minHeapify(smallest);
        }
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
    public void maxHeapify(){
        maxHeapify(1);
    }
    public void minHeapify(){
        minHeapify(1);
    }
}