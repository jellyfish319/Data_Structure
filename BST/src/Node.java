public class Node <Key extends Comparable<Key>, Value>{
    public Key id ;
    public Value name ;
    public Node left, right ;
    public Node(Key newId, Value newName) {
        id=  newId ;
        name = newName ;
        left = right = null ;
    }
    public Key getKey() {
        return id ;
    }
    public Value getValue() {
        return name ;
    }
    public Node getLeft() {
        return left ;
    }
    public Node getRight() {
        return right ;
    }
    public void setKey(Key newId) {
        id = newId ;
    }
    public void setValue(Value newName) {
        name = newName ;
    }
    public void setRight(Node node) {
        right = node ;
    }
    public void setLeft(Node node) {
        left = node ;
    }
}
