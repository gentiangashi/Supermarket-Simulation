import java.io.IOException;
import java.util.ArrayList;

public class Shopping {
	
    public static ArrayList<String> Basket = new ArrayList<String>();
    
    public Shopping() {}
        
    // Generates Customer Basket
    public void addToBasket() throws IOException, InterruptedException {
		Basket.clear(); 
		Products product = new Products();
		product.readProductsCSV();
		for(int i=0; i<product.getNumOfItems(); i++)
		{
			Thread.sleep(1);
			Basket.add(String.join("", product.getRandomItem()));
		}
    }
}