package arrays;

import java.util.Stack;

public class QueueUsing2Stack {

    static class Queue {
        Stack<Integer> stack;
    }

    private static void enQueue(int element, Queue queue) {
        push(element, queue.stack);
    }

    private static void push(int element, Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(element);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    private static void deQueue(Queue queue) {
        pop(queue.stack);
    }

    private static void pop(Stack<Integer> stack) {
        System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.stack = new Stack<>();
        enQueue(1, queue);
        enQueue(2, queue);
        enQueue(3, queue);
        enQueue(4, queue);
        deQueue(queue);
        deQueue(queue);
        enQueue(5, queue);
        enQueue(6, queue);
        deQueue(queue);
    }
}
