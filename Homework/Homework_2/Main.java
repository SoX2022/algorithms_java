package Homework.Homework_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        LinkedList list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        list.print();
        list.reverse();
        list.print();
        System.out.println();

        LinkedListT<Integer> listT = new LinkedListT<>();

        for (int i = 0; i < 10; i++) {
            listT.add(random.nextInt(10));
        }

        listT.print();
        listT.reverse();
        listT.print();
    }
}
