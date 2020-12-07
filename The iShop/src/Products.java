import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Products {
	// Encapsulation to prevent direct entry to variables
	List<List<String>> Products = new ArrayList<>();
	private static int item;
	private static double rnd;
	
	// Empty Constructor: Construct object with default values
	public Products() {}
	
	// Constructor with parameters
    public Products(List<List<String>> products)
    { this.Products = products; }
    
    public List<String> getRandomItems()
    {
    	Random randomGenerator = new Random();    	
        int index = randomGenerator.nextInt(Products.size());
        List<String> items = Products.get(index);
        return items;
    }
    
    // Products Set&Get
    public void setProducts(List<List<String>> products) { this.Products = products;}
    public List<List<String>> getProducts() {return this.Products;}
    
    // Counts how many products there are
    public int productsSize() {return Products.size();}

    static // Assigns random number of items through probability distribution
    void normalDistribution() {
		rnd = Math.random();
		if 		(rnd < 2.50/100.0)  item = 10;
		else if (rnd < 10.0/100.0) 	item = 9;
		else if (rnd < 15.0/100.0)  item = 8;
		else if (rnd < 25.0/100.0)  item = 7;
		else if (rnd < 40.0/100.0) 	item = 6;
		else if (rnd < 75.0/100.0)  item = 5;
		else if (rnd < 85.0/100.0) 	item = 4;
		else if (rnd < 90.0/100.0) 	item = 3;
		else if (rnd < 98.0/100.0)  item = 2;
		else 					 	item = 1;
		}
    
    // Returns number of items
    static int getItems(){
    	normalDistribution();
        return item;    
        } 
    
    // Check if distributions are correct
    public static String itemProbabilityCheck() {
    	int iterations=10000000;
		int[] freq = new int[10];
		double[] prob = new double[10];
		int item = 0;
		String[] output = new String[]{ 
		"Probability of 1 Item:  ",
		"Probability of 2 Items: ",
		"Probability of 3 Items: ",
		"Probability of 4 Items: ",
		"Probability of 5 Items: ",
		"Probability of 6 Items: ",
		"Probability of 7 Items: ",
		"Probability of 8 Items: ",
		"Probability of 9 Items: ",
		"Probability of 10 Items: "}; 
		
		for(int i=0;i<iterations;i++){
			normalDistribution();
	        item = getItems();
	        freq[item-1]=freq[item-1]+1;
		}
		
		System.out.println("\n---------------------------");
		
		for (int i=0;i<10;i++){
			prob[i]=freq[i]/Double.valueOf(iterations);
	        System.out.format(output[i]+"%.0f",prob[i]*100);
	        System.out.println("%");
		}
		return "---------------------------\n";
    }
    
    // Reads Products.csv and stores it into Array List   
    public void readProductsCSV() throws FileNotFoundException, IOException { 
    	try (BufferedReader file = new BufferedReader(new FileReader("groceries.csv"))) {
    	    String line;
    	    while ((line=file.readLine()).length() > 0 && ((line=file.readLine()) != null)) {
    	        String[] values = line.split(",");
    	        Products.add(Arrays.asList(values));
    	    }
    	}
    }
    
    // Testing
    // Testing
    // Testing
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	Products product = new Products();
    	itemProbabilityCheck();
    	product.readProductsCSV();
    	System.out.println("\nItems: "+product.getRandomItems());
    }
}