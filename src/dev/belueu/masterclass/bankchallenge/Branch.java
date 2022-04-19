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

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName) {
        Customer foundCustomer = new Customer();

        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
            }
        }

        return foundCustomer;
    }

    public void addCustomer(String customerName) {
        if (findCustomer(customerName).getName() != null) {
            System.out.println("Customer with name: " + customerName + " already exist");
        } else {
            Customer newCustomer = new Customer(customerName);
            getCustomers().add(newCustomer);
            System.out.println("New Customer with name: " + customerName + " created");
        }
    }

    public boolean updateCustomer(String oldCustomerName, String newCustomerName) {
        if (findCustomer(oldCustomerName).getName() == null) {
            System.out.println("Customer with name: " + oldCustomerName + " does not exist");
        } else {
            int indexOfCurrentCustomer = getCustomers().indexOf(findCustomer(oldCustomerName));
            getCustomers().remove(indexOfCurrentCustomer);
            getCustomers().add(indexOfCurrentCustomer, new Customer(newCustomerName));
            System.out.println("Customer with name: " + oldCustomerName + " updated to: " + newCustomerName);
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(String customerName) {
        if (findCustomer(customerName).getName() == null) {
            System.out.println("Customer with name: " + customerName + " does not exist");
        } else {
            getCustomers().remove(findCustomer(customerName));
            System.out.println("Customer with name: " + customerName + " removed");
        }
        return false;
    }

    public void showCustomerDetails(String customerName) {
        if (customerName.equals(findCustomer(customerName).getName())) {
            System.out.println("Customer details -> Name: " + customerName + ", Total transactions: " + findCustomer(customerName).getTransactions().size());
        } else {
            System.out.println("Customer with name: " + customerName + " does not exist");
        }
    }

    public void showAllCustomers() {
        getCustomers().forEach(customer -> System.out.println(customer.getName()));
    }
}
