package collectionsframework.iterable.collection.sequenced.list.linkedlist;

public class SinglyLinkedList<T> {

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("привет");
        singlyLinkedList.add("null");
        System.out.println(singlyLinkedList.get(1));        
    }
    
    private Node<T> head; // хранит ссылку на первый объект узел (Node) в куче (Heap).
    private int size = 0;  // количества элементов в списке

    public void add(T data) {
        Node<T> newNode = new Node<>(data); // новый добавленный объект

        // для самого первого объекта 
        if (head == null) { // SinglyLinkedList(head) никуда не ссылается
            head = newNode; // даём ему ссылку на первый добавленный объект 

        // для последующих
        } else {
            Node<T> current = head; // сохряняем ссылку что бы первоночальную не потерять
            while (current.next != null) { // условие : пока поле объекта не равно null
                current = current.next; // пока есть ссылка в поле переходим к следующему объекту 
            }
            current.next = newNode; // как только нашли объект где поле next == null записываем новую ссылку на только что добавленный элемент
        }
        size++; // после добавления увеличиваем размер
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        } 

        Node<T> newNode = new Node<>(data); 

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
           Node<T> prev = get(index - 1);
           newNode.next = prev.next;      
           prev.next = newNode;
        }
        
        size++; 
    }



    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int size(){
        return size;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        } 

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        } 

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> prev = get(index - 1);  // сугубо говоря лучше цикл ради скорости выполнения
            prev.next = prev.next.next;
        }

        size--;
    }

    

 
}

class Node <T> { // вагончик

    public T data; // груз
    public Node<T> next; // ссылка на следующий вагон
    
    public Node(T data) { 
        this.data = data;
        this.next = null; //он смотрит в никуда, то есть в null
    }

    @Override 
    public String toString(){
        return "Node.data: [" + data + "]";
    }
} 


