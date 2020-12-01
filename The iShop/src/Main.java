/**
 * @author Gentian Gashi | 14/10/2020 | Total Lines: 644
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main extends Thread {
	 
    // Global Variables
    static Shop event = new Shop();
    static volatile BlockingQueue<Customer> sharedQ = new LinkedBlockingQueue<Customer>(); 
    static volatile List<Customer> Customers = Collections.synchronizedList(new ArrayList<Customer>());
    
    // Queues   
    static volatile Queue<Customer> Queue0 = new LinkedList<Customer>();
    static volatile Queue<Customer> Queue1 = new LinkedList<Customer>();
    static volatile Queue<Customer> Queue2 = new LinkedList<Customer>();
    
    // Queue Information
    static int numOfOpenTills=0;
    static int maxQueueSize=50;

    // Simulation Clock
    static int simulationClock=10000;

	// Main Method
	public static void main(String[] args) throws InterruptedException, IOException {			
		Shop event = new Shop();
		Producer producer = new Producer(sharedQ);
		Consumer consumer = new Consumer(event,sharedQ);

		System.out.println("=============== Simulation Started ===============");
		producer.start();
		consumer.start();
		
		try{Thread.sleep(simulationClock);
		System.out.println("\n=============== Simulation Stopped ===============");
		producer.interrupt();
		consumer.interrupt();
		}   
		catch (InterruptedException e) {e.printStackTrace();}   
	}	
}