import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerDataManager implements CustomerDataManagerInterface{
	private String ctmPath = "/Users/h0rnypony/Desktop/AD300/Project3_TuongPham/Customers.txt"; //Customer.txt pathname
	LinkedList<Customer> customer = new LinkedList<>();//create a linked list object of Customer data type
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDataManager CDM = new CustomerDataManager();
		System.out.println("Get customer count: "+CDM.getCustomerCount());
		//Get customer count: 1000
		System.out.println("--------------");
		System.out.println("Get customer at index 3: \n"+CDM.getCustomer(3));
		//Get customer at index 3: 
		//Student: Jolee McManamon
		//ID: 25902
		//Email: jmcmanamon3@cbsnews.com
		//Balance: 7833.61
		System.out.println("--------------");
		System.out.println("Find customer by ID of 10628: \n"+CDM.findCustomerById("10628"));
		//Find customer by ID of 10628: 
		//Student: Coriss Hughf
		//ID: 10628
		//Email: chughfa8@yahoo.com
		//Balance: 12088.82
		System.out.println("--------------");
		System.out.println("Find customer by last name of Giorgeschi: \n"+CDM.findCustomersByLastName("Giorgeschi"));
		//Find customer by last name of McManamon: 
		//[Student: Denni Giorgeschi
		//ID: 25395
		//Email: dgiorgeschin@time.com
		//Balance: 5126.93, Student: Sigrid Giorgeschi
		//ID: 25660
		//Email: sgiorgeschigj@nsw.gov.au
		//Balance: 8534.89]
	}

	
	public CustomerDataManager() {
		
		Scanner scCustomer = null; 
		
		try {
			scCustomer = new Scanner(new File(ctmPath));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scCustomer.nextLine(); //skip first line from text file
		
		while(scCustomer.hasNextLine()) {
			String line = scCustomer.nextLine(); 
			String[] tempArray1 = line.split(","); //splitting text by comma and store them to String array
			if(Integer.parseInt(tempArray1[0]) < 20000) {
				customer.addAtFront(new Customer(tempArray1[0],tempArray1[1],tempArray1[2],tempArray1[3],Double.parseDouble(tempArray1[4])));
			}else {
			customer.add(new Customer(tempArray1[0],tempArray1[1],tempArray1[2],tempArray1[3],Double.parseDouble(tempArray1[4])));	
			}
		}
		
	}
	
	@Override
	 /**
     * Retrieves the count of customers in the customer list
     * @return      count of customers
     */
	public int getCustomerCount() {
		// TODO Auto-generated method stub
		return customer.size();
	}

	@Override
	/**
     * Retrieves the customer at the specified index
     * @param index     index of customer; must be a valid index in the range 0 to count - 1
     * @return          customer at requested index
     */
	public Customer getCustomer(int index) {
		// TODO Auto-generated method stub
		return customer.getIndex(index);
	}

	@Override
	  /**
     * Retrieves the customer with the specified id.  Implements logic to search from the front or back,
     * depending on the id's value
     * @param id            the customer id to look up
     * @return              the corresponding customer, or null if the customer isn't found
     */
	public Customer findCustomerById(String id) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(id) < 20000) {			
            for (int i = 0; i < customer.size(); i++) {               
                if(customer.getIndex(i).id().equalsIgnoreCase(id)) {
                	return customer.getIndex(i);
                }
            }//search from front
		}else { //search from back
			 for (int i = customer.size() - 1; i >= 0; i--) {               
	                if(customer.getIndex(i).id().equalsIgnoreCase(id)) {
	                	return customer.getIndex(i);
	                }
			 }
		}
		return null; //null if not found
		
	}

	@Override
	  /**
     * Retrieves all customers with the specified last name, using a case-insensitive search
     * @param lastName      the customer last name to look up
     * @return              a list of customers with that last name;
     *                      list will be empty if no matching customers are found
     */
	public LinkedList<Customer> findCustomersByLastName(String lastName) {
		// TODO Auto-generated method stub
		LinkedList<Customer> list = new LinkedList<>();
		for (int i = 0; i < customer.size(); i++) { //search from front              
            if(customer.getIndex(i).lastname().equalsIgnoreCase(lastName)) { //at front if list is null or empty            	
            	   list.add(customer.getIndex(i));           	
            }
        }
		return list;
	}

}
