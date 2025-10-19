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
