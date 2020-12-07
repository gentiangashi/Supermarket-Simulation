import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Consumer extends Thread {
  private BlockingQueue<Customer> sharedQueue; 
  private volatile boolean finished = false;
  private Shop shop;
  ReentrantLock lock = new ReentrantLock();
  
  public Consumer(Shop e, BlockingQueue<Customer> aQueue) {
	  this.sharedQueue = aQueue;
	  this.shop = e;
   } 
  
  	@Override
	public void run() { 
		while(!finished && !sharedQueue.isEmpty()) { 
			try{
				Customer customer = sharedQueue.take();
				ShopEntry myTicket = shop.sellTicket();
				customer.purchaseTicket(myTicket);
				Thread.sleep(1);
				removeQueue();
				
				// Safely ends thread using poison pill
				if(customer.equals(Main.POISON_PILL)) 
				{finished = true;}
			}				
			catch (InterruptedException | IOException e) {System.out.println("Shutting down consumer thread...");
			finished = true;}
		}
  } 		
	
	public synchronized void removeQueue() throws InterruptedException, IOException 
	{ 
		try {
			Thread.sleep(ShoppingQueue.getQueue0().peek().getBasket().size());
			((BlockingQueue<Customer>) ShoppingQueue.getQueue0()).take();}
		catch (Exception e) {System.out.println("ERROR: Queue 0 is Empty");} 
			
		try {
			Thread.sleep(ShoppingQueue.getQueue1().peek().getBasket().size());
			((BlockingQueue<Customer>) ShoppingQueue.getQueue1()).take();}
		catch (Exception e) {System.out.println("ERROR: Queue 1 is Empty");} 
			
		try {
			Thread.sleep(ShoppingQueue.getQueue2().peek().getBasket().size());
			((BlockingQueue<Customer>) ShoppingQueue.getQueue2()).take();}
		catch (Exception e) {System.out.println("ERROR: Queue 2 is Empty");} 
	}
}