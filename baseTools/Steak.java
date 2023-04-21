public class Steak<K, V> {
    private Node<K, V>[] steak;
    private int top;

    public Steak(int capacity) {
        steak = new Node[capacity];
        int top = -1;
    }

    public String push(K key, V value) {
        String msj = "";
        if (top < steak.length - 1) {
            top++;
            Node<K, V> newObject = new Node<K, V>(key, value);
            steak[top] = newObject;
        } else {
            msj = "the stack is full";
        }
        return msj;
    }

}