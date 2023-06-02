package poc.multi_threads.threaded_stack;

public class CommonAddressSpace {

    private int[] arr;
    private int capacity;
    private int top = -1;

    CommonAddressSpace(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public synchronized boolean push(int a)  {
        try{
            if( top == capacity-1 ) {
                System.out.println("Stack is full");
                wait();
            }
            top++;
            arr[top] = a;
            System.out.println("Stack has "+ (top+1) + " elements");
            notifyAll();
            return true;
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return false;
    }
    public synchronized int pop()  {
        try{
            if( top == -1 ) {
                System.out.println("Stack is empty");
                wait();
            }
            int result = arr[top];
            top--;
            notifyAll();
            return result;
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return -1;
    }
}
