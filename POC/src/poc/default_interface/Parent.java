package poc.default_interface;

public interface Parent {

    public default void a(){
        System.out.println("Parent A");
    }
    public default void b(){}
    public default void c(){}
}

interface Child extends Parent{
    public default void a(){
        System.out.println("Child A");
    }
    public void b();

}

class Caller implements Parent, Child{
    public void b(){}
    public static void main(String[] args) {
        new Child() {
            @Override
            public void b() {

            }
        }.a();

    }
}
