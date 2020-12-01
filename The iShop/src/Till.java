class Till extends Thread{
	// Encapsulation to prevent direct entry to variables
	private static int ID=0;
	public boolean Running;
	private int tills=0;
	private static int tillSize=0;
	// Constructor with parameters
	public Till(int id, boolean running, int size)
	{
		this.setID(id);
		this.SetOpen(running);
		this.setSize(size);
	}

	public int countTills() {return tills;}

	public static int getID() {return ID;}
	public void setID(int iD) {ID = iD;}

	public boolean getOpen() {return Running;}
	public void SetOpen(boolean running) {Running = running;}
	
	public static int getSize() {return tillSize;}
	public void setSize(int size) {tillSize = size;}
}   