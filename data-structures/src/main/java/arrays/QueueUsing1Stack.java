package arrays;

import java.util.Stack;

public class QueueUsing1Stack {

    static class Queue {
        Stack<Integer> stack;
    }

    private static void enQueue(int element, Queue queue) {
        push(element, queue.stack);
    }

    private static void push(int element, Stack<Integer> stack) {
        stack.push(element);
    }

    private static int deQueue(Queue queue) {
        if (queue.stack.isEmpty()) {
            System.out.println("No elements to dequeue");
            return -1;
        } else if (queue.stack.size() == 1) {
            return pop(queue.stack);
        } else {
            int val = pop(queue.stack);
            int res = deQueue(queue);
            push(val, queue.stack);
            return res;
        }
    }

    private static int pop(Stack<Integer> stack) {
        return stack.pop();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.stack = new Stack<>();
        enQueue(1, queue);
        enQueue(2, queue);
        enQueue(3, queue);
        enQueue(4, queue);
        System.out.println(deQueue(queue));
        System.out.println(deQueue(queue));
        enQueue(5, queue);
        enQueue(6, queue);
        System.out.println(deQueue(queue));
    }
}
