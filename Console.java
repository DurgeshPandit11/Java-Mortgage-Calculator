package com.mypackage.ProjectMortgageCalculator;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    
    // (Overloaded) readNumber() method to read a number with NO constraints
    public static double readNumber(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }
    
    // readNumber() method to read a number with constraints (number to read has min and max possible values)
    public static double readNumber(
        String prompt, 
        double lowerBound, 
        double upperBound) {
        double value = 0;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= lowerBound && value <= upperBound)
                break;
            System.out.println("Enter a value between " + lowerBound + " and " + upperBound);
        }
        return value;
    }
}