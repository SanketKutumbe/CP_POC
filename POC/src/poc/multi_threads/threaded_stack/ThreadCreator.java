package poc.multi_threads.threaded_stack;

public class ThreadCreator {

    public static void main(String[] args) {

        CommonAddressSpace cas = new CommonAddressSpace(5);

        Thread t1 = new Thread(() -> {
            int i = 0;
            while(true){
                System.out.println("Pushing i into stack "+ i);
                cas.push(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
                System.out.println("Popping " + cas.pop() + " from the stack");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
