public interface ShopSubject {
       public void registerObserver(ShopObserver o );
       public void unregisterObserver(ShopObserver o );
       public void notifyObservers();

}