package queue;

import java.util.LinkedList;

class MyQueue<T> {
    LinkedList<T> list = new LinkedList<>();

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class QueueExample {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Use Case 1 - Queue elements:");
        printQueue(queue); 

        System.out.println("\nUse Case 2 - Dequeue elements from the queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " -> ");
        }
        System.out.println("Empty Queue");
    }

    private static <T> void printQueue(MyQueue<T> queue) {
        for (T element : queue.list) {
            System.out.print(element + " -> ");
        }
        System.out.println("Rear");
    }
}

