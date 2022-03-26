package dev.belueu.masterclass.lists;

import java.util.ArrayList;
import java.util.Arrays;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        groceryList.forEach(System.out::println);
    }

    public void modifyGroceryItem(String searchItem, String modify) {
        groceryList.set(groceryList.indexOf(searchItem), modify);
    }

    public void removeGroceryItem(String item) {
        groceryList.remove(item);
    }

    public String findGroceryItem(String item) {
        boolean exists = groceryList.contains(item);
        try {
            return groceryList.get(groceryList.indexOf(item));
        } catch (Exception exception) {
            exception.getMessage();
        }
        return null;
    }
}
