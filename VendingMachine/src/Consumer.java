public class Consumer {
    // every customer has the following attributes:
    int age;
    String name;

    // the constructor (for an explanation, see Beverage class)
    Consumer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // provide a function to ask the customer whether he/she is minor
    boolean isMinor() {
        // age < 18 is a function in itself that returns true if this.age is < 18. isMinor() returns this result
        return age < 18;
    }

    // a static method always returns the same value(s) for any instance of this class
    static int ageOfMajority() {
        return 18;
    }

}
