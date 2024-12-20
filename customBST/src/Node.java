public class Node <Key extends Comparable<Key>, Value> {
    public Key id ;
    public Value name ;
    public Node left, right ;
    public Node(Key newId, Value newName) {
        id = newId ;
        name = newName ;
        left = right = null ;
    }
    public void setLeft(Node newNode) {
        left = newNode ;
    }
    public void setRight(Node newNode) {
        right = newNode ;
    }
}
