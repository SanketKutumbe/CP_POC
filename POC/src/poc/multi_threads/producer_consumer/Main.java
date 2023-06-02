package poc.multi_threads.producer_consumer;

public class Main {
    public static void main(String[] args) {

        Company c = new Company();
        Producer producerInstance = new Producer(c);
        Consumer consumerInstance = new Consumer(c);
        producerInstance.start();
        consumerInstance.start();
    }
}
