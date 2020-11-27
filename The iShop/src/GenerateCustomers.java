import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class GenerateCustomers extends TimerTask {
	
	private int shoppers = 0;
    private ArrayList<String> basket = new ArrayList<String>();
    
    public GenerateCustomers() {}
        
    // Create Shopper Threads
    @Override
    public void run() 
    {
    		try {addToBasket();} 
    		catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
            Main.customers.add(new CustomerController(shoppers, basket));
            Main.customers.get(shoppers).start();
            Main.customersCurrentlyInShop++;
            Main.totalCustomersToday++;
            shoppers++;
    }

    // Generates Customer Basket
    private void addToBasket() throws IOException {
		ProductsController product = new ProductsController();
		int iteration = product.getNumOfItems();
		product.readProductsCSV();
		basket.clear(); 
		for(int i=0; i<iteration; i++)
		{basket.add(String.join("", product.getRandomItem()));}
    }
}
