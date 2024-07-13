package com.mypackage.ProjectMortgageCalculator;

public class MortgageCalculator {
    private final static byte MONTHS_IN_A_YEAR = 12;
    private final static byte PERCENT = 100;
    
    private int principal;
    private float annualInterestRate;
    private byte numberOfYears;
    // Make monthlyInterestRate and numberOfMonths as fields and initialize them in the constructor using the getMonthlyInterestRate() and getNumberOfMonths() methods respectively?

    // Constructor
    public MortgageCalculator(
        int principal, float annualInterestRate, byte numberOfYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
    }
    
    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfMonths = getNumberOfMonths();
    
        double mortgage = principal 
            * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
            / ((Math.pow(1 + monthlyInterestRate, numberOfMonths)) - 1);
        
        return mortgage;
    }

    public double calculateLoanBalance(short monthsPassed) {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfMonths = getNumberOfMonths();
        
        double balance = principal
                    * (Math.pow(1 + monthlyInterestRate, numberOfMonths) - Math.pow(1 + monthlyInterestRate, monthsPassed))
                    / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
        
        return balance;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfMonths()];

        for (short monthsPassed = 1; monthsPassed <= balances.length; monthsPassed++)
            balances[monthsPassed-1] = calculateLoanBalance(monthsPassed);
        
        return balances;
    }

    private short getNumberOfMonths() {
        return (short)(numberOfYears * MONTHS_IN_A_YEAR);
    }
    
    private float getMonthlyInterestRate() {
        return (annualInterestRate/PERCENT)/MONTHS_IN_A_YEAR;
    }
}
