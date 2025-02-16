package java_assesment_day4_collections;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {  // Generic type T
 private LinkedList<T> queue;

 public MyQueue() {
     queue = new LinkedList<>();
 }

 public void enqueue(T item) {
     queue.addLast(item); // Add to the tail (end)
 }

 public T dequeue() {
     if (isEmpty()) {
         throw new NoSuchElementException("Queue is empty");
     }
     return queue.removeFirst(); // Remove from the head (front)
 }

 public T peek() {
     if (isEmpty()) {
         return null; 
     }
     return queue.getFirst(); // View the front element without removing
 }

 public boolean isEmpty() {
     return queue.isEmpty();
 }

 public int size() {
     return queue.size();
 }

 @Override
 public String toString() {
     return queue.toString(); // Simple string representation
 }


 public static void main(String[] args) {
     // Example usage with integers:
     MyQueue<Integer> intQueue = new MyQueue<>();
     intQueue.enqueue(10);
     intQueue.enqueue(20);
     intQueue.enqueue(30);

     System.out.println("Integer Queue: " + intQueue);
     System.out.println("Dequeued: " + intQueue.dequeue());
     System.out.println("Integer Queue: " + intQueue);


     // Example usage with strings:
     MyQueue<String> stringQueue = new MyQueue<>();
     stringQueue.enqueue("Hello");
     stringQueue.enqueue("World");

     System.out.println("\nString Queue: " + stringQueue);
     System.out.println("Peek: " + stringQueue.peek());
     System.out.println("Dequeued: " + stringQueue.dequeue());
     System.out.println("String Queue: " + stringQueue);

     //Example with objects
     MyQueue<Employee> empQueue = new MyQueue<>();
     empQueue.enqueue(new Employee(1,"A","B"));
     empQueue.enqueue(new Employee(2,"C","D"));

     System.out.println("\nEmployee Queue: " + empQueue);
     System.out.println("Dequeued: " + empQueue.dequeue());
     System.out.println("Employee Queue: " + empQueue);

 }
}
