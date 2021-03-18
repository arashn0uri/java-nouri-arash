package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Take the main password from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert a new password (5 number, from 0 to 9): ");
        String password = input.next();
        System.out.println(password);
        // Create an array from the password(int) to find the index of numbers
        int[] indexOfPassword = intToArray(password);
        // Check the length of the password which has to be exactly 5
        while (indexOfPassword.length != 5) {
            System.out.print(
                    "Wrong password! Please choose exactly 5 number (from 0 to 9): "
            );
            password = input.next();
            indexOfPassword = intToArray(password);
        }
        System.out.print("Thank you!");
        System.out.println();
        // Create an array of random number from 1 to 3
        int[] randomPattern = randomGenerator();
        // Create a password based on the random pattern
        int[] passwordBasedOnPattern = getPatternPassword(
                indexOfPassword,
                randomPattern
        );
        // transform the array of pattern password to an integer
        int patternPassword = 0;
        for (int number : passwordBasedOnPattern) {
            patternPassword = (patternPassword * 10) + number;
        }
        System.out.println(
                "To log in to your account, please insert your password based on NUM pattern: "
        );
        System.out.println();
        System.out.println("PIN: 0 1 2 3 4 5 6 7 8 9");
        System.out.print("NUM: ");
        for (int number : randomPattern) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Please insert your password here: ");
        int newPassword = input.nextInt();
        while (patternPassword != newPassword) {
            System.out.print(
                    "Wrong Password! please insert your correct password based on NUM pattern: "
            );
            newPassword = input.nextInt();
        }
        System.out.println("Password is correct! welcome.");
        input.close();
    }

    // Create an array from the characters of an integer
    public static int[] intToArray(String pass) {
        int[] password = new int[pass.length()];
        for (int index = 0; index < pass.length(); index++) {
            password[index] = pass.charAt(index) - '0';
        }
        return password;
    }

    // Create a random array of three numbers (1, 2, 3)
    public static int[] randomGenerator() {
        Random random = new Random();
        int[] numbers = new int[]{1, 2, 3};
        int[] randomArray = new int[10];
        // Using do-while to be sure that there are at least one time the numbers 1 to 3 (with another method)
        do for (int index = 0; index < randomArray.length; index++)
            randomArray[index] = 1 + random.nextInt(3);
         while (!numberExist(randomArray, numbers));
        return randomArray;
    }

    public static boolean numberExist(int[] firstArray, int[] secondArray) {
        // If there is at least one time the numbers 1 to 3, the result will be true
        boolean result = true;
        for (int number : secondArray) {
            for (int index = 0; index < firstArray.length; index++) {
                if (number == firstArray[index]) break;
                if (index == firstArray.length - 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    // Create a password based on the random pattern with the index of password and the random pattern
    public static int[] getPatternPassword(int[] firstArray, int[] secondArray) {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] patternPassword = new int[5];
        for (
                int indexOfFirstArray = 0;
                indexOfFirstArray < firstArray.length;
                indexOfFirstArray++
        ) {
            for (
                    int indexOfSecondArray = 0;
                    indexOfSecondArray < numbers.length;
                    indexOfSecondArray++
            ) {
                if (firstArray[indexOfFirstArray] == numbers[indexOfSecondArray]) {
                    patternPassword[indexOfFirstArray] = secondArray[indexOfSecondArray];
                    break;
                }
            }
        }
        return patternPassword;
    }
}
