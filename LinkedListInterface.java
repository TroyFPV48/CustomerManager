public interface LinkedListInterface<E> {

    /**
     * Retrieves a matching existing value, given a search value.
     * While this may seem odd, we need to remember that "matching" might mean
     * different things to different clients, and that sometimes a dummy lookup
     * object can contain little information, perhaps only an ID, that can serve
     * as a lookup for the existing element of interest
     *
     * @param value     the value to look up
     * @return          a reference to an existing element, or null if not found
     */
    public E get(E value);

    /**
     * Retrieves a matching existing value, given a search value and whether to start from the
     * beginning or end of the list (for faster searches)
     *
     * @param value             the value to look up
     * @param searchFromBack    true, to start searching from the back of the list; false, if typical start search
     * @return                  a reference to an existing element, or null if not found
     */
    public E get(E value, boolean searchFromBack);

    /**
     * Retrieves the index of a value that is equal to the specified one.  Can search from both the start of the list
     * (typical, in a linked list) or from the back of the list, to speed up searching
     * @param value             value to look up
     * @param searchFromBack    true, to start at the end of the list; false, for typical start-of-list search
     * @return                  index of the first matching value, or -1 if not found
     */
    public int indexOf(E value, boolean searchFromBack);

    /**
     * Retrieves whether the list contains the specified value.  Can start from the end of the list to speed up
     * searches, to improve performance.
     *
     * @param value             value to search for
     * @param startAtBack       true, to search from the end; false, from the beginning
     * @return                  true, if a match is found; false, if not
     */
    public boolean contains(E value, boolean startAtBack);

    /**
     * Adds a value at the end of the list, without traversing the list (which makes it lightning fast)
     * @param value     value to add to the list
     */
    public void addAtEnd(E value);


}
