import java.util.ArrayList;

class Customer {
	// Encapsulation to prevent direct entry to variables
	private static int ID=0;
	private static ArrayList<String> Basket = new ArrayList<String>();
	public boolean running;
	private int shoppers=0;
  
	// Constructor with parameters
	public Customer(int id, ArrayList<String> basket)
	{
		this.setID(id);
		this.setBasket(basket);
		shoppers++;
	}
  
	void purchaseTicket(ShopEntry t){}

	public int countCustomers() {return shoppers;}

	public int getID() {return ID;}

	public void setID(int iD) {ID = iD;}

	public ArrayList<String> getBasket() {return Basket;}

	public void setBasket(ArrayList<String> basket) {
	Basket = basket;
	}
}     