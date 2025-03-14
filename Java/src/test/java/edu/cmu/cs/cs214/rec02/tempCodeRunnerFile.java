 public void testEnsureCapacity() {
      IntQueue queue = new ArrayIntQueue();
      for (int i = 0; i < 15; i++) {
         queue.enqueue(i);
      }
      assertEquals(15, queue.size()); // Queue should have 15 elements after expansion
   }