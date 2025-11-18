/**
 * A generic dynamic array implementation that mimics the functionality of Java's built-in ArrayList.
 *
 * @param <T> the type of elements stored in the array list
 */
public class ArrayList<T> implements List<T>{
    /** The underlying array storing elements. */
    private T[] array;
    /** The number of elements currently stored in the array list. */
    private int size;
    /**
     * Constructs an empty ArrayList with an initial capacity of 10.
     */
    @SuppressWarnings("unchecked")
    public ArrayList(){
        array = (T[]) new Object[10];
        size = 0;
    }
    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            return array[index];
        }
    }
    /**
     * Returns the number of elements currently in the list.
     *
     * @return the number of elements in the list
     */
    public int size(){
        return size;
    }
    /**
     * Inserts an element at the specified index, shifting subsequent elements to the right.
     *
     * @param index   the position to insert the element at
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is invalid (index < 0 || index >= size)
     */
    public void add (int index, T element) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index can't be negative or bigger than capacity");
        }
        else{
            checkCapacity();
            for (int i = size; i > index; i--){
                array[i] = array[i-1];
            }
            array[index] = element;
            size++;
        }
    }
    /**
     * Appends an element to the end of the list.
     *
     * @param element the element to add
     * @return {@code true} if the element was successfully added
     */
    public boolean add (T element) {
        try{
            size++;
            checkCapacity();
            array[size-1] = element;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is invalid (index < 0 || index >= size)
     */
    public T remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index can't be negative or bigger than capacity");
        }
        else{
            T temp =  array[index];
            for (int i = index; i < size - 1; i++){
                array[i] =  array[i+1];
            }
            size--;
            return temp;
        }
    }
    /**
     * Checks whether the underlying array has enough capacity to add more elements.
     * If not, it will grow the array.
     */
    private void checkCapacity(){
        if (size == array.length){
            grow();
        }
    }
    /**
     * Doubles the capacity of the underlying array when more space is needed.
     */
    @SuppressWarnings("unchecked")
    private void grow(){
        T[] newArray = (T[]) new Object[array.length*2];
        for (int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
