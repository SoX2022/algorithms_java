package Homework.Exeptions.Homework_01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

        // ArithmeticException
        // division(5, 0);

        // NullPointerException
        // sum(5, null);

        // ArrayIndexOutOfBoundsException
        // int[] array = new int[5];
        // printArray(array);


        // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

        // public static int sum2d(String[][] arr) {
        //     int sum = 0;
        //     for (int i = 0; i < arr.length; i++) {
        //         for (int j = 0; j < 5; j++) {
        //             int val = Integer.parseInt(arr[i][j]);
        //             sum += val;
        //         }
        //     }
        //     return sum;
        // }

        /* Нашел 2 исключения:
        ArrayIndexOutOfBoundsException
        NumberFormatException
        */ 


        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.

        int[] firstArray = new int[] {1, 2, 3};
        int[] secondArray = new int[] {6, 5, 4};
        int[] thirdArray = new int[] {7, 8, 9, 0};
        int[] result = getNewArray(firstArray, secondArray);
        System.out.print("result array = ");
        System.out.println(Arrays.toString(result));
        System.out.println();
        int[] result2 = getNewArray(firstArray, thirdArray);
        System.out.print("result2 array = ");
        System.out.println(Arrays.toString(result2));
        System.out.println();
        
        // * НЕ ОБЯЗАТЕЛЬНО. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.


        int[] firstArray2 = new int[] {1, 2, 0};
        int[] secondArray2 = new int[] {6, 5, 4};
        int[] thirdArray2 = new int[] {7, 8, 9, 0};
        int[] newResult = getNewArray2(firstArray2, secondArray2);
        System.out.print("newResult array = ");
        System.out.println(Arrays.toString(newResult));
        System.out.println();
        int[] newResult2 = getNewArray2(firstArray2, thirdArray2);
        System.out.print("newResult2 array = ");
        System.out.println(Arrays.toString(newResult2));
        System.out.println();
        int[] newResult3 = getNewArray2(secondArray2, firstArray2);
        System.out.print("newResult3 array = ");
        System.out.println(Arrays.toString(newResult3));
        System.out.println();
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int sum(Integer a, Integer b) {
        return a + b;
    }

    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i <= array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static int[] getNewArray(int[] firstArray, int[] secondArray) {
        if (firstArray.length == secondArray.length) {
            int[] newArray = firstArray.clone();
            for (int i = 0; i < secondArray.length; i++) {
                newArray[i] -= secondArray[i];
            }
            return newArray;
        }
        System.out.println("Warning!\nThe length of the first array is not the same as the length of the second array.\nOperation denied.");
        return null;
    }

    public static int[] getNewArray2(int[] firstArray, int[] secondArray) {
        if (firstArray.length == secondArray.length) {
            if (findValueInArray(secondArray, 0)) {
                throw new RuntimeException("Second array containes 0.\nOperation denied. Division by 0.");
            }
            int[] newArray = firstArray.clone();
            for (int i = 0; i < secondArray.length; i++) {
                newArray[i] /= secondArray[i];
            }
            return newArray;
        }
        System.out.println("Warning!\nThe length of the first array is not the same as the length of the second array.\nOperation denied.");
        return null;
    }

    private static boolean findValueInArray(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}
