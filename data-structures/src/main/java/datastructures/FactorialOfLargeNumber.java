package datastructures;

public class FactorialOfLargeNumber {

    private static void factorial(int n) {
        int[] res = new int[500];
        int carry = 0;
        res[0] = 1;
        int nod = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < nod; j++) {
                int prod = (res[j] * i) + carry;
                res[j] = prod % 10;
                carry = prod / 10;
            }
            while (carry != 0) {
                res[nod] = carry % 10;
                carry /= 10;
                nod++;
            }
        }
        for (int i = nod - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    public static void main(String[] args) {
        int n = 50;
        factorial(n);
    }
}
