public class Node <E>{
    private Node<E> n ;
    private E item ;
    public Node(E newItem, Node<E> newNode) {
        item = newItem ;
        n = newNode ;

    }
    public Node getNextNode() {
        return n ;
    }
    public E getItem() {
        return item ;
    }
    public void setNextNode(Node<E> newNode) {
        n = newNode ;
    }
}
