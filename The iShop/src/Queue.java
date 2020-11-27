/**
 * @author Gentian Gashi | 14/10/2020
 *
 */
class QueueArray {
    protected int maxSize;
    protected long[] queArray;
    protected int front;
    protected int rear;
    protected int nItems;
 
	public QueueArray(int s)      
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

	public void insert(CustomerController customer )  
    { Main.tills.add(customer); }

    public void remove(CustomerController customer)        
    {Main.tills.remove(customer);}

    public CustomerController peek()     
    {return Main.tills.get(0);}

    public boolean isEmpty()  
    {return (nItems==0);}
    
    public boolean isFull() 
    { return (nItems==maxSize);}

    public int size()
    { return Main.tills.size();}   

    public void displayQueue()
    {
        int disp = front;
        if(!this.isEmpty())
            while(disp <= rear)
                System.out.print("[" + this.queArray[disp++] + "]");
        else
            System.out.println("Empty queue");
        System.out.println("");
    }
}
