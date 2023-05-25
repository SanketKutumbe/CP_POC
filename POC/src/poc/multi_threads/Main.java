package poc.multi_threads;

import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {

        Company c = new Company();
        Producer producerInstance = new Producer(c);
        Consumer consumerInstance = new Consumer(c);
        producerInstance.start();
        consumerInstance.start();
    }
}
