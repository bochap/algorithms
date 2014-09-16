import java.util.Iterator;

/**
 * Created by darren on 9/17/14.
 */
public class Bag<Item>
    implements Iterable<Item> {
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        Bag<String> s = new Bag<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.add(item);
        }

        for(String item : s) {
            StdOut.println(item);
        }
    }
}
