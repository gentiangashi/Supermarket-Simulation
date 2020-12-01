class Ticket {
  private String entry;
  private boolean sold = false;


  public Ticket(String s){
	  entry=s;
  }

  public String getSeat(){
    return entry;
  }

  public boolean isSold(){
   return sold;
  }

  public Ticket sell(){
    sold=true;
    return this;
  }
}