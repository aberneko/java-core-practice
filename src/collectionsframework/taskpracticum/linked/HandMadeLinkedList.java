package collectionsframework.taskpracticum.linked;
import java.util.NoSuchElementException;

public class HandMadeLinkedList<T> {

    // inner class - внутренний класс - вложенный
    static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;


    public void addFirst(T element) {
        final Node<T> oldHead = head;
        final Node<T> newNode = new Node<>(null, element, oldHead);
        head = newNode;
        if (oldHead == null)
            tail = newNode;
        else
            oldHead.prev = newNode;
        size++;
    }

    public T getFirst() {
        final Node<T> curHead = head;
        if (curHead == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public void addLast(T element) {
        // Реализуйте метод
        final Node<T> oldHead = tail;
        final Node<T> newNodeLast = new Node<>(oldHead, element, null);
        tail = newNodeLast;
        if (oldHead == null)
            head = newNodeLast;
        else
            oldHead.next = newNodeLast;
        size++;
    }

    public T getLast() {
        // Реализуйте метод
        if (head == null)
            throw new NoSuchElementException();
        return tail.data;
    }

    public int size() {
        return this.size;
    }

     static void main() {
        HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<>();

        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(4);
        integers.addLast(5);
        integers.addFirst(1);

        System.out.println(integers.getFirst());
        System.out.println(integers.size());
        System.out.println(integers.getLast());
        System.out.println(integers.size());
    }
}
