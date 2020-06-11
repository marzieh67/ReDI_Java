package Java_1;

import java.util.Scanner;

    public class GiveMeYourInitials {
        public static void main(String[] args) {
            System.out.println("A program that computes your initials from your full name and displays them:");

            // Create a scanner and ask the user for input
            Scanner myLittleScanner = new Scanner(System.in);
            System.out.println("What is your name?");

            // this variable will hold the final initials, for now, we'll leave it empty
            String initials = "";

            // If the user enters something and pushes ENTER, he has entered one line. Let's get that line
            String fullName = myLittleScanner.nextLine();

            // Let's split up that line at the spaces (=words) and put it in an array, where each word gets a box
            String[] nameParts = fullName.split(" ");

            // let's loop over that array (=over all names)
            for (String name: nameParts) {
                // Let's check if the user accidentially entered multiple spaces (like "  ")
                // if there's a blank in the box, let's skip the rest of the loop and look into the next box
                if (name.isBlank()) {
                    continue;
                }
                System.out.println("So your name is " + name);

                // get the first character (at index 0) of the name
                String firstCharacter = String.valueOf(name.charAt(0));

                // append this character to our initials
                initials = initials + firstCharacter;
            }
            System.out.println("The initial of that name is "+ initials);
        }

}
