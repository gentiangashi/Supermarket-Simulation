import java.io.IOException;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread { 
	private BlockingQueue<Customer> sharedQueue;
	private int shoppers = 0;
  
	public Producer(BlockingQueue<Customer> aQueue) { 
		super("[PRODUCER]"); 
		this.sharedQueue = aQueue; 
	} 
    
	public void run() {
		Customer obj;
		boolean flag=true;
		while(flag) { 
			try { 		  
				  
					Shopping shopping = new Shopping();
					try {shopping.addToBasket();} catch (IOException e1) {e1.printStackTrace();}
					obj=new Customer(shoppers, Shopping.Basket);
					sharedQueue.put(obj); 

					// Observers
					ShopData shopData = new ShopData();
					ShopDisplay view = new ShopDisplay(shopData);		
					shopData.setMeasurements(obj.getID(), obj.getBasket());
					
					Main.customersCurrentlyInShop++;
					shoppers++;
					Thread.sleep(1); 
				} 
			catch (InterruptedException e) {System.out.println("Producer Interrupted");
			flag=false;
      } 
    } 
  } 
	
}