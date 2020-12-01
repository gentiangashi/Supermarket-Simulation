import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {
  private BlockingQueue<Customer> sharedQueue; 
  private Event shop;
  public Consumer(Event e, BlockingQueue<Customer> aQueue) { 
    super("[CONSUMER]"); 
    this.sharedQueue = aQueue;
    this.shop = e; 
  } 
  
	public void run() { 
		try { 
			while (true) { 
				Thread.sleep(2);
				Customer customer = sharedQueue.take();
				Ticket myTicket = shop.sellTicket();
				customer.purchaseTicket(myTicket);
				} 
			} 
		catch (InterruptedException e) { 
			System.out.println("Consumer Interrupted");} 
  } 
}