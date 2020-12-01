
class TillOperations extends Thread { 
	private int tills = 0;
	private boolean open = true;
	private int size=0;
  
	public TillOperations() 
	{ 
		//super("[Till]"); 
	}
	
	public void run() 
	{
		Till obj;
		boolean flag=true;
			while(flag) 
			{
			try 
			{ 
					obj=new Till(tills, open, size);						
					TillQueue till0 = new TillQueue();
					TillQueue till1 = new TillQueue();
					TillQueue till2 = new TillQueue();
					
					till0.start();
					till1.start();
					till2.start();					
					Thread.sleep(2); 	
					
				    if(till0.size()<=till2.size() && till0.size()<=till2.size())
				    {
				    	till0.insert(Main.sharedQ.element());
				    	till0.interrupt();
						till0.remove(Main.sharedQ.element());
				    } else if (till1.size()<=till2.size()) {
				    	till1.insert(Main.sharedQ.element());
				    	till1.interrupt();
						till1.remove(Main.sharedQ.element());
				    } else {
				    	till2.insert(Main.sharedQ.element());
				    	till2.interrupt();
						till2.remove(Main.sharedQ.element());
				    }
					
					// Observers
					//TillData tillData = new TillData();
					//TillDisplay tillView = new TillDisplay(tillData);		
					//tillData.setMeasurements(till0.size(),till1.size(),till2.size());
			}
			catch (InterruptedException e) {System.out.println("Till Interrupted");
			flag=false;} 
			} 
    }
}
