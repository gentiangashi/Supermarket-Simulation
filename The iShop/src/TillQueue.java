import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gentian Gashi | 14/10/2020
 *
 */
class TillQueue extends Thread{
	static volatile List<Customer> tills = Collections.synchronizedList(new ArrayList<Customer>());
	
    //Queue that holds the shoppers at this till 
	public TillQueue()      
    {}

	public void insert(Customer customer )  
    { tills.add(customer); }

    public void remove(Customer customer)        
    {tills.remove(customer);}

    public Customer peek()     
    {return tills.get(0);}

    public int size()
    { return tills.size();}
}
