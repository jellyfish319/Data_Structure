public class Node <E> {
    private E item ;
    private Node<E> next ;

    public Node(E newItem, Node<E> node) {
        item = newItem ;
        next = node ;
    } // 노드를 생성

    public Node<E> getNext() {
        return next;
    }
    public E getItem() {
        return item;
    }
    public void setItem(E newItem) {
        item = newItem ;
    }
    public void setNext(Node<E> newNext) {
        next = newNext ;
    }
}