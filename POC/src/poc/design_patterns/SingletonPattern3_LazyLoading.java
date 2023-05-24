package poc.design_patterns;

/*
Definition: Creating a reusable object the first time it is requested is a software design pattern known as "lazy instantiation".
Use: It used often in conjunction with the singleton pattern.
Pros: It reduces memory usage and improves performance when an application starts up. In fact, without lazy instantiation, most operating systems and applications that you
run would take significantly longer to load and consume a great deal more memory, perhaps more memory than is even available on your computer.
Cons: Users may see a noticeable "delay" the "first time" a particular type of resource is needed

 */
public class SingletonPattern3_LazyLoading {
        private static SingletonPattern3_LazyLoading instance;

        private SingletonPattern3_LazyLoading(){ }

        public static SingletonPattern3_LazyLoading getInstance(){

            if( instance == null ){
                instance = new SingletonPattern3_LazyLoading();
            }
            return instance;
        }
}
