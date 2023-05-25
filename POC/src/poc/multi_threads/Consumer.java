package poc.multi_threads;

public class Consumer extends Thread{
    Company c;

    public Consumer(Company c){
        this.c = c;
    }

    public void run(){
        try{
            while(true) {
                this.c.itemConsumer();
                Thread.sleep(2000);
            }
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
