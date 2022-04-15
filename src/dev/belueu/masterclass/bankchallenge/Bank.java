package dev.belueu.masterclass.bankchallenge;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank() {
    }

    public Bank(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public Branch findBranch(String branchName) {
        Branch foundBranch = new Branch();

        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                foundBranch = branch;
                break;
            }
        }

        return foundBranch;
    }

    public void addBranch(Branch branch) {
        Branch foundBranch = findBranch(branch.getName());
        if (foundBranch.getName() != null) {
            System.out.println("Branch with name: " + branch.getName() + " already exists");
            return;
        }

        branches.add(foundBranch);
    }

    public void updateBranch(String oldBranchName, String newBranchName) {
        Branch oldBranch = findBranch(oldBranchName);
        if (oldBranch.getName() != null) {
            oldBranch.setName(newBranchName);
        } else {
            System.out.println("Branch with Name: " + oldBranch.getName() + " not found");
        }

    }

    public void deleteBranch(String branchName) {
        Branch foundBranch = findBranch(branchName);
        if (foundBranch.getName() != null) {
            System.out.println("Branch with Name: " + foundBranch.getName() + " removed");
            branches.remove(foundBranch);
        } else {
            System.out.println("Branch with Name: " + branchName + " not found");
        }
    }

    public void showBranchDetails(String branchName) {
        Branch foundBranch = findBranch(branchName);
        if (foundBranch.getName() != null) {
            System.out.println("Branch Details -> Name: " + foundBranch.getName() + ", Total Customers: " + foundBranch.getCustomers().size() + "\n");
        } else {
            System.out.println("Branch with name: " + branchName + " not found\n");
        }
    }
}
