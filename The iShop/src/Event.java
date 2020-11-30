class Event {
  private int capacity = 50;
  private String seatNo;
  private Ticket[] tickets = new Ticket[capacity];
  
  public Event(){
    for (int i=0;i<capacity;i++){
      seatNo="T"+Integer.toString(i+1);
      tickets[i]=new Ticket(seatNo);
    }
  }
  public boolean soldOut(){
    int count=0;
    for (int i=0;i<capacity;i++){
      if (tickets[i].isSold()) count++;
    }
    return count==capacity;
  }

  public Ticket sellTicket(){
    for (int i=0;i<capacity;i++){
      if (!tickets[i].isSold()){
        return tickets[i].sell();
      } 
    }
    return null;
  }
}