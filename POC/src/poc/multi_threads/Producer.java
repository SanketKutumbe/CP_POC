package poc.multi_threads;

public class Producer extends Thread{

    Company c;

    public Producer(Company c){
        this.c = c;
    }

    public void run(){

        try{
            int i = 1;

            while(true){
                    this.c.itemProducer(i);
                    i++;
                    Thread.sleep(1000);
                }
            }catch(InterruptedException ie){
                ie.printStackTrace();
        }
    }
}
