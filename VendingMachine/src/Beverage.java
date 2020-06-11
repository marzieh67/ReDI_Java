public class Beverage {
    // every beverage has the following properties:
    double alcoholLevel;
    String name;
    boolean isAlcolholic;

    // the constructor: if you want to create an object of the type Beverage you call this by writing
    // new Beverage(...)
    // the Constructor is a special function that forces you to provide certain information as arguments
    Beverage(double alcohol, String name, boolean isAlcolholic) {
        alcoholLevel = alcohol;
        this.name = name;
        this.isAlcolholic = isAlcolholic;
    }

    // every beverage provides a function:
    // this function takes a Customer as argument and decides whether it can be bought or not
    public boolean canItBePurchased(Consumer buyer) {
        // if the beverage is not alcoholic, no further distinction is necessary, it can be bought.
        if (!isAlcolholic) {
            //exit the function and return true
            return true;
        }
        // ask the consumer if he/she is minor. If they are (Consumer returns true), return false and exit the function
        if (buyer.isMinor()) {
            return false;
        }

        // in any other case (i.e. the beverage is alcoholic and the consumer is NOT minor, return true
        // the order of commands matters here!
        return true;
    }
}
