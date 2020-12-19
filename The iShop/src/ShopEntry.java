class ShopEntry {
	private String entry;
	private boolean sold = false;


	public ShopEntry(String s){
			entry=s;
	}

	public String getSeat(){
		return entry;
	}

	public boolean isSold(){
		return sold;
	}

	public ShopEntry sell(){
		sold=true;
		return this;
	}
}