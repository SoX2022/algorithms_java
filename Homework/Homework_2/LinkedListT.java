package Homework.Homework_2;

public class LinkedListT<T extends Comparable<T>> {
    private Node root;
    private int size;

    public void add(T value) {
        Node newNode = new Node(value, null);
        if (root == null) {
            root = newNode;
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    public boolean removeAt(int index) {
        if (size <= index)
            return false;
        if (index == 0) {
            root = root.next;
            size--;
            return true;
        }
        Node currentNode = root;
        for (int i = 0; i < index - 1; i++)
            currentNode = currentNode.next;
        Node prev = currentNode;
        prev.next = currentNode.next.next;
        size--;
        return true;
    }

    public boolean remove(T value) {
        if (size == 0)
            return false;
        Node currentNode = root;

        for (int i = 0; currentNode != null; i++) {
            if (currentNode.value.compareTo(value) == 0) {
                this.removeAt(i);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean removeAll(T value) {
        if (size == 0)
            return false;
        boolean restart = true;
        boolean isDeleted = false;
        while (restart) {
            restart = remove(value);
            if (restart)
                isDeleted = true;
        }
        return isDeleted;
    }

    public void print() {
        System.out.print("[ ");
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    public int find(T value) {
        if (size == 0)
            return -1;
        Node currentNode = root;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.value.compareTo(value) == 0)
                return i;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void sort() {
        this.quickSort(0, size - 1);
    }

    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = this.getValue((leftMarker + rightMarker) / 2);
        do {
            while (this.getValue(leftMarker).compareTo(pivot) < 0)
                leftMarker++;
            while (this.getValue(rightMarker).compareTo(pivot) > 0)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    this.swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
    }

    public T getValue(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode.value;
    }

    public void swap(int index_1, int index_2) {
        if (index_1 >= size || index_2 >= size || index_1 == index_2 || index_1 < 0 || index_2 < 0)
            return;
        Node node_1 = null;
        Node node_2 = null;
        Node currentNode = root;
        for (int i = 0; node_1 == null || node_2 == null; i++) {
            if (i == index_1)
                node_1 = currentNode;
            else if (i == index_2)
                node_2 = currentNode;
            currentNode = currentNode.next;
        }
        T temp = node_1.value;
        node_1.value = node_2.value;
        node_2.value = temp;
    }

        public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node currentNode = root;
        Node next = null;

        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        root = prev;
    }


    private class Node {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
