
import model.*;
import model.Node;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    Stack<String, Integer> stack = new Stack<>(4);
    Node<String, Integer> last = new Node<>(null, null);

    @Test
    public void testPush() {
        // Add one element
        String result1 = stack.push("key1", 1);
        assertEquals("the object have been added", result1);

        // Add another element
        String result2 = stack.push("key2", 2);
        assertEquals("the object have been added", result2);

        // Add a third element (the stack should be full now)
        String result3 = stack.push("key3", 3);
        assertEquals("the object have been added", result3);

        // Try to add a fourth element (should return "the stack is full")
        String result4 = stack.push("key4", 4);
        assertEquals("the stack is full", result4);
    }

    @Test
    public void testPop() {
        String result1 = stack.push("key1", 1);
        String result2 = stack.push("key2", 2);
        String result3 = stack.push("key3", 3);

        Node<String, Integer> pop1 = new Node<>("key3", 3);
        Node<String, Integer> pop2 = new Node<>("key2", 2);
        Node<String, Integer> pop3 = new Node<>("key1", 1);
        Node<String, Integer> pop4 = null;
        // remove one element
        last = stack.pop();
        assertEquals(pop1.getKey(), last.getKey());
        // remove another element
        last = stack.pop();
        assertEquals(pop2.getKey(), last.getKey());
        // remove another element(is empty now)
        last = stack.pop();
        assertEquals(pop3.getKey(), last.getKey());
        // remove a element but its empty so return a null object
        last = stack.pop();
        assertEquals(pop4, last);
    }
}