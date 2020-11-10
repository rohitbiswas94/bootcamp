package arrays;

import java.util.Stack;

public class MaximumOfAllSubarraysOfSizeKUsingStack {

    private static int firstElementOfStack(Stack<Integer> stack, String operation) {
        Stack<Integer> tempStack = new Stack<>();
        int item;
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        item = tempStack.peek();
        if (operation.equalsIgnoreCase("pop")) {
            tempStack.pop();
        }
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.pop());
        }
        return item;
    }

    private static void findMaximumOfSubArrays(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = k; i < arr.length; i++) {
            int maxElementCurrentWindow = firstElementOfStack(stack, "peek");
            System.out.println(arr[maxElementCurrentWindow]);
            while (!stack.isEmpty() && firstElementOfStack(stack, "peek") <= i - k) {
                firstElementOfStack(stack, "pop");
            }
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        int maxElementLastWindow = firstElementOfStack(stack, "peek");
        System.out.println(arr[maxElementLastWindow]);
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int k = 3;
        findMaximumOfSubArrays(arr, k);
    }
}
