// Import the LinkedList class
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ShoppingQueue {
	ReentrantLock lock = new ReentrantLock();
	
	static volatile BlockingQueue<Customer> Queue0 = new LinkedBlockingQueue<Customer>(); 
	static volatile BlockingQueue<Customer> Queue1 = new LinkedBlockingQueue<Customer>(); 
	static volatile BlockingQueue<Customer> Queue2 = new LinkedBlockingQueue<Customer>(); 
	public Customer customer;

	//make the constructor private so that this class cannot be
	//instantiated
	public ShoppingQueue(Customer addit) throws InterruptedException{
		this.customer=addit;
		addNewCustomer(customer);
	}

	//Get the only object available
	public void addNewCustomer(Customer customer) throws InterruptedException
	{
		if(Queue0.size()<=Queue1.size() && Queue0.size()<=Queue2.size())
	    {
			Thread.sleep(customer.getBasket().size());
			Queue0.put(customer);
	    } 
		else if (Queue1.size()<=Queue2.size()) 
		{
			Thread.sleep(customer.getBasket().size());
			Queue1.put(customer);
		} 
		else 
		{
			Thread.sleep(customer.getBasket().size());
			Queue2.put(customer);
		}
	} 

	public static Queue<Customer> getQueue0()
	{return Queue0;}
	public static Queue<Customer> getQueue1()
	{return Queue1;}
	public static Queue<Customer> getQueue2()
	{return Queue2;}
}