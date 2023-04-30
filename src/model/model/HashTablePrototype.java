package model;

public class HashTablePrototype<K, V> {
    private static final int SIZE_TABLE = 10;
    private Node<K, V>[] table;

    public HashTablePrototype() {
        table = new Node[SIZE_TABLE];
    }

    // hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE_TABLE;
    }

    /**
     * add: add a node in to the hash table
     * 
     * @param key   -> K : identifier of the node
     * @param value -> V: content of the node
     * @return msj -> String: confirmation message.
     */
    public String add(K key, V value) {
        String msj = "";

        int index = hash(key);
        Node<K, V> newNode = new Node<K, V>(key, value);
        // if there is no collision
        if (table[index] == null) {
            table[index] = newNode;
            msj = "nuevo nodo agrgado";
        } else {
            // if there is a colison, the node is added at the end
            Node<K, V> current = table[index];
            while (current.getNext() != null) {
                current = current.getNext();

            }
            current.setNext(newNode);
            msj = "nuevo nodo agrgado";
        }
        return msj;
    }

    /**
     * getValue: get the node content by the identifier key of the node
     * 
     * @param key -> K: identifier of the node
     * @return current.getValue -> V: content of the node that match with the key
     */
    public V getValue(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        } else {
            Node<K, V> current = table[index];
            while (current != null) {
                if (current.getKey().equals(key)) {
                    return current.getValue();
                }
                current = current.getNext();

            }
            return null;
        }
    }

    /**
     * remove: removes an element from the table by means of a key as the node
     * identifier
     * 
     * @param key -> K: identifaier of the node
     * @return msj -> String: confirmation message.
     */
    public String remove(K key) {
        String msj = "";
        int index = hash(key);

        if (table[index] == null) {
            msj = "no se encontro valor a eliminar";
        } else {
            if (table[index].getKey().equals(key)) {
                table[index] = table[index].getNext();
            } else {
                Node<K, V> current = table[index];
                while (current.getNext() != null && !current.getKey().equals(key)) {
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    current.setNext(current.getNext().getNext());

                }
            }
        }
        return msj;

    }

}
