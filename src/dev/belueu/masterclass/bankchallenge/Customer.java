package dev.belueu.masterclass.bankchallenge;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public ArrayList<Double> findTransactions(Double transactionValue) {
        ArrayList<Double> foundTransactions =
                transactions.stream()
                        .filter(value -> Objects.equals(transactionValue, value))
                        .collect(Collectors.toCollection(ArrayList::new));
        if (!foundTransactions.isEmpty()) {
            foundTransactions.forEach(value -> System.out.println("Transaction with Value: " + transactionValue + " found"));
            return foundTransactions;
        } else {
            System.out.println("Transactions with Value: " + transactionValue + " not found");
        }
        return null;
    }

    public boolean makeTransaction(Double transaction) {
        transactions.add(transaction);
        System.out.println("Transaction with Value: " + transaction + " processed");
        return true;
    }

    public void showAccountDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Total Transactions: " + getTransactions().size());
    }
}
