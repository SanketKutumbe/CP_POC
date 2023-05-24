package poc.design_patterns;

/*

double‐checked locking, a design pattern in which we first test if synchronization is needed before actually acquiring any locks

 */
public class SingletonThreadSafe2_LazyLoading {

    private static volatile SingletonThreadSafe2_LazyLoading instance;

    private SingletonThreadSafe2_LazyLoading(){}

    public static SingletonThreadSafe2_LazyLoading getInstance(){
        if( instance == null ) {
            synchronized (SingletonThreadSafe2_LazyLoading.class) {
                instance = new SingletonThreadSafe2_LazyLoading();
            }
        }
        return instance;
    }
}

