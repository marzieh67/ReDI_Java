package Java_1;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        System.out.println("Enter the dimention");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        pattern(number);
    }

    public static void pattern(int number) {
        for (int i = 1; i < number + 1; i += 1) {
            for (int j = 1; j <= number - i; j += 1) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int i = number - 1; i > 0; i -= 1) {
            for (int j = 1; j <= number - i; j += 1) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
