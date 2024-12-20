import java.util.NoSuchElementException;
public class CList <E> {
    protected int size ;
    protected Node last ;

    public CList() {
        last = null ;
        size = 0 ;
    }

    public void insert(E newItem) {
        Node t = new Node(newItem, null) ;
        if (last == null) {
            t.setNext(t) ;
            last = t ;
        }
        else {
            t.setNext(last.getNext()) ;
            last.setNext(t) ;
        }
        size++ ;
    }

    public void delete() {
        if(isEmpty()) {
            throw new NoSuchElementException() ;
        }
        Node t = last.getNext() ;
        if (t == null) {
             last = null ;
        }
        else {
            last.setNext(t.getNext()) ;
            t.setNext(null) ;
        }
        size-- ;
    }

    public void print() {
        Node p = last.getNext() ;
        for (int i = 0 ; i < size ; i++) {
            System.out.print(p.getItem() + "\t") ;
            p = p.getNext() ;
        }
    }

    public int size() {
        return size ;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true ;
        }
        else {
            return false ;
        }
    }

    public void deleteByValue(E target) {
        Node t = searchBeforeNodeByValue(target) ;
        Node s = t.getNext() ;
        t.setNext(s.getNext());
        size-- ;
    }

    public Node searchBeforeNodeByValue(E target) {
        Node s = null;
        for (Node p = last.getNext(); p.getItem() != target; p = p.getNext()) {
            s = p ;
        } // 타겟 값이 있는 노드까지 이동
        return s ;
    }
}
