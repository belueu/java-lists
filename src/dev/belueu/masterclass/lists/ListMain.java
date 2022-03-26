package dev.belueu.masterclass.lists;

import java.util.Scanner;

public class ListMain {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Choice options");
        System.out.println("\t 1 - View list of groceries");
        System.out.println("\t 2 - Add item to grocery list");
        System.out.println("\t 3 - Modify item from grocery list");
        System.out.println("\t 4 - Remove item from grocery list");
        System.out.println("\t 5 - Search item in grocery list");
        System.out.println("\t 6 - Quit");
    }

    public static void addItem() {
        System.out.print("Please enter the item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Please enter the item you want to modify: ");
        String searchItem = groceryList.findGroceryItem(scanner.nextLine());
        System.out.print("Modify " + searchItem + " to: ");
        groceryList.modifyGroceryItem(searchItem, scanner.nextLine());
    }

    public static void removeItem() {
        System.out.print("Please enter the item you want to remove: ");
        groceryList.removeGroceryItem(scanner.nextLine());
    }

    public static void searchItem() {
        System.out.print("Please enter the item you want to search: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findGroceryItem(searchItem) == null) {
            System.out.println(searchItem + " not in the grocery list");
        } else {
            System.out.println("Search item found: " + searchItem);
        }
    }
}
