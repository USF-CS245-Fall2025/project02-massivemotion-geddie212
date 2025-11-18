/**
 * A simple singly linked list implementation of the {@code List<T>} interface.
 * <p>
 * Supports generic types and provides basic operations such as add, get, remove,
 * and retrieving the size of the list.
 * </p>
 *
 * @param <T> the type of elements stored in the list
 */
public class LinkedList<T> implements List<T>{

    /**
     * A generic node class used in linked list and dummyhead list implementations.
     *
     * @param <T> the type of data stored in the node
     */
    private class Node<T> {
        /**
         * The data stored in this node.
         */
        private T data;
        /**
         * Reference to the next node in the list.
         */
        private Node<T> next;
        /**
         * Constructs an empty node with null data and no next reference.
         */
        public Node() {
            this.data = null;
            this.next = null;
        }
        /**
         * Constructs a node with the specified data and no next reference.
         *
         * @param data the data to store in the node
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        /**
         * Returns the data stored in this node.
         *
         * @return the data stored in the node
         */
        public T getData(){
            return this.data;
        }
        /**
         * Returns the next node in the list.
         *
         * @return the next node reference
         */
        public Node<T> next(){
            return this.next;
        }
        /**
         * Sets the next node in the list.
         *
         * @param node the node to set as next
         */
        public void setNext(Node<T> node){
            this.next = node;
        }
    }

    /** The first node in the list. */
    private Node<T> head;
    /** The last node in the list. */
    private Node<T> tail;
    /** The number of elements in the list. */
    private int size;
    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Adds an element at the specified index in the list.
     *
     * @param index   the index at which the element should be inserted
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node  = new Node<>(element);
        if (index == 0) {
            node.setNext(head);
            head = node;
            if (size == 0) {
                tail = node;
            }
        }
        else if (index == size) {
            tail.setNext(node);
            tail = tail.next();
        }
        else {
            int count = 1;
            Node<T> curr = head;
            while (curr.next() != null){
                if (count == index){
                    Node<T> temp = curr.next();
                    curr.setNext(node);
                    node.setNext(temp);
                    break;
                }
                curr = curr.next();
            }
            if (index == size){
                tail = node;
            }
        }
        size++;
    }
    /**
     * Appends the specified element to the end of the list.
     *
     * @param element the element to add
     * @return {@code true} (as specified by the {@code Collection} interface)
     */
    public boolean add(T element) {
        if (head == null) {
            head = new Node<>(element);
            tail = head;
        }
        else{
            tail.setNext(new Node<>(element));
            tail = tail.next();
        }
        size++;
        return true;
    }
    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            int counter = 0;
            Node<T> curr = head;
            while (curr != null){
                if (counter == index){
                    return curr.getData();
                }
                curr = curr.next();
                counter++;
            }
            return null;
        }
    }
    /**
     * Removes and returns the element at the specified index.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<T> curr = head;
            if (index == 0) {
                head = head.next();
                size--;
                return curr.getData();
            }
            else {
                int count = 1;
                while (curr.next() != null){
                    if (count == index){
                        Node<T> temp = curr.next();
                        curr.setNext(curr.next().next());
                        size--;
                        if (count == size){
                            tail = curr;
                        }
                        return temp.getData();
                    }
                    curr = curr.next();
                }
                return null;
            }
        }
    }
    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size(){
        return size;
    }

}
