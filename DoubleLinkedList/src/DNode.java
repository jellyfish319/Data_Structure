public class DNode <E> {

    private E item ;
    private DNode next ;
    private DNode pre ;

    public DNode(E newItem, DNode p, DNode q) {
        item = newItem ;
        pre = p ;
        next = q ;
    }

    public E getItem() {
        return item ;
    }

    public void setNext(DNode p) {
        next = p ;
    }

    public void setPre(DNode q) {
        pre = q ;
    }

    public DNode getNext() {
        return next ;
    }

    public DNode getPre() {
        return pre ;
    }

}
