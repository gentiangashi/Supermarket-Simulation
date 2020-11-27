import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationClock  extends TimerTask {
    private final AtomicInteger counter = new AtomicInteger(0);
    
    public int getValue() {
        return counter.get();
    }
    
    @Override
    public void run() 
    {
    	counter.getAndIncrement();
    	// Debug
    	//System.out.println("Current value: " + counter); 
    }
}