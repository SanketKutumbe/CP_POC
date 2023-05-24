package poc.design_patterns;

/*
Thread-safe Singleton:

The synchronized implementation of getInstance(), while correctly preventing multiple singleton objects from being created.

Con: Performance hit is caused because every single call to this method will require synchronization.

 */
public class SingletonThreadSafe1_LazyLoading {

    private static SingletonThreadSafe1_LazyLoading instance;

    private SingletonThreadSafe1_LazyLoading(){ }

    public static synchronized SingletonThreadSafe1_LazyLoading getInstance(){

        if( instance == null ){
            instance = new SingletonThreadSafe1_LazyLoading();
        }
        return instance;
    }

}
