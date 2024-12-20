public class Node <Key extends Comparable<Key>, Value> {
    Key id;
    Value name ;
    Node left, right ;
    static boolean RED ;
    static boolean BLACK ;
    boolean color ;
    public Node(Key key, Value name, boolean col) {
        id = key ;
        this.name = name ;
        left = right = null ;
        color = col ;
    }

    public Key getKey() {
        return id ;
    }
    public Node getRight() {
        return right ;
    }
    public Node getLeft() {
        return left ;
    }
    public void setValue(Value newName) {
        name = newName ;
    }
}
