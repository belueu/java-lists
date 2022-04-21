package dev.belueu.masterclass.linkedlist;

import java.util.ArrayList;

public class LinkedListMain {

    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 54.23);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);

        System.out.println("Balance for customer: " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(4);
        integers.add(7);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println("Index: " + i + " -> Value: " + integers.get(i));
        }

        integers.add(1, 2);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println("Index: " + i + " -> Value: " + integers.get(i));
        }
    }
}
