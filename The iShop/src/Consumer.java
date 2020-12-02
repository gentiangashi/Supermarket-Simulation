import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Consumer extends Thread {
  private BlockingQueue<Customer> sharedQueue; 
  private volatile boolean running = true;
  private Shop shop;
  ReentrantLock lock = new ReentrantLock();
  
  public Consumer(Shop e, BlockingQueue<Customer> aQueue) {
	  this.sharedQueue = aQueue;
	  this.shop = e;
   } 
  
	public void run() { 
		while(running) { 
			lock.lock();
			try{
				Thread.sleep(30);
				Customer customer = sharedQueue.take();
				ShopEntry myTicket = shop.sellTicket();
				customer.purchaseTicket(myTicket);
				removeQueue();
				} 
			catch (InterruptedException | IOException e) {System.out.println("Shutting down consumer thread...");
			running = false;
			}
			finally {lock.unlock();}
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