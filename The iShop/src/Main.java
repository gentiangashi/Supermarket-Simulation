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
	
    // Queue Information
    static int numOfOpenTills=0;
    static int maxQueueSize=50;
    
    static int customersCurrentlyInShop=0;
    // Simulation Clock
    static int simulationClock=10000;
    
    static Event event = new Event();
    static volatile BlockingQueue<Customer> sharedQ = new LinkedBlockingQueue<Customer>(); 

    
	// Main Method
	public static void main(String[] args) throws InterruptedException, IOException {	  
		Event event = new Event();
		Producer producer = new Producer(sharedQ);
		Consumer consumer = new Consumer(event,sharedQ);
		TillOperations till = new TillOperations();
		System.out.println("=============== Simulation Started ===============\n");
		producer.start();
		consumer.start();
		till.start();
		try{Thread.sleep(simulationClock);
		producer.interrupt();
		consumer.interrupt();
		till.interrupt();}
		catch (InterruptedException e) {e.printStackTrace();} 
		System.out.println("\n=============== Simulation Stopped ===============");    
	}	
}