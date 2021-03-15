package multithreading;

public class OddEvenThreads {
    private static final int MAX_COUNT = 20;
    private static int counter = 1;
    private static boolean printZero = true;

    private void printOdd() {
        synchronized (this) {
            while (counter <= MAX_COUNT) {
                if (printZero || counter % 2 == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t" + counter);
                    counter++;
                    printZero = !printZero;
                    notifyAll();
                }
            }
        }
    }

    private void printEven() {
        synchronized (this) {
            while (counter <= MAX_COUNT) {
                if (printZero || counter % 2 == 1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t" + counter);
                    counter++;
                    printZero = !printZero;
                    notifyAll();
                }
            }
        }
    }

    private void printZero() {
        synchronized (this) {
            while (counter <= MAX_COUNT) {
                if (!printZero) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t" + 0);
                    printZero = !printZero;
                    notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {
        OddEvenThreads oddEvenThreads = new OddEvenThreads();
        Thread zeroThread = new Thread(oddEvenThreads::printZero);
        Thread oddThread = new Thread(oddEvenThreads::printOdd);
        Thread evenThread = new Thread(oddEvenThreads::printEven);
        zeroThread.start();
        oddThread.start();
        evenThread.start();
    }
}
