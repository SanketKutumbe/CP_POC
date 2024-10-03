package poc.lambdas;

import java.util.function.*;

public class LambdaInterfaces {

}

/*
    The Predicate<T> interface has an abstract method boolean test(T t). Basically, a predicate is a function that evaluates the given input and returns true or false.
 */

class PredicateInterface{
    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 23);
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> predicate = p -> p.age > 18;

        boolean eligible = isPersonEligibleForVoting(person , predicate);

        System.out.println("Person is eligible for voting: " + eligible);

        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> greaterThanEighteen = (p) -> p.age > 18;
        // Created a predicate. It returns true if age is less than 60.
        Predicate<Person> lessThanSixty = (p) -> p.age < 60;

        predicate = greaterThanEighteen.and(lessThanSixty);

        eligible = isPersonEligibleForMembership(person , predicate);
        System.out.println("Person is eligible for membership: " + eligible);

        person = new Person("Alex", 23);
        // Created a predicate. It returns true if age is greater than 60.
        Predicate<Person> greaterThanSixty = (p) -> p.age > 60;
        // Created a predicate. It returns true if year of service is greater than 30.
        Predicate<Person> serviceMoreThanThirty = (p) -> p.yearsOfService > 30;
        predicate = greaterThanSixty.or(serviceMoreThanThirty);

        eligible = isPersonEligibleForRetirement(person , predicate);
        System.out.println("Person is eligible for membership: " + eligible);

        Predicate<Integer> numberGreaterThanTen = p -> p > 10;

        boolean isLessThanTen = isNumberLessThanTen( numberGreaterThanTen);
        System.out.println("Is number less than ten: " + isLessThanTen);

        Predicate<String> predicate2  = Predicate.isEqual("Hello");

        // The same thing can be achieved by below lambda.
        // Predicate<String> predicate  = p -> p.equals("Hello");

        System.out.println(predicate2.test("Welcome"));

        eligible =
                isPersonEligibleForVoting(
                        person,
                        18,
                        (p, minAge) -> {
                            return p.age > minAge;
                        });
        System.out.println("Person is eligible for voting: " + eligible);

    }

    static boolean isPersonEligibleForMembership(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    static boolean isNumberLessThanTen(Predicate<Integer> predicate){
        return predicate.negate().test(14);
    }

    static boolean isPersonEligibleForVoting(
            Person person, Integer minAge, BiPredicate<Person, Integer> predicate) {
        return predicate.test(person, minAge);
    }
}

/*
    Supplier is an interface that does not take in any argument but produces a value when the get() function is invoked.
    Suppliers are useful when we don’t need to supply any value and obtain a result at the same time.
 */
class SuplierInterface{

    static boolean isPersonEligibleForVoting(
            Supplier<Person> supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }

    public static void main(String args[]) {
        Supplier<Person> supplier = () -> new Person("Alex", 23);
        Predicate<Person> predicate = (p) -> p.age > 18;
        boolean eligible =
                isPersonEligibleForVoting(supplier, predicate);
        System.out.println("Person is eligible for voting: " + eligible);

        IntSupplier supplier2 = () -> (int)(Math.random() * 10);

        System.out.println(supplier2.getAsInt());

        DoubleSupplier supplier3 = () -> (int)(Math.random() * 10);

        System.out.println(supplier3.getAsDouble());
    }
}

/*
    Consumers are functional interfaces that take in a parameter and do not produce anything.
 */

class ConsumerInterface{

    public static void main(String[] args) {

        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Hello World.");

        Consumer<Integer> intConsumer = i -> System.out.println("Integer value = " + i);
        intConsumer.accept(5);

        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");

        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");

        consumer1.andThen(consumer2).accept("Hello. ");

        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("Hello", "World");
    }
}

/*
    Function is a category of functional interfaces that takes an object of type T and returns an object of type R.

    Until now, the functional interfaces that we’ve discussed have either not taken any argument(Supplier), not returned any value(Consumer), or returned only a boolean(Predicate).

    Function interfaces are very useful as we can specify the type of input and output.
 */
class FunctionInterface{
    public static void main(String[] args) {
        // Created a function which returns the length of string.
        Function<String, Integer> lengthFunction = str -> str.length();

        System.out.println("String length: " + lengthFunction.apply("This is awesome!!"));

        // Function which adds 10 to the given element.
        Function<Integer, Integer> increment = x -> x + 10;
        // Function which doubles the given element.
        Function<Integer, Integer> multiply = y -> y * 2;
        // Since we are using compose(), multiplication will be done first and then increment will be done.
        System.out.println("compose result: " + increment.compose(multiply).apply(3));
        // Since we are using andThen(), increment will be done first and then multiplication will be done.
        System.out.println("andThen result: " + increment.andThen(multiply).apply(3));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println("Sum = " + add.apply(2, 3));
    }
}

/*
    The UnaryOperator<T> interface represents a function that takes one argument of type T and returns a value of the same type.
    This is similar to the Function interface, which is a parent to the UnaryOperator interface
 */
class UnaryInterface{
    public static void main(String args[]) {
        Person person = new Person();
        UnaryOperator<Person> operator = (p) -> {
            p.name = "John";
            p.age = 34;
            return p;
        };

        operator.apply(person);
        System.out.println("Person Name: " + person.getName() + " Person Age: " + person.getAge());

        IntUnaryOperator operator2 = num -> num * num;

        System.out.println(operator2.applyAsInt(25));
    }
}

/*
    BinaryOperator<T> is a functional interface that inherits from BiFunction<T, T, T> interface.
    The BinaryOperator<T> interface takes only one parameter as compared to BiFunction<T, T, T>, which takes three parameters(two operands type and one result type).

    Both the input objects and the result are of the same type in BinaryOperator<T>.
 */
class BinaryOperatorInterface{
    public static void main(String args[]) {
        Person person1 = new Person("Alex", 23);
        Person person2 = new Person("Daniel", 56);
        BinaryOperator<Person> operator = (p1, p2) -> {
            p1.name = p2.name;
            p1.age = p2.age;
            return p1;
        };

        operator.apply(person1, person2);
        System.out.println("Person Name: " + person1.getName() + " Person Age: " + person1.getAge());
    }
}

class Person {
    String name;
    int age;
    int yearsOfService;

    Person(){

    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
