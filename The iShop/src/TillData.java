import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TillData implements TillSubject{
	
    private int t0Size;
    private int t1Size;
    private int t2Size;
    
    // Can use CopyOnWriteArraySet too
    private final Set<TillObserver> mObservers = Collections.newSetFromMap(new ConcurrentHashMap<TillObserver, Boolean>(0));

    // This method adds a new Observer - it will be notified when Observable changes
    public void registerObserver(TillObserver o) {
        if (o == null) return;
        mObservers.add((TillObserver) o);} // this is safe due to thread-safe Set

    // This method removes an Observer - it will no longer be notified when Observable changes
    public void unregisterObserver(TillObserver o)  {
        if (o != null) 
        {mObservers.remove(o);} // this is safe due to thread-safe Set
    }

    // This method notifies currently registered observers about Observable's change
    public void notifyObservers() {
        for (TillObserver observer : mObservers) { // this is safe due to thread-safe Set
            observer.update(t0Size, t1Size, t2Size);
        }
    }
    
    public void measurementChanged() {
    	notifyObservers();
    }
    
    public void setMeasurements(int t0Size, int t1Size, int t2Size) {
    	this.t0Size=t0Size;
        this.t1Size=t1Size;
        this.t2Size=t2Size;
        measurementChanged();
    } 
}