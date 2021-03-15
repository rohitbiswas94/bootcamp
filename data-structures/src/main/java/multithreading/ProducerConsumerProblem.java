package multithreading;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerProblem {

    private List<Integer> buffer;
    private static volatile int capacity = 5;
    private static volatile int maxTransactions = 20;
    private static volatile int transactions = 0;

    ProducerConsumerProblem() {
        buffer = new LinkedList<>();
    }

    private void produce() {
        int value = 1;
        synchronized (this) {
            while (transactions < maxTransactions) {
                if (buffer.size() == capacity) {
                    try {
                        System.out.println("Producer is waiting...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " producing: " + value);
                    buffer.add(value++);
                    transactions++;
                    notify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Producer has stopped");
        }
    }

    private void consume() {
        synchronized (this) {
            while (transactions < maxTransactions) {
                if (buffer.isEmpty()) {
                    try {
                        System.out.println("Consumer is waiting...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " consuming: " + buffer.get(0));
                    buffer.remove(0);
                    transactions++;
                    notify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Consumer has stopped");
        }
    }

    public static void main(String[] args) {
        ProducerConsumerProblem pcp = new ProducerConsumerProblem();
        Thread producer = new Thread(pcp::produce);
        Thread consumer = new Thread(pcp::consume);
        producer.start();
        consumer.start();
    }
}
