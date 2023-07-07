package Homework.Exeptions.Homework_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

        System.out.println(getUserNumber());

        // Задание 2
        // Если необходимо, исправьте код:
        // try {
        // int d = 0;
        // double catchedRes1 = intArray[8] / d;
        // System.out.println("catchedRes1 = " + catchedRes1);
        // } catch (ArithmeticException e) {
        // System.out.println("Catching exception: " + e);
        // }

        // int[] intArray = null;
        // int[] intArray1 = new int[] {1, 2, 3, 4, 5};
        int[] intArray2 = new int[] {1, 2 , 3, 4, 5, 6, 7, 8, 9, 10};
        // String[] intArray3 = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        // String[] intArray4 = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        int d = 0;
        try {
            double catchedRes1 = Integer.valueOf(intArray2[8]) / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Catching exception: " + e);
        } 

        // Задание 3
        // Если необходимо, исправьте код:
        // public static void main(String[] args) throws Exception {
        // try {
        // int a = 90;
        // int b = 3;
        // System.out.println(a / b);
        // printSum(23, 234);
        // int[] abc = { 1, 2 };
        // abc[3] = 9;
        // } catch (Throwable ex) {
        // System.out.println("Что-то пошло не так...");
        // } catch (NullPointerException ex) {
        // System.out.println("Указатель не может указывать на null!");
        // } catch (IndexOutOfBoundsException ex) {
        // System.out.println("Массив выходит за пределы своего размера!");
        // }
        // }
        // public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        // System.out.println(a + b);
        // }

        task3();

        // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

        try {
            getUserString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float getUserNumber() {
        float number;
        System.out.print("Enter your number: ");
        try (Scanner scanner = new Scanner(System.in)){
            number = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Illegal value. Try again.");
            number = getUserNumber();
        }
        return number;
    }

    public static void task3() {
        int a = 90;
        int b = 3;

        try {
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
        }

    public static void getUserString() throws Exception {
        System.out.print("Enter something but empty string: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextLine() == "") {
            scanner.close();
            throw new Exception("User didn`t enter anything.");
        }

        scanner.close();
    }
}
