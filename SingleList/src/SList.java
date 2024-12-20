import java.util.NoSuchElementException;

public class SList <E> {

    protected Node head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            if (target == p.getItem()) {
                return i ;
            }
            p = p.getNext() ;
        }
        return -1;
    }

    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node p) {
        Node q = new Node(newItem, p.getNext());
        p.setNext(q);
        size++;
    }

    public void deleteFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) {
            throw new NoSuchElementException();
        }
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;

    }

    public void print() {
        for (Node p = head; p != null; p = p.getNext()) {
            System.out.print(p.getItem() + "\t");
        }
    }

    public int size() {
        return size ;
    }
}