package model;

public interface IPriorityQueue<K,V,P extends Comparable<P>> {
    
    public void insert(NodeQueue<K,V,P> node);

    public NodeQueue<K,V,P> heapExtractMax() throws Exception;

    public NodeQueue<K,V,P> heapExtractMin() throws Exception;

    public NodeQueue<K,V,P> heapMaximum();

    public NodeQueue<K,V,P> heapMinimum();

    public void increaseKey(K key,K newKey);

    public void decreaseKey(K key,K newKey);

    public void maxHeapInsert(K key);
}

