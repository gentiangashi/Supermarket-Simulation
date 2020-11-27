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

public class Main extends Thread {
	//Global Static Variables
    static volatile List<CustomerController> customers = Collections.synchronizedList(new ArrayList<CustomerController>());
	static volatile List<CustomerController> tills = Collections.synchronizedList(new ArrayList<CustomerController>());
    
    // Customer Information
    static int customersCurrentlyInShop = 0;
    static int totalCustomersToday = 0;
    static int numOfshoppers=0;
    
    // Queue Information
    static int numOfOpenTills=0;
    static int maxQueueSize=50;
    
    // Simulation Clock
    static int simulationClock=24000;
    
	// Main Method
	public static void main(String[] args) throws InterruptedException, IOException {
        // Create Timers
        TimerTask generateCustomers = new GenerateCustomers(); 
    	TimerTask Clock = new SimulationClock(); 
    	
    	// Run Timers As Daemon
        Timer generate = new Timer(true); 
        Timer clock = new Timer(true); 
        
        // Start Simulation
        int delay = (5 + new Random().nextInt(5)) * 500;
        generate.schedule(generateCustomers,1000,delay);
        clock.schedule(Clock, 1000,1000); 	
		System.out.println("========== Simulation Started ==========");

		// Halt Main Class Thread
        try {Thread.sleep(simulationClock);} 
        catch (InterruptedException e) {e.printStackTrace();}
        
        // Stop Simulation
        generate.cancel();
        clock.cancel();
        System.out.println("========== Simulation Stopped ==========");
        try {Thread.sleep(3000);} 
        catch (InterruptedException e) {e.printStackTrace();}
	}	
}