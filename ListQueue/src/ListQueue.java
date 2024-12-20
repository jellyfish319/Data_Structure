import java.util.NoSuchElementException;

public class ListQueue<E> {

    private Node<E> front ;
    private Node<E> rear ;
    private int size ;

    public ListQueue() {
        front = rear = null ;
        size = 0 ;
    }
    public int size() {
        return size ;
    }
    public boolean isEmpty() {
        return (size()==0) ;
    }
    public void add(E newitem) {
        Node t = new Node(newitem , null) ;
        if(isEmpty()) {front = t;}
        else {
        rear.setNextNode(t);
        }
        rear = t ;
        size++ ;
    }

    public void remove() {
        if(isEmpty()) {
            throw new NoSuchElementException() ;
        }
        front = front.getNextNode() ;
        if(isEmpty()) {
            rear = null ;
        }
        size-- ;
    }

    public void print() {
        for (Node i = front ; i != null ; i = i.getNextNode()) {
            System.out.print(i.getItem() + " ") ;
        }
        System.out.println() ;
    }

}
