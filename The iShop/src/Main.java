/**
 * @author Gentian Gashi | 14/10/2020
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main extends Thread {
	//Global Static Variables
	static volatile List<Customer> tills = Collections.synchronizedList(new ArrayList<Customer>());
     
    // Queue Information
    static int numOfOpenTills=0;
    static int maxQueueSize=50;
    
    static int customersCurrentlyInShop=0;
    // Simulation Clock
    static int simulationClock=10000;
    
	// Main Method
	public static void main(String[] args) throws InterruptedException, IOException {
	      Event event = new Event();
	      BlockingQueue<Customer> sharedQ = new LinkedBlockingQueue<Customer>(); 
	      Producer p = new Producer(sharedQ);
	      Consumer c = new Consumer(event,sharedQ);
	      
	      System.out.println("=============== Simulation Started ===============");
	      p.start();
	      c.start();
	      
	      try{Thread.sleep(simulationClock);
	       p.interrupt();
	       c.interrupt();}
	      catch (InterruptedException e) {e.printStackTrace();} 
	      System.out.println("\n=============== Simulation Stopped ===============");
	      
	}	
}