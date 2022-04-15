package dev.belueu.masterclass.palindrom;

public class PalindromeMain {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        int[] palindromicArray = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(isPalindromic(palindromicArray));
        System.out.println(isPalindromeString(-10001));
    }

    public static boolean isPalindrome(int number) {
        int remainder;
        int sum = 0;
        int temp = number;

        while (number > 0) {
            remainder = number % 10;
            sum = (sum * 10) + remainder;
            number = number / 10;
        }

        return sum == temp;
    }

    public static String isPalindromeString(int number) {
        String stringNumber = String.valueOf(number).replace("-", "");
        StringBuilder reversedStringNumber = new StringBuilder();
        for (int i = 0; i < stringNumber.length(); i++) {
            reversedStringNumber.append(stringNumber.charAt((stringNumber.length() - 1) - i));
        }

        System.out.println("Number: " + stringNumber);
        System.out.println("Reversed number:" + reversedStringNumber);
        return (stringNumber.equals(reversedStringNumber.toString())) ? "Is Palindrome" : "Not palindrome";
    }

    public static boolean isPalindromic(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length / 2; i++) {
            System.out.println(i);
            if (array[i] != array[(array.length - 1) - i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
