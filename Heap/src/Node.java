public class Node <Key extends Comparable<Key>, Value> {
    Key key ;
    Value name ;

    Node(Key newKey, Value newName) {
        key = newKey ;
        name = newName ;
    }

    public Key getKey() {
        return key ;
    }

    public Value getName() {
        return name ;
    }
}
