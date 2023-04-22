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
            msj = "the object have been added";
        } else {
            msj = "the stack is full";
        }
        return msj;
    }

    public Node<K, V> pop() {
        Node<K, V> last = new Node<K, V>(null, null);
        if (steak[steak.length - 1] != null) {
            last = steak[steak.length - 1];
            steak[steak.length - 1] = null;
        } else {
            last = null;

        }
        return last;
    }

}