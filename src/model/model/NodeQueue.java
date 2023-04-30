package model;

public class NodeQueue<V,P extends Comparable<P>> {
    private V value;
    private P priority;
    public NodeQueue(V value, P priority) {
        this.value = value;
        this.priority = priority;
    }
    
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public P getPriority() {
        return priority;
    }
    public void setPriority(P priority) {
        this.priority = priority;
    }
    public int compareTo(NodeQueue<V,P> node){
        if(this.priority.compareTo(node.getPriority())>0){
            return 1;
        }else if(this.priority.compareTo(node.getPriority())<0){
            return -1;
        }else{
            return 0;
        }
    }
    
}
