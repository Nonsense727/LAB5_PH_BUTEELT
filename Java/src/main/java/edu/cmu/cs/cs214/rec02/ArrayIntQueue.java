package edu.cmu.cs.cs214.rec02;

import java.util.Arrays;

public class ArrayIntQueue implements IntQueue {
   private int[] elementData;
   private int head;
   private int size;
   private static final int INITIAL_SIZE = 10;

   public ArrayIntQueue() {
      this.elementData = new int[INITIAL_SIZE];
      this.head = 0;
      this.size = 0;
   }

   public void clear() {
    Arrays.fill(this.elementData, 0);  
    this.size = 0;                     
    this.head = 0;                     
}

   public Integer dequeue() {
      if (this.isEmpty()) {
         return null;
      } else {
         Integer value = this.elementData[this.head];
         this.head = (this.head + 1) % this.elementData.length;
         --this.size;
         return value;
      }
   }

   public boolean enqueue(Integer value) {
      ensureCapacity();
      int tail = (this.head + this.size) % this.elementData.length;
      this.elementData[tail] = value;
      ++this.size;
      return true;
   }

   public boolean isEmpty() {
      return this.size == 0; // Fixed: Changed from `size >= 0` to `size == 0`
   }

   public Integer peek() {
      if (this.isEmpty()) {
         return null; // Fixed: Avoid accessing an empty queue
      }
      return this.elementData[this.head];
   }

   public int size() {
      return this.size;
   }

   private void ensureCapacity() {
      if (this.size == this.elementData.length) {
         int oldCapacity = this.elementData.length;
         int newCapacity = 2 * oldCapacity + 1;
         int[] newData = new int[newCapacity];

         for (int i = 0; i < this.size; i++) {
            newData[i] = this.elementData[(this.head + i) % oldCapacity];
         }

         this.elementData = newData;
         this.head = 0;
      }
   }
}
