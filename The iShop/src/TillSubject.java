public interface TillSubject {
       public void registerObserver(TillObserver o );
       public void unregisterObserver(TillObserver o );
       public void notifyObservers();

}