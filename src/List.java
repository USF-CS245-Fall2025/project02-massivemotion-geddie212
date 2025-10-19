/**
 * A generic interface that defines the basic operations for a list data structure.
 * <p>
 * Implementing classes must support dynamic storage and retrieval of elements
 * based on their position in the list.
 *
 * @param <T> the type of elements held in the list
 */
public interface List<T> {
    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   the index at which the element is to be inserted
     * @param element the element to insert
     */
    public void add (int index, T element);
    /**
     * Appends the specified element to the end of this list.
     *
     * @param element the element to be appended
     * @return {@code true} if the element was successfully added
     */
    public boolean add (T element);
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     */
    public T get (int index);
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    public T remove (int index);
    /**
     * Returns the number of elements in this list.
     *
     * @return the size of the list
     */
    public int size ();
}
