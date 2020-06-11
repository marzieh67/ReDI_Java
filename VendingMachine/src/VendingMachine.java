// the class VendingMachine makes use of the classes Consumer and Beverage

public class VendingMachine {
        // in the main method you write your "story"
        public static void main(String[] args) {
            // creade different beverages
            Beverage juice = new Beverage(0, "Juice", false);
            Beverage helles = new Beverage(4.8, "Helles", true);

            // create different customers
            Consumer littleBob = new Consumer(9, "Bobby The Little One");
            Consumer bigBob = new Consumer(50, "Bob The Big One");

            // this is where your sale starts
            Beverage beverageToBePurchased = helles;
            Consumer personThatWantsToBuy = littleBob;

            // use the methods of that Beverage to determine if the vending machine will sell or not
            if (beverageToBePurchased.canItBePurchased(personThatWantsToBuy)) {
                System.out.println( personThatWantsToBuy.name + " Can drink "+ beverageToBePurchased.name);
            } else {
                System.out.println( personThatWantsToBuy.name + " Can NOT drink "+ beverageToBePurchased.name + " Because the age of majority is "+ Consumer.ageOfMajority()+ " and he is "+ personThatWantsToBuy.age);
            }
        }

}
