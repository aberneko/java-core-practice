package collectionsframework.iterable.collection.sequenced.list.linkedlist;

//Обе операции addFirst(T) и addLast(T) работают за константное время O(1). 

public class LinkedListDemo<T> {

    public static class Node <T> { // вагончик

        private T data; // груз
        public Node<T> next; // ссылка на следующий вагон
        public Node<T> prev; // сылка на предыдeущий элемент
    
        public Node(T data) { 
            this.data = data;
            this.next = null; //он смотрит в никуда, то есть в null
            this.prev = null;
        }

        public T getData() {
            return data;
        }

        @Override 
        public String toString() {
            return "Node.data: [" + getData() + "]";
        }
    }

    private Node<T> head; // голова
    private Node<T> tail; // хвост
    private int size = 0; // размер
   

    public static void main(String[] args) {
        LinkedListDemo<String> linkedListDemo = new LinkedListDemo<>();
        linkedListDemo.add("привет");
        linkedListDemo.add("null");
        System.out.println(linkedListDemo.get(1));        
    }
      

    public void add(T data) {
        Node<T> newNode = new Node<>(data); 

        if (head == null) { 
            head = newNode; 
            tail = newNode; 
        } else {
            newNode.prev = tail; // новый узел ссылается назад на старый хвост
            tail.next = newNode; // старый хвост ссылается вперед на новый узел
            tail = newNode; // переносим указатель tail на новый узел
        }
        size++; 
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        } 

        Node<T> newNode = new Node<>(data); 

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
           Node<T> prev1 = get(index - 1); // левый элемент
           Node<T> nextNode = prev1.next; // правый элемент
           newNode.next = nextNode; // ссылка на правого
           newNode.prev = prev1; // ссылка не левого
           prev1.next = newNode;
           nextNode.prev = newNode;
        }
        size++; 
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode; // новая голова;
        }

        size++; 
    }


    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current);
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

    // # работают за константу O(1)
    public T getFirst(){
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        } 

        if (index == 0) {
            head = head.next;
            if(head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> currNode = get(index - 1);     // элемент перед 
            Node<T> nodeToRemove = currNode.next;  // удалить
            Node<T> nextNode = nodeToRemove.next;  // элемент после

            currNode.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = currNode;
            }
        }

    }

    // Сложность этих операций — O(1)

    public void removeFirst() {
        head = head.next;
        if(head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
    }

    
    public void remove(T data) {

    }
}





