package dev.belueu.masterclass.autoboxing;

import java.text.DecimalFormat;
import java.util.ArrayList;

class IntClass {
    private int number;

    public IntClass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class AutoboxingMain {
    public static void main(String[] args) {
        String[] strings = new String[10];
        int[] ints = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Cristi");

        ArrayList<IntClass> intClassArrayList = new ArrayList<>();
        intClassArrayList.add(new IntClass(100));

        intClassArrayList.forEach(val -> System.out.println(val.getNumber()));

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(i * 10);
        }

        integers.forEach(integer -> System.out.println(integer.intValue()));

        DecimalFormat df = new DecimalFormat("0.00");

        ArrayList<Double> doubles = new ArrayList<>();
        for (double i = 0; i < 10; i += .01) {
            doubles.add(i);
        }

        doubles.forEach(aDouble -> System.out.println(df.format(aDouble.doubleValue())));

    }
}
