package dev.belueu.masterclass.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DemoMain {

    public static void main(String[] args) throws IOException {
        LinkedList<String> capitals = new LinkedList<>();
        LinkedList<String> cities = new LinkedList<>();

        addInOrder(capitals, "Sydney");
        addInOrder(capitals, "Melbourne");
        addInOrder(capitals, "Brisbane");
        addInOrder(capitals, "Perth");
        addInOrder(capitals, "Canberra");
        addInOrder(capitals, "Adelaide");
        addInOrder(capitals, "Darwin");
        addInOrder(capitals, "Darwin");
        printList(capitals);


        addAndOrder(cities, "Sydney");
        addAndOrder(cities, "Alice Springs");
        addAndOrder(cities, "Melbourne");
        addAndOrder(cities, "Brisbane");
        addAndOrder(cities, "Darwin");
        addAndOrder(cities, "Perth");
        addAndOrder(cities, "Canberra");
        addAndOrder(cities, "Adelaide");
        addAndOrder(cities, "Darwin");

        printList(cities);

        visit(cities);

//        capitals.add("Sydney");
//        capitals.add("Melbourne");
//        capitals.add("Brisbane");
//        capitals.add("Perth");
//        capitals.add("Canberra");
//        capitals.add("Adelaide");
//        capitals.add("Darwin");
//
//        capitals.sort(Comparator.naturalOrder());
//        printList(capitals);
//        capitals.add(1, "Alice Springs");
//
//        printList(capitals);
//
//        capitals.remove(4);
//
//        printList(capitals);
    }

    private static void printList(LinkedList<String> linkedList) {
//        Iterator<String> iterator = linkedList.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println("Now visiting -> " + iterator.next());
//        }

        linkedList.forEach(elem -> System.out.println("Now visiting: " + elem));
        System.out.println("----------------------");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println("City: " + newCity + " is already included as destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                // Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }  // move to the next city
        }
        stringListIterator.add(newCity);

        return true;
    }

    private static boolean addAndOrder(LinkedList<String> list, String newCity) {
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            int comparator = stringListIterator.next().compareTo(newCity);
            if (comparator == 0) {
                System.out.println("City: " + newCity + " already exists");
                return false;
            } else if (comparator > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }
        stringListIterator.add(newCity);

        return true;
    }

    private static void visit(LinkedList<String> cities) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("now visiting -> " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 0 -> {
                    System.out.println("Holiday ended");
                    quit = true;
                }
                case 1 -> {
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("No more destinations");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("We are at the beginning");
                        goingForward = true;
                    }
                }
                case 3 -> {
                    printMenu();
                }
            }
        }
        reader.close();
    }

    private static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("Press: 0 -> Quit");
        System.out.println("Press: 1 -> Next destination");
        System.out.println("Press: 2 -> Previous destination");
        System.out.println("Press: 3 -> Display options");
    }
}
