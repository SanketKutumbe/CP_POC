package poc.design_patterns;

public class SingletonPattern1 {

    private static final SingletonPattern1 singletonPattern1 = new SingletonPattern1();

    private SingletonPattern1(){}

    public static SingletonPattern1 getInstance(){
        return singletonPattern1;
    }
}
