package stack;

import java.util.LinkedList;

	class MyStack<T> {
	    private LinkedList<T> list = new LinkedList<>();
	    
	    public void push(T data) {
	        list.addFirst(data);
	    }
	    
	    public T peek() {
	        if (isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return list.getFirst();
	    }

	    public T pop() {
	        if (isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return list.removeFirst();
	    }

	    public boolean isEmpty() {
	        return list.isEmpty();
	    }
	}

	public class StackExample {

	    public static void main(String[] args) {
	        MyStack<Integer> stack = new MyStack<>();
	        stack.push(70);
	        stack.push(30);
	        stack.push(56);

	        System.out.println("Use Case 1 - Stack elements:");
	        printStack(stack); 

	        System.out.println("\nUse Case 2 - Pop elements from the stack:");
	        while (!stack.isEmpty()) {
	            System.out.print(stack.pop() + " -> ");
	        }
	        System.out.println("Empty Stack");
	    }

	    private static <T> void printStack(MyStack<T> stack) {
	        MyStack<T> tempStack = new MyStack<>();
	        while (!stack.isEmpty()) {
	            T element = stack.pop();
	            System.out.print(element + " -> ");
	            tempStack.push(element);
	        }

	        while (!tempStack.isEmpty()) {
	            stack.push(tempStack.pop());
	        }
	        System.out.println("Top");
	    }
	}

