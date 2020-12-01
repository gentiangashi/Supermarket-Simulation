import java.util.ArrayList;

public class ShopDisplay implements ShopObserver, ShopDisplayElement{

       private int id;
       private ArrayList<String> basket;
       private ShopSubject managerData;

       //Now we get sneaky weatherData Subject so it is registered as observer
       public ShopDisplay (ShopSubject managerData) {
              this.managerData = managerData;
              managerData.registerObserver(this);
       }

       public void update(int id, ArrayList<String> basket) {
              this.id=id;
              this.basket = basket;
              displayShop();
       }

       public void displayShop() {
              System.out.println("\n[CUSTOMER " + id +"]" + " Has Walked In" + " [BASKET] " + basket.toString().replaceAll("(^\\[|\\]$)", ""));
       }
}