package model;

public class Controller {

    Heap<Passenger,Integer> queue;
    Heap<Passenger,Integer> queueExit;
    public Controller(NodeQueue<Passenger,Integer>[] a){
        queue = new Heap<>(a);
    }
    public String  entryOrder(){
        String msj = "";
        
        queue.heapSortMaxToMin();
        for(int i = 1;i<queue.getHeap().length;i++){
            if(queue.getHeap()[i]!=null){
                msj += queue.getHeap()[i].getValue().getName()+(" priority: ")+queue.getHeap()[i].getValue().getPriority()+"\n";
            }
        }
        return msj.toString();
    }
    public String  exitOrder(){
        String msj = "";
        NodeQueue<Passenger,Integer>[] array = new NodeQueue[queue.getHeap().length];
        for(int i = 1;i<queue.getHeap().length;i++){
            if(queue.getHeap()[i]!=null){
               queue.getHeap()[i].getValue().calculateExitPrioryty();
               array[i] = new NodeQueue<>(queue.getHeap()[i].getValue(),queue.getHeap()[i].getPriority());
            }
        }
        queueExit = new Heap<>(array);
        queueExit.heapSortMaxToMin();
        for(int i = 1;i<queue.getHeap().length;i++){
            if(queue.getHeap()[i]!=null){
                queueExit.heapSortMaxToMin();
                msj += queue.getHeap()[i].getValue().getName()+(" priority: ")+queue.getHeap()[i].getValue().getPriority()+"\n";
            }
        }
        return msj.toString();
    }
    public Heap<Passenger,Integer> getQueue(){
        return queue;
    }
}
