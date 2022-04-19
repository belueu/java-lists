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

    private Branch findBranch(String searchBranch) {
        Branch foundBranch = new Branch();
        for (Branch branch : branches) {
            if (searchBranch.equals(branch.getName())) {
                foundBranch = branch;
                break;
            }
        }
        return foundBranch;
    }

    public void addBranch(String branchName) {
        if (findBranch(branchName).getName() != null) {
            System.out.println("Branch with name: " + branchName + " already exist");
        } else {
            Branch createdBranch = new Branch(branchName);
            getBranches().add(createdBranch);
            System.out.println("New Branch with name: " + branchName + " created");
        }
    }

    public void deleteBranch(String branchName) {
        if (findBranch(branchName).getName() == null) {
            System.out.println("Branch with name: " + branchName + " does not exist");
        } else {
            getBranches().remove(findBranch(branchName));
            System.out.println("Branch with name: " + branchName + " removed");
        }
    }

    public void updateBranch(String oldBranchName, String newBranchName) {
        if (findBranch(oldBranchName).getName() == null) {
            System.out.println("Branch with name: " + oldBranchName + " does not exist");
        } else {
            int foundBranchIndex = getBranches().indexOf(findBranch(oldBranchName));
            getBranches().remove(foundBranchIndex);
            getBranches().add(foundBranchIndex, new Branch(newBranchName));
            System.out.println("Branch with name: " + oldBranchName + " updated to: " + newBranchName);
        }
    }

    public void showAllBranches() {
        getBranches().forEach(branch -> System.out.println(branch.getName()));
    }

    public void showBranchDetails(String branchName) {
        if (branchName.equals(findBranch(branchName).getName())) {
            System.out.println("Branch details -> Name: " + branchName + ", Total customers: " + findBranch(branchName).getCustomers().size());
        } else {
            System.out.println("Branch with name: " + branchName + " does not exist");
        }
    }
}
