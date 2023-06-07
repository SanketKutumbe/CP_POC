package poc.virtualMethods;

/*
The most important feature of polymorphism—and one of the primary reasons we have
class structure at all—is to support virtual methods. A virtual method is a method in which
the specific implementation is not determined until runtime
 */
class Bird {
    public String getName() {
        return "Unknown";
    }
    public void displayInformation() {
        System.out.println("The bird name is: "+getName());
    }
}
public class Peacock extends Bird {
    public String getName() {
        return "Peacock";
    }
    public static void main(String[] args) {
        Bird bird = new Peacock();
        bird.displayInformation();
    }
}