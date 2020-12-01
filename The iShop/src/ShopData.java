import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ShopData implements ShopSubject{
	
    private int id;
    private ArrayList<String> basket;
    
    // Can use CopyOnWriteArraySet too
    private final Set<ShopObserver> mObservers = Collections.newSetFromMap(new ConcurrentHashMap<ShopObserver, Boolean>(0));

    // This method adds a new Observer - it will be notified when Observable changes
    public void registerObserver(ShopObserver o) {
        if (o == null) return;
        mObservers.add((ShopObserver) o);} // this is safe due to thread-safe Set

    // This method removes an Observer - it will no longer be notified when Observable changes
    public void unregisterObserver(ShopObserver o)  {
        if (o != null) 
        {mObservers.remove(o);} // this is safe due to thread-safe Set
    }

    // This method notifies currently registered observers about Observable's change
    public void notifyObservers() {
        for (ShopObserver observer : mObservers) { // this is safe due to thread-safe Set
            observer.update(id, basket);
        }
    }
    
    public void measurementChanged() {
    	notifyObservers();
    }
    
    public void setMeasurements(int id, ArrayList<String> basket) {
        this.id = id;
        this.basket = basket;
        measurementChanged();
    } 
}