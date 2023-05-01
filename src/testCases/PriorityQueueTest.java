import model.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

    private Heap<Integer, Integer> heap;

    @Before
    public void setUp() {
        // Crear un heap de prueba
        NodeQueue<Integer, Integer>[] nodes = new NodeQueue[] {
            new NodeQueue<>(3, 3),
            new NodeQueue<>(4, 4),
            new NodeQueue<>(1, 1),
            new NodeQueue<>(2, 2),
            new NodeQueue<>(7, 7),
            new NodeQueue<>(8, 8),
            new NodeQueue<>(5, 5),
            new NodeQueue<>(6, 6)
        };
        
        heap = new Heap<>(nodes);
    }

    @Test
    public void testMaxHeapify() {
        heap.maxHeapify(1);
        NodeQueue<Integer, Integer>[] expected = new NodeQueue[] {
            new NodeQueue<>(4, 4),
            new NodeQueue<>(3, 3),
            new NodeQueue<>(1, 1),
            new NodeQueue<>(2, 2),
            new NodeQueue<>(7, 7),
            new NodeQueue<>(8, 8),
            new NodeQueue<>(5, 5),
            new NodeQueue<>(6, 6)
        };
        assertArrayEquals(expected, heap.getHeap());
    }

    @Test
    public void testMinHeapify() {
        heap.minHeapify(1);
        NodeQueue<Integer, Integer>[] expected = new NodeQueue[] {
            new NodeQueue<>(1, 1),
            new NodeQueue<>(2, 2),
            new NodeQueue<>(3, 3),
            new NodeQueue<>(4, 4),
            new NodeQueue<>(7, 7),
            new NodeQueue<>(8, 8),
            new NodeQueue<>(5, 5),
            new NodeQueue<>(6, 6)
        };
        assertArrayEquals(expected, heap.getHeap());
        
    }
}