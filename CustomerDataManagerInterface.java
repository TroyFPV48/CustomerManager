/**
 * Contract for CustomerDataManager
 */
public interface CustomerDataManagerInterface {

    // Constructor should have no parameters and should throw no exceptions if the file cannot be read;
    // tell clients that they can check for customer count = 0 to check success.
    // Should be smart about where customers are added, based on their customer number.  Customers with
    // ids below 20000 go at the start; others go at the end.

    /**
     * Retrieves the count of customers in the customer list
     * @return      count of customers
     */
    public int getCustomerCount();

    /**
     * Retrieves the customer at the specified index
     * @param index     index of customer; must be a valid index in the range 0 to count - 1
     * @return          customer at requested index
     */
    public Customer getCustomer(int index);

    /**
     * Retrieves the customer with the specified id.  Implements logic to search from the front or back,
     * depending on the id's value
     * @param id            the customer id to look up
     * @return              the corresponding customer, or null if the customer isn't found
     */
    public Customer findCustomerById(String id);

    /**
     * Retrieves all customers with the specified last name, using a case-insensitive search
     * @param lastName      the customer last name to look up
     * @return              a list of customers with that last name;
     *                      list will be empty if no matching customers are found
     */
    public LinkedList<Customer> findCustomersByLastName(String lastName);

}
