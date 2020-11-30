import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationClock  extends TimerTask {
    private AtomicInteger clock = new AtomicInteger(0);
      
    @Override
    public void run() {
    	clock.incrementAndGet();
    	// Debug
    	//System.out.println("Current value: " + clock); 
    }
    
    public void decrement() {
    	clock.decrementAndGet();
      }
    
    public synchronized int get() {
        return clock.get();
    }
}