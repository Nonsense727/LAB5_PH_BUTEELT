package edu.cmu.cs.cs214.rec02;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayIntQueueTest {
   @Test
   public void testDequeueOnEmptyQueue() {
      IntQueue queue = new ArrayIntQueue();
      assertNull(queue.dequeue()); // Should return null when queue is empty
   }

   @Test
   public void testEnqueueDequeueSingleElement() {
      IntQueue queue = new ArrayIntQueue();
      queue.enqueue(10);
      assertEquals(Integer.valueOf(10), queue.dequeue());
      assertTrue(queue.isEmpty());
   }

   @Test
   public void testEnsureCapacity() {
      IntQueue queue = new ArrayIntQueue();
      for (int i = 0; i < 15; i++) {
         queue.enqueue(i);
      }
      assertEquals(15, queue.size()); // Queue should have 15 elements after expansion
   }

   @Test
   public void testPeekOnEmptyQueue() {
      IntQueue queue = new ArrayIntQueue();
      assertNull(queue.peek()); // Should return null when queue is empty
   }

   @Test
   public void testSizeAfterMultipleEnqueue() {
      IntQueue queue = new ArrayIntQueue();
      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      assertEquals(3, queue.size()); // Size should be 3 after adding three elements
   }
}

