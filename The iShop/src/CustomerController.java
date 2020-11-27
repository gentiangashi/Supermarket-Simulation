/**
 * @author Gentian Gashi | 14/10/2020
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class CustomerController extends Thread {
		
	// Encapsulation to prevent direct entry to variables
	private int ID=0;
	List<String> Basket = new ArrayList<String>();
	public boolean running;
   
	// Empty Constructor: Construct object with default values
    public CustomerController() { }
   
	// Constructor with parameters
    public CustomerController(int id, List<String> basket)
    {
    	this.ID = id;
    	this.Basket = basket;
     }
	
    public void countCustomers() {Main.customers.size();}
    
    @Override
    public void run() 
    {
    	//System.out.println("This is currently running on a customer thread, " + "the ID is: " + Thread.currentThread().getId());  
    	this.running = true;
        try {
        	browse();     
        	queue();
            System.out.println("[CUSTOMER]: " + ID + " Basket: " + Basket.toString());
        }

        	//System.out.println("[TILL 1] Queue Size:  " + queue());} 
        catch (InterruptedException e) {Thread.currentThread().interrupt();}
    }
    
    private void browse() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 2000));        }
    
    private void queue() {}

}     



