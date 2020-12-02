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
	private int numOfItems;
	private double rnd;
	// Empty Constructor: Construct object with default values
	public Products() {}
	
	// Constructor with parameters
    public Products(List<List<String>> products)
    { this.Products = products; }
    
    public List<String> getRandomItem()
    {
    	Random randomGenerator = new Random();
    	
        int index = randomGenerator.nextInt(Products.size());
        List<String> item = Products.get(index);
        return item;
    }
    
    // Products Set&Get
    public void setProducts(List<List<String>> products) { this.Products = products;}
    public List<List<String>> getProducts() {return this.Products;}
    
    // Counts how many products there are
    public int productsSize() {return Products.size();}

    // Assigns random number of items through probability distribution
    void rollItem() {
		rnd = Math.random();
		if 		(rnd < 5.0/100.0)   numOfItems = 6;
		else if (rnd < 25.0/100.0) 	numOfItems = 5;
		else if (rnd < 65.0/100.0)  numOfItems = 4;
		else if (rnd < 75.0/100.0)  numOfItems = 3;
		else if (rnd < 95.0/100.0) 	numOfItems = 2;
		else					    numOfItems = 1;
		}
    
    // Returns number of items
    int getNumOfItems(){
    	rollItem();
        return numOfItems;    
        } 
    
    // Check if distributions are correct
    public String itemProbabilityCheck() {
    	int iterations=10000000;
		int[] freq = new int[6];
		double[] prob = new double[6];
		int item = 0;
		String[] output = new String[]{ 
		"Probability of 1 Item:  ",
		"Probability of 2 Items: ",
		"Probability of 3 Items: ",
		"Probability of 4 Items: ",
		"Probability of 5 Items: ",
		"Probability of 6 Items: "}; 
		
		for(int i=0;i<iterations;i++){
			rollItem();
	        item = getNumOfItems();
	        freq[item-1]=freq[item-1]+1;
		}
		
		System.out.println("\n---------------------------");
		
		for (int i=0;i<6;i++){
			prob[i]=freq[i]/Double.valueOf(iterations);
	        System.out.format(output[i]+"%.0f",prob[i]*100);
	        System.out.println("%");
		}
		return "---------------------------\n";
    }
    
    // Reads Products.csv and stores it into Array List   
    public void readProductsCSV() throws FileNotFoundException, IOException { 
    	try (BufferedReader br = new BufferedReader(new FileReader("Products.csv"))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	        String[] values = line.split(",");
    	        Products.add(Arrays.asList(values));
    	    }
    	}
    }
        
    public String getItems() {
    	System.out.println(Products);

    	rollItem();
    	getNumOfItems();
        // Gets items
        for(int i = 0; i<= getNumOfItems(); i++) 
        {
        int randomIndex = (int) (Math.random() * productsSize());
        //System.out.println( "Random Color: " +  Products.get(randomIndex));
        }
		return null;
    }
}