class Ticket {
  private String seat;
  private boolean sold = false;


  public Ticket(String s){
    seat=s;
  }

  public String getSeat(){
    return seat;
  }

  public boolean isSold(){
   return sold;
  }

  public Ticket sell(){
    sold=true;
    return this;
  }
}