package com.mypackage.ProjectMortgageCalculator;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("\nMORGAGE");
        System.out.println("-------");
        System.out.println("Monthly Payment: " + currency.format(mortgage));
    }

    public void printLoanBalance() {
        System.out.println("\nLOAN BALANCE");
        System.out.println("------------");
    
        double[] balances = calculator.getRemainingBalances();
        for (double balance : balances)
            System.out.println(currency.format(balance));
    }
}
