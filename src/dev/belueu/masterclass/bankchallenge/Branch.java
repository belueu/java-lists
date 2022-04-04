package dev.belueu.masterclass.bankchallenge;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch() {
    }

    public Branch(String name, ArrayList<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Customer findCustomer(String customerName) {
        Customer foundCustomer = customers.stream().filter(customer -> customerName.equals(customer.getName())).findFirst().orElse(null);
        if (foundCustomer != null) {
            System.out.println("Customer with Name: " + foundCustomer.getName() + " found");
            return foundCustomer;
        } else {
            System.out.println("Customer with Name: " + customerName + " not found");
        }

        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean updateCustomer(Customer oldCustomer, Customer newCustomer) {
        Customer foundCustomer = findCustomer(oldCustomer.getName());
        if (foundCustomer != null) {
            oldCustomer.setName(newCustomer.getName());
            return true;
        } else {
            System.out.println("Customer with Name: " + oldCustomer.getName() + " not found");
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        Customer foundCustomer = findCustomer(customer.getName());
        if (foundCustomer != null) {
            System.out.println("Customer with Name: " + customer.getName() + " removed");
            customers.remove(customer);
            return true;
        } else {
            System.out.println("Customer with Name: " + customer.getName() + " not found");
        }
        return false;
    }

    public String showCustomerDetails(Customer customer) {
        Customer foundCustomer = findCustomer(customer.getName());
        if (foundCustomer == null) {
            System.out.println("Customer with Name: " + customer.getName() + " not found");
        }
        return "Customer Details -> Name: " + customer.getName() + ", Total Transactions: " + customer.getTransactions().size();
    }
}
