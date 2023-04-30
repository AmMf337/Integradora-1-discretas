package testCases;

import baseTools.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTablePrototypeTest {

    @Test
    public void testAdd() {
        HashTablePrototype<String, Integer> hashTable = new HashTablePrototype<>();
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        Assertions.assertEquals(1, hashTable.getValue("a"));
        Assertions.assertEquals(2, hashTable.getValue("b"));
        Assertions.assertEquals(3, hashTable.getValue("c"));
    }

    @Test
    public void testGetValue() {
        HashTablePrototype<String, Integer> hashTable = new HashTablePrototype<>();
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        Assertions.assertEquals(1, hashTable.getValue("a"));
        Assertions.assertEquals(2, hashTable.getValue("b"));
        Assertions.assertEquals(3, hashTable.getValue("c"));
        Assertions.assertNull(hashTable.getValue("d"));
    }

    @Test
    public void testRemove() {
        HashTablePrototype<String, Integer> hashTable = new HashTablePrototype<>();
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.remove("b");
        Assertions.assertNull(hashTable.getValue("b"));
        hashTable.remove("c");
        Assertions.assertNull(hashTable.getValue("c"));
    }

}