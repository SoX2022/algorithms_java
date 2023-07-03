package Homework.Homework_3;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(6);
        tree.add(3);
        tree.add(2);
        tree.add(4);

        checkTreeValues(tree);

        if (tree.remove(4)) {
            System.out.println(">>> element removed");
        };
        checkTreeValues(tree);

        if (tree.remove(2)) {
            System.out.println(">>> element removed");
        };
        checkTreeValues(tree);

        if (tree.remove(3)) {
            System.out.println(">>> element removed");
        };
        checkTreeValues(tree);

        if (tree.remove(6)) {
            System.out.println(">>> element removed");
        };
        checkTreeValues(tree);



    }

    public static void checkTreeValues(BinaryTree<Integer> tree) {
        for (int i = 0; i < 11; i++) {
            if (tree.contain(i)) {
                System.out.println(i + " true");
            }
        }
    }
}
