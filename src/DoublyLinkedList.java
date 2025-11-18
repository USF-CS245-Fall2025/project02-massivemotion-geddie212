/**
 * A generic implementation of a doubly linked list.
 * <p>
 * This list allows for constant-time insertion and removal from both ends,
 * and O(n) operations elsewhere. Each node maintains references to both
 * its next and previous nodes.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> implements List<T>{
    /**
     * Represents a node in a doubly linked list.
     * <p>
     * Each node contains a reference to its data, the next node, and the previous node.
     *
     * @param <T> the type of data stored in the node
     */
    private class dNode<T>{
        /** The data stored in this node. */
        private T data;
        /** The next node in the list. */
        private dNode<T> next;
        /** The previous node in the list. */
        private dNode<T> previous;
        /**
         * Constructs an empty node with {@code null} data and no connections.
         */
        public dNode(){
            this.data = null;
            this.next = null;
            this.previous = null;
        }
        /**
         * Constructs a node with the specified data.
         *
         * @param data the data to be stored in this node
         */
        public dNode(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
        /**
         * Returns the data stored in this node.
         *
         * @return the data of this node
         */
        public T getData(){
            return data;
        }
        /**
         * Sets the reference to the previous node.
         *
         * @param node the previous node
         */
        public void setPrevious(dNode<T> node){
            this.previous = node;
        }
        /**
         * Returns the reference to the next node.
         *
         * @return the next node
         */
        public dNode<T> next(){
            return this.next;
        }
        /**
         * Returns the reference to the previous node.
         *
         * @return the previous node
         */
        public dNode<T> previous(){
            return this.previous;
        }
        /**
         * Sets the reference to the next node.
         *
         * @param node the next node
         */
        public void setNext(dNode<T> node){
            this.next = node;
        }
    }
    /** Reference to the first node in the list. */
    private dNode<T> head;
    /** Reference to the last node in the list. */
    private dNode<T> tail;
    /** Number of elements in the list. */
    private int size;
    /**
     * Creates empty doubly linked list.
     */
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Inserts an element at the specified position in the list.
     *
     * @param index   the position at which the element is to be inserted
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    public void add(int index, T element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        dNode<T> node = new dNode<>(element);
        if (head == null){
            head = node;
            tail = node;
        }
        else if (index == 0){
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
        else if(index == size){
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        else{
            dNode<T> curr = head;
            for (int i = 1; i < index; i++){
                curr = curr.next();
            }
            dNode<T> successor = curr.next();
            curr.setNext(node);
            if (successor != null){
                successor.setPrevious(node);
            }
            node.setPrevious(curr);
            node.setNext(successor);
        }
        size++;
    }
    /**
     * Appends an element to the end of the list.
     *
     * @param element the element to be added
     * @return {@code true} if the element was successfully added
     */
    public boolean add(T element){
        dNode<T> node = new dNode<>(element);
        if(head == null){
            head = tail = node;
        }
        else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
        return true;
    }
    /**
     * Removes the element at the specified position in the list.
     *
     * @param index the position of the element to be removed
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            dNode<T> curr = head;
            head = head.next();
            if (head != null){
                head.setPrevious(null);
            }
            else{
                tail = null;
            }
            size--;
            return curr.getData();
        }
        else if (index == size - 1){
            dNode<T> curr = tail;
            tail = tail.previous();
            if (tail != null){
                tail.setNext(null);
            }
            else{
                head = null;
            }
            size--;
            return curr.getData();
        }
        else{
            dNode<T> curr = head;
            for (int i = 1; i < index; i++){
                curr = curr.next();
            }
            dNode<T> out = curr.next();
            dNode<T> successor = curr.next().next();
            curr.setNext(successor);
            if (successor != null){
                successor.setPrevious(curr);
            }
            size--;
            return out.getData();
        }
    }
    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            dNode<T> curr = head;
            for (int i = 0; i < index; i++){
                curr = curr.next();
            }
            return curr.getData();
        }
    }
    /**
     * Returns the number of elements in the list.
     *
     * @return the current size of the list
     */
    public int size(){
        return size;
    }
}
