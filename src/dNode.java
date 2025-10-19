/**
 * Represents a node in a doubly linked list.
 * <p>
 * Each node contains a reference to its data, the next node, and the previous node.
 *
 * @param <T> the type of data stored in the node
 */
public class dNode<T>{
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
