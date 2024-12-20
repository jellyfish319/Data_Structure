public class Node <Key extends Comparable<Key>, Value>{
    public Key id ;
    public Value name ;
    public int height ;
    public Node left, right ;
    public Node(Key newId, Value newName, int newHeight) {
        id=  newId ;
        name = newName ;
        left = right = null ;
        height = newHeight ;
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
    public void setKey(Key newId) {id = newId ;}
    public void setValue(Value newName) {
        name = newName ;
    }
    public void setRight(Node node) {
        right = node ;
    }
    public void setLeft(Node node) {
        left = node ;
    }
    public int getHeight() {return height ;}
    public void setHeight(int newHeight) {height = newHeight ;}

}
