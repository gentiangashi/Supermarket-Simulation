import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag
    private static String groceriesFile = "groceries.csv";
	final static String delimiter = ",";

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    // Testing
    // Testing
    // Testing
    public static void main(String[] args)throws IOException {
        Bag<String> bag = new Bag<String>();
        BufferedReader file = new BufferedReader(new FileReader(groceriesFile));
        String item;
        while ((item=file.readLine()).length() > 0 && ((item=file.readLine()) != null)){
            bag.add(item);
        }

        System.out.println(file + "size of bag = " + bag.size());
        for (String rows : bag) {System.out.println(rows);}
    }
}