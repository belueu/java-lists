package dev.belueu.masterclass.bankchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Customer customer = new Customer("Cristi", new ArrayList<>(List.of(100.0, 123.0)));
    private static Branch branch = new Branch("First", new ArrayList<>(
            List.of(new Customer("Maria"), new Customer("George"))));
    private static Bank bank = new Bank();


    public static void main(String[] args) throws IOException {
        branch.getCustomers().add(customer);
        bank.getBranches().add(branch);


        for (Branch branch1: bank.getBranches()) {
            System.out.println(branch1.getName());
        }


        boolean quit = false;

        while (!quit) {
            loginOptions();
            int option = Integer.parseInt(reader.readLine());

            switch (option) {
                case 0 -> {
                    System.out.println("Quit application...");
                    quit = true;
                }
                case 1 -> {
                    boolean bankQuit = false;
                    while (!bankQuit) {
                        bankOptions();
                        int bankOption = Integer.parseInt(reader.readLine());
                        switch (bankOption) {
                            case 0 -> {
                                System.out.println("Exiting bank application...");
                                bankQuit = true;
                            }
                            case 1 -> {
                                showBranchDetails();
                            }
                            case 2 -> {
                                addBranch();
                            }
                            case 3 -> {
                                updateBranch();
                            }
                            case 4 -> {
                                deleteBranch();
                            }
                            case 5 -> {
                                showAllBranches();
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean branchQuit = false;
                    while (!branchQuit) {
                        branchOptions();
                        int branchOption = Integer.parseInt(reader.readLine());
                        switch (branchOption) {
                            case 0 -> {
                                System.out.println("Exiting branch application...");
                                branchQuit = true;
                            }
                            case 1 -> {
                                showCustomerDetails();
                            }
                            case 2 -> {
                                addCustomer();
                            }
                            case 3 -> {
                                updateCustomer();
                            }
                            case 4 -> {
                                deleteCustomer();
                            }
                            case 5 -> {
                                showAllCustomers();
                            }
                        }
                    }
                }
                case 3 -> {
                    boolean customerQuit = false;
                    while (!customerQuit) {
                        customerOptions();
                        int customerOption = Integer.parseInt(reader.readLine());
                        switch (customerOption) {
                            case 0 -> {
                                System.out.println("Exiting customer application...");
                                customerQuit = true;
                            }
                            case 1 -> {
                                showAccountDetails();
                            }
                            case 2 -> {
                                makeTransaction();
                            }
                            case 3 -> {
                                findTransaction();
                            }
                            case 4 -> {
                                showAllTransactions();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void loginOptions() {
        System.out.println("Login as: ");
        System.out.println("Press 1 -> Bank");
        System.out.println("Press 2 -> Bank Branch");
        System.out.println("Press 3 -> Customer");
        System.out.println("Press 0 -> Quit");
    }

    public static void bankOptions() {
        System.out.println("Press 1 -> Branch Details");
        System.out.println("Press 2 -> Add Branch");
        System.out.println("Press 3 -> Update Branch");
        System.out.println("Press 4 -> Delete Branch");
        System.out.println("Press 5 -> Show all Branches");
        System.out.println("Press 0 -> Quit");
    }

    public static void showBranchDetails() throws IOException {
        System.out.println("Enter branch name: ");
        String branchName = reader.readLine();
        bank.showBranchDetails(branchName);
    }

    public static void addBranch() throws IOException {
        System.out.println("Enter Branch name: ");
        String branchName = reader.readLine();
        bank.addBranch(branchName);
    }

    public static void deleteBranch() throws IOException {
        System.out.println("Enter Branch name: ");
        String branchName = reader.readLine();
        bank.deleteBranch(branchName);
    }

    public static void showAllBranches() {
        bank.showAllBranches();
    }

    public static void updateBranch() throws IOException {
        System.out.println("Search Branch name: ");
        String searchBranch = reader.readLine();
        System.out.println("Enter new Branch name: ");
        String updateInfo = reader.readLine();
        bank.updateBranch(searchBranch, updateInfo);
    }

    public static void branchOptions() {
        System.out.println("Press 1 -> CustomerDetails");
        System.out.println("Press 2 -> Add Customer");
        System.out.println("Press 3 -> Update Customer");
        System.out.println("Press 4 -> Delete Customer");
        System.out.println("Press 5 -> Show all Customers");
        System.out.println("Press 0 -> Quit");
    }

    public static void showCustomerDetails() throws IOException {
        System.out.println("Enter Customer name: ");
        String customerName = reader.readLine();
        branch.showCustomerDetails(customerName);
    }

    public static void addCustomer() throws IOException {
        System.out.println("Enter Customer name: ");
        String customerName = reader.readLine();
        branch.addCustomer(customerName);
    }

    public static void deleteCustomer() throws IOException {
        System.out.println("Enter Customer name: ");
        String customerName = reader.readLine();
        branch.deleteCustomer(customerName);
    }

    public static void showAllCustomers() {
        branch.showAllCustomers();
    }

    public static void updateCustomer() throws IOException {
        System.out.println("Search Customer name: ");
        String searchCustomer = reader.readLine();
        System.out.println("Enter new Customer name: ");
        String updateInfo = reader.readLine();
        branch.updateCustomer(searchCustomer, updateInfo);
    }

    public static void customerOptions() {
        System.out.println("Press 1 -> Account Details");
        System.out.println("Press 2 -> Make Transaction");
        System.out.println("Press 3 -> Find Transaction");
        System.out.println("Press 4 -> Show all Transactions");
        System.out.println("Press 0 -> Quit");
    }

    public static void showAccountDetails() {

    }

    public static void makeTransaction() {

    }

    public static void findTransaction() {

    }

    public static void showAllTransactions() {

    }
}