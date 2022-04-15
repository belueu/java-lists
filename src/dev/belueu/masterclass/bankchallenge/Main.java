package dev.belueu.masterclass.bankchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Customer customer = new Customer();
    private static Branch branch = new Branch();
    private static Bank bank = new Bank();


    public static void main(String[] args) throws IOException {
        customer.setName("Cristi");
        customer.setTransactions(new ArrayList<>(List.of(100.0, 123.0)));
        branch.addCustomer(customer);
        branch.setName("First");
        bank.addBranch(branch.getName());

        System.out.println(branch.getName());
        System.out.println(bank.getBranches().size());


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
                                bankOptions();
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
        System.out.println("Press 5 -> Display Options");
        System.out.println("Press 0 -> Quit");
    }

    public static void showBranchDetails() throws IOException {
        System.out.println("Enter branch name: ");
        String branchName = reader.readLine();
        bank.showBranchDetails(branchName);
    }

    public static void addBranch()  throws IOException{
        System.out.println("Enter Branch name");
        String branchName = reader.readLine();
        bank.addBranch(branchName);
    }

    public static void updateBranch() throws IOException {
        System.out.println("Search Branch name: ");
        String searchBranch = reader.readLine();
        System.out.println("Enter new Branch name: ");
        String updateInfo = reader.readLine();
        bank.updateBranch(searchBranch, updateInfo);
    }

    public static void deleteBranch() throws IOException {
        System.out.println("Search Branch name: ");
        String searchBranch = reader.readLine();
        bank.deleteBranch(searchBranch);
    }

}
