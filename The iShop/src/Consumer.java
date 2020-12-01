import java.io.IOException;
import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {
  private BlockingQueue<Customer> sharedQueue; 
  private Shop shop;
  
  public Consumer(Shop e, BlockingQueue<Customer> aQueue) {
	  this.sharedQueue = aQueue;
	  this.shop = e;
   } 
  
	public void run() { 
		try { 
			while (true) { 
				Thread.sleep(1);
				Customer customer = sharedQueue.take();
				Ticket myTicket = shop.sellTicket();
				customer.purchaseTicket(myTicket);
				removeQueue();
				} 
			} 
		catch (InterruptedException | IOException e) {System.out.println("Consumer Interrupted");} 
  } 		
	
	public void removeQueue() throws InterruptedException, IOException 
	{ 
		Thread.sleep(20);
		try {
			Thread.sleep(Main.Queue0.peek().getBasket().size());
			Main.Queue0.remove();}
		catch (Exception e) {System.out.println("ERROR: Queue 0 is Empty");} 
			
		try {
			Thread.sleep(Main.Queue1.peek().getBasket().size());
				Main.Queue1.remove();}
		catch (Exception e) {System.out.println("ERROR: Queue 1 is Empty");} 
			
		try {
			Thread.sleep(Main.Queue2.peek().getBasket().size());
			Main.Queue2.remove();}
		catch (Exception e) {System.out.println("ERROR: Queue 2 is Empty");} 
    		
		// Observers
		TillData tillData = new TillData();
		TillDisplay tillView = new TillDisplay(tillData);		
		tillData.setMeasurements(Main.Queue0.size(),Main.Queue1.size(),Main.Queue2.size());
	}
}