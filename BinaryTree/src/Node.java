public class Node <Key extends Comparable<Key>>{
    private Key item ;
    private Node<Key> left ;
    private Node<Key> right ;
    public Node(Key newItem, Node lt , Node rt) {
        item = newItem ;
        left = lt ;
        right = rt ;
    }
    public Key getKey() {
        return item ;
    }
    public Node<Key> getLeft() {
        return left ;
    }
    public Node<Key> getRight() {
    	return right ;
    }
    public void setKey(Key newItem) {
    	item = newItem ;
    }
    public void setRight(Node<Key> newRight) {
    	right = newRight ;
    }
    public void setLeft(Node<Key> newLeft) {
    	left = newLeft ;
    }
    
}
