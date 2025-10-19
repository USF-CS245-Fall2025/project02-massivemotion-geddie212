/**
 * A generic node class used in linked list and dummyhead list implementations.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
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
