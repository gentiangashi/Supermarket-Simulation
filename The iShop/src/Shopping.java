import java.io.IOException;
import java.util.ArrayList;

public class Shopping {
	
    public static ArrayList<String> Basket = new ArrayList<String>();
    
    public Shopping() {}
        
    // Generates Customer Basket
    public void addToBasket() throws IOException, InterruptedException {
		Products product = new Products();
		product.readProductsCSV();
		Basket.clear(); 
		Basket.addAll(product.getRandomItems());
		Thread.sleep(Basket.size());
    }
}