package poc.multi_threads;

public class Company {

    int n;
    boolean produced = false;

    public synchronized void itemProducer(int n){
        try {
            if (produced) wait();

            this.n = n;
            this.produced = true;
            System.out.println("Produced item :" + this.n);
            notify();

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public synchronized int itemConsumer(){
        try {
            if( !produced ) wait();
            System.out.println("Consumed item :" + this.n);
            this.produced = false;
            notify();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }finally {
            return this.n;
        }
    }
}
