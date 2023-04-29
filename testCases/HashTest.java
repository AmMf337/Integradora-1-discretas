

import baseTools.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTest {
    HashTablePrototype<String,Integer>table=new HashTablePrototype<>();
    Node<String, Integer> last = new Node<>(null, null);
    @Test
    public void testPutAndGet() {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        
        table.add(1, "one");
        table.add(2, "two");
        table.add(3, "three");
        
        assertEquals("one", table.getValue(1));
        assertEquals("two", table.getValue(2));
        assertEquals("three", table.getValue(3));
    }
    public void testRemove() {
        table.add("one", 1);
        table.add("two", 2);
        table.add("three", 3);
        
        assertEquals(2, (int)table.remove("two"));
        assertNull(table.getValue("two"));
        assertEquals(3, (int)table.remove("three"));
        assertNull(table.getValue("three"));
    }
}
