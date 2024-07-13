package com.mypackage.ProjectMortgageCalculator;

public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber(
            "Principal ($1K-$1M)", 
            1000, 
            1_000_000);
        float annualInterestRate = (float) Console.readNumber(
            "Annual interest rate", 
            0, 
            30);
        byte numberOfYears = (byte) Console.readNumber(
            "Period (Years)", 
            1, 
            30);

        var calculator = new MortgageCalculator(
            principal, 
            annualInterestRate, 
            numberOfYears);
        
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printLoanBalance();
    }
}
