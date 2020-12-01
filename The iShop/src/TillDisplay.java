public class TillDisplay implements TillObserver, TillDisplayElement{

       private int t0Size;
       private int t1Size;
       private int t2Size;
       private TillSubject tillData;

       //Now we get sneaky weatherData Subject so it is registered as observer
       public TillDisplay (TillSubject tillData) {
              this.tillData = tillData;
              tillData.registerObserver(this);
       }

       public void update(int t0Size, int t1Size, int t2Size) {
              this.t0Size=t0Size;
              this.t1Size=t1Size;
              this.t2Size=t2Size;
              displayTill();
       }

       public void displayTill() {
              System.out.println("\n[Till 0]" + " [Queue Size] " + t0Size);
              System.out.println("[Till 1]" + " [Queue Size] " + t1Size);
              System.out.println("[Till 2]"  + " [Queue Size] " + t2Size);
       }
}