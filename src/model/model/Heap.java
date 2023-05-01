package model;

public class Heap<V, P extends Comparable<P>> implements IPriorityQueue<V, P> {
    private NodeQueue<V, P>[] heap;
    private int size;
    private int capacity;
    
    /**
     * Constructor for the Heap class.
     * @param heap An array of type NodeQueue<V, P> representing the heap.
     */
    public Heap(NodeQueue<V, P>[] heap) {
        this.heap = heap;
        this.size = heap.length;
        this.capacity = heap.length - 1;
    }
    
    /**
     * Recursive method to maintain the max heap property of a node at a given index.
     * @param index An integer representing the index of the node to be maintained.
     */
    public void maxHeapify(int index) {
        int largest = index;
        int left = left(index);
        int right = right(index);
        if (left <= heap.length && heap[left(index)].compareTo(heap[index]) > 0) {
            largest = left;
        }
        if (right <= heap.length && heap[right(index)].compareTo(heap[largest]) > 0) {
            largest = right;
        }
        if (heap[largest] != heap[index]) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }
    
    /**
     * Recursive method to maintain the min heap property of a node at a given index.
     * @param index An integer representing the index of the node to be maintained.
     */
    public void minHeapify(int index) {
        int smallest = index;
        int left = left(index);
        int right = right(index);
        if (left <= heap.length && heap[left(index)].compareTo(heap[index]) < 0) {
            smallest = left;
        }
        if (right <= heap.length && heap[right(index)].compareTo(heap[smallest]) < 0) {
            smallest = right;
        }
        if (heap[smallest] != heap[index]) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    /**
     * Method to calculate the parent index of a given node.
     * @param index An integer representing the index of the node whose parent is to be found.
     * @return An integer representing the index of the parent of the given node.
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Method to calculate the left child index of a given node.
     * @param index An integer representing the index of the node whose left child is to be found.
     * @return An integer representing the index of the left child of the given node.
     */
    private int left(int index) {
        return (index * 2) + 1;
    }

    /**
     * Method to calculate the right child index of a given node.
     * @param index An integer representing the index of the node whose right child is to be found.
     * @return An integer representing the index of the right child of the given node.
     */
    private int right(int index) {
        return (index * 2) + 2;
    }

    /**
     * Method to maintain the max heap property of the entire heap.
     */
    public void maxHeapify() {
        maxHeapify(1);
    }

    /**
     * Method to maintain the min heap property of the entire heap.
     */
    public void minHeapify() {
        minHeapify(1);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;

    }
    /**heapSortMinToMax
     * organize the nodes from min to max
     * @param void -
     * @return void
     * 
     */
    @Override
    public void heapSortMinToMax() {
        for (int i = size - 1; i >= 1; i--) {
            swap(0, i);
            size--;
            maxHeapify(0);
        }
    }

    /**heapSortMinToMax
     * organize the nodes from max to min
     * @param void -
     * @return void
     * 
     */
    @Override
    public void heapSortMaxToMin() {
        for (int i = size - 1; i >= 1; i--) {
            swap(0, i);
            size--;
            minHeapify(0);
        }
    }

    public void buildMaxHeap() {
        for (int i = Math.floorDiv(heap.length, 2); i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void buildMinHeap() {
        for (int i = Math.floorDiv(heap.length, 2); i >= 0; i--) {
            minHeapify(i);
        }
    }

    @Override
    public NodeQueue<V, P> heapExtractMax() throws Exception {
        if (heap.length < 1) {
            throw new Exception("Heap underflow");
        }
        NodeQueue<V, P> max = heap[1];
        heap[1] = heap[size];
        size--;
        maxHeapify();
        return max;
    }

    @Override
    public NodeQueue<V, P> heapExtractMin() throws Exception {
        if (heap.length < 1) {
            throw new Exception("Heap underflow");
        }
        NodeQueue<V, P> min = heap[size];
        size--;
        minHeapify();
        return min;
    }

    @Override
    public NodeQueue<V, P> heapMaximum() {
        return heap[1];
    }

    private void swap(int index1, int index2) {
        NodeQueue<V, P> temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public void insert(NodeQueue<V, P> node) {

    }

    @Override
    public NodeQueue<V, P> heapMinimum() {
        return heap[size];
    }

    @Override
    public void increaseKey(int index, P newKey) throws Exception {
        if (newKey.compareTo(heap[index].getPriority()) < 0) {
            throw new Exception("new key is smaller that current key");
        }
        heap[index].setPriority(newKey);
        while (index > 1 && heap[parent(index)].compareTo(heap[index]) < 0) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    @Override
    public void decreaseKey(int index, P newKey) throws Exception {
        if (newKey.compareTo(heap[index].getPriority()) > 0) {
            throw new Exception("new key is bigger that current key");
        }
        heap[index].setPriority(newKey);
        while (index > 1 && heap[parent(index)].compareTo(heap[index]) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    @Override
    public void maxHeapInsert(V value, P priority) throws Exception {
        if (capacity == size) {
            throw new Exception("Queue is full");
        }
        size += 1;
        heap[size] = new NodeQueue<V, P>(value, priority);
        increaseKey(size, priority);
    }

    public NodeQueue<V, P>[] getHeap() {
        return heap;
    }

}