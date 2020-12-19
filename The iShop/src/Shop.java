class Shop {
	private int capacity = 50;
	private String seatNo;
	private ShopEntry[] tickets = new ShopEntry[capacity];
  
	public Shop()
	{
		for (int i=0;i<capacity;i++)
		{
			seatNo="T"+Integer.toString(i+1);
			tickets[i]=new ShopEntry(seatNo);
		}
	}
	
	public boolean soldOut()
	{
		int count=0;
		for (int i=0;i<capacity;i++)
		{
			if (tickets[i].isSold()) count++;
		}
		return count==capacity;
	}

	public ShopEntry sellTicket()
	{
		for (int i=0;i<capacity;i++)
		{
			if (!tickets[i].isSold()){
				return tickets[i].sell();
			} 
		}
		return null;
	}
}