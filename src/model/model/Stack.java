package model;

public class Stack<K, V> {
    private Node<K, V>[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new Node[capacity];
        int top = -1;
    }

    public String push(K key, V value) {
        String msj = "";
        if (top < stack.length - 1) {
            top++;
            Node<K, V> newObject = new Node<K, V>(key, value);
            stack[top] = newObject;
            msj = "the object have been added";
        } else {
            msj = "the stack is full";
        }
        return msj;
    }

    public Node<K, V> pop() {
        Node<K, V> last = new Node<K, V>(null, null);
        if (stack[top] != null) {
            last = stack[top];
            stack[top] = null;
            top--;
        } else {
            last = null;

        }
        return last;
    }

}