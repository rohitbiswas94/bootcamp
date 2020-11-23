package datastructures;

import java.util.Stack;

public class RemoveKDigits {

    private static String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || ch != '0')
                stack.push(ch);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
