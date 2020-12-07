import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Producer extends Thread { 
	ReentrantLock lock = new ReentrantLock();
	private BlockingQueue<Customer> sharedQueue;
	private int shoppers = 0;
	private volatile boolean finished = false;
  
	public Producer(BlockingQueue<Customer> aQueue) 
	{this.sharedQueue = aQueue;} 
	
  	@Override
	public void run() {
		Customer obj;
		while(!finished) { 
			try { 		  
					Thread.sleep(1);
					Shopping shopping = new Shopping();
					try {shopping.addToBasket();} catch (IOException e1) {e1.printStackTrace();}
					obj=new Customer(shoppers, Shopping.Basket);
					//System.out.println(obj.getID() +""+ obj.getBasket());
					sharedQueue.put(obj); 
					
					ShoppingQueue model = new ShoppingQueue(obj);								
					//Create a view : to write customer details on console
					CustomerView customerView = new CustomerView();
					CustomerView2 QueueView = new CustomerView2();
					CustomerController controller = new CustomerController(model, customerView, QueueView);
					controller.updateCustomerView();	
					controller.updateQueueView();
					shoppers++;
					//read.sleep(100);
				} 
			catch (InterruptedException e) {System.out.println("\nShutting down producer thread...");
			// Signals end of producer
			try {sharedQueue.put(Main.POISON_PILL);} catch (InterruptedException e1) {e1.printStackTrace();}
			finished=true;
      } 
    } 
  } 	
}