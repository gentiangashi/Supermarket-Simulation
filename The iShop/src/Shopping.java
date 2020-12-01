import java.io.IOException;
import java.util.ArrayList;

public class Shopping {
	
	boolean doneShopping = false;
    public static  ArrayList<String> Basket = new ArrayList<String>();
    
    public Shopping() {}
        
    // Generates Customer Basket
    public void addToBasket() throws IOException, InterruptedException {
		ProductsController product = new ProductsController();
		int iteration = product.getNumOfItems();
		product.readProductsCSV();
		Basket.clear(); 
		for(int i=0; i<iteration; i++)
		 Thread.sleep(1);
		{Basket.add(String.join("", product.getRandomItem()));}
		doneShopping = true;
    }
}