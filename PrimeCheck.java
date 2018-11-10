
/*
 *
 * This program tests whether a given positive number is a prime number.
 */

import java.util.*;

class Prime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        if (isPrime(num))
            System.out.println(num + " is a prime");
        else
            System.out.println(num + " is not a prime");

        if (isPrime2(num))
            System.out.println("yeah");
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else if ((num % 2 == 0) || (num % 3 == 0)) {
            return false;
        }
        return true;
    }
}
