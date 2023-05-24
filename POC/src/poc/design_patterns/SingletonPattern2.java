package poc.design_patterns;

public class SingletonPattern2 {

    private static final SingletonPattern2 instance;

    static { instance = new SingletonPattern2(); }

    private SingletonPattern2(){}

    public static SingletonPattern2 getInstance(){
        return instance;
    }
}
