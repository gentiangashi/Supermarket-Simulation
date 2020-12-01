import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Producer extends Thread { 
	ReentrantLock lock = new ReentrantLock();
	private BlockingQueue<Customer> sharedQueue;
	private int shoppers = 0;
  
	public Producer(BlockingQueue<Customer> aQueue) 
	{this.sharedQueue = aQueue;} 
    
	public void run() {
		Customer obj;
		boolean flag=true;
		while(flag) { 
			lock.lock();
			try { 		  
				  
					Shopping shopping = new Shopping();
					try {shopping.addToBasket();} catch (IOException e1) {e1.printStackTrace();}
					Main.Customers.add(new Customer(shoppers, Shopping.Basket));
					obj=new Customer(shoppers, Shopping.Basket);
					sharedQueue.put(obj); 

					if(Main.Queue0.size()<=Main.Queue1.size() && Main.Queue0.size()<=Main.Queue2.size())
				    {Main.Queue0.add(obj);} 
					else if (Main.Queue1.size()<=Main.Queue2.size()) 
					{Main.Queue1.add(obj);} 
					else {Main.Queue2.add(obj);}

					shoppers++;
										
					// Observers
					//ShopData shopData = new ShopData();
					//ShopDisplay view = new ShopDisplay(shopData);		
					//shopData.setMeasurements(obj.getID(), obj.getBasket());
				} 
			catch (InterruptedException e) {System.out.println("Producer Interrupted");
			flag=false;
      } 
			finally {lock.unlock();}
    } 
  } 	
}