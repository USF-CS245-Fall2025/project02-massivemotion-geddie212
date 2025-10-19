/**
 * A singly linked list implementation that uses a dummy head node to simplify list operations.
 * @param <T> the type of elements stored in the list
 */
public class DummyHeadLinkedList<T>  implements List<T> {
    /** First node of the list (after the dummy node). */
    private Node<T> head;
    /** Last node of the list. */
    private Node<T> tail;
    /** Number of elements in the list. */
    private int size;
    /** Dummy head node, which simplifies head operations. */
    private Node<T> dummy;
    /**
     * Constructs an empty DummyHeadLinkedList.
     */
    public DummyHeadLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.dummy = new Node<>(null);
    }
    /**
     * Inserts an element at the specified position in the list.
     *
     * @param index   the index at which to insert the element
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds (index < 0 || index > size)
     */
    public void add(int index, T element){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node <T> node = new Node<>(element);
        if (head == null){
            dummy.setNext(node);
            head = dummy.next();
            tail = head;
        }
        else if (index == size){
            tail.setNext(node);
            tail = tail.next();
        }
        else {
            Node <T> curr = head;
            for (int i = 1; i < index; i++){
                curr = curr.next();
            }
            curr.setNext(node);
            node.setNext(curr.next().next());
        }
        size++;
    }
    /**
     * Appends an element to the end of the list.
     *
     * @param element the element to add
     * @return {@code true} if the element was successfully added
     */
    public boolean add(T element){
        if (head == null){
            head = new Node<>(element);
            dummy.setNext(head);
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
     * Returns the element at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node <T> curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next();
        }
        return curr.getData();
    }
    /**
     * Removes the element at the specified index from the list.
     *
     * @param index the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            Node<T> temp = head;
            head = head.next();
            dummy.setNext(head);
            size--;
            return temp.getData();
        }
        else{
            Node <T> curr = head;
            for (int i = 1; i < index; i++){
                curr = curr.next();
            }
            Node<T> temp = curr.next();
            curr.setNext(curr.next().next());
            if (curr.next() == null){
                tail = curr;
            }
            size--;
            return temp.getData();
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
