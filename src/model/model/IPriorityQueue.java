package model;

public interface IPriorityQueue<V,P extends Comparable<P>> {
    
    public void insert(NodeQueue<V,P> node);

    public NodeQueue<V,P> heapExtractMax() throws Exception;

    public NodeQueue<V,P> heapExtractMin() throws Exception;

    public NodeQueue<V,P> heapMaximum();

    public NodeQueue<V,P> heapMinimum();

    public void increaseKey(int index,P newKey) throws Exception;

    public void decreaseKey(int index,P newKey) throws Exception;

    public void maxHeapInsert(V value,P priority) throws Exception;

    public void heapSortMinToMax();
    
    public void heapSortMaxToMin();
}



