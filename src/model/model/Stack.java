package model;

public class Stack<K, V> {
    private Node<K, V>[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new Node[capacity];
        int top = -1;
    }

    /**
     * push: add a node in the stack and this newNode is becomes the top
     * 
     * @param key   -> indentifier node
     * @param value -> content node
     * @return msj -> String: confirmation message
     */
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

    /**
     * pop: extract the top node in the Stack
     * 
     * @return last -> V: corresponding keys value node.
     */
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