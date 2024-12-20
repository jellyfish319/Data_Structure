public class BST<Key extends Comparable<Key>, Value> {
    public Node root ;
    public Node getRoot() {
        return root ;
    }
    public BST() {root = null; }
    public BST(Key newId, Value newName) {
        root = new Node(newId, newName) ;
    }

    public Value get(Key target) {
        return get(root, target) ;
    }
    public Value get(Node node, Key target) {
        if(node == null) {
            return null ;
        }
        int i = node.getKey().compareTo(target) ;
        if (i < 0 ) {
            return get(node.getRight(),target) ;
        }
        else if (i > 0) {
            return get(node.getLeft(), target) ;
        }
        else {
            return (Value) node.getValue() ;
        }
    }

    public void put(Key k ,Value v) {
        root = put(root,k,v) ;
    }
    private Node put(Node node, Key k, Value v) {
        if(node==null) {
            return new Node(k,v) ;
        }
        int i = node.getKey().compareTo(k) ;
        if(i < 0) {
            node.setRight(put(node.getRight(), k , v)) ;
        }
        else if (i > 0) {
            node.setLeft(put(node.getLeft(),k,v)) ;
        }
        else {
            node.setValue(v);
        }
        return node ;
    }



    public Key min() {
        if(root==null) {
            System.out.println("Root is Empty") ;
            return null ;
        }
        return (Key) min(root).getKey() ;
    }
    private Node min(Node n) {
        if(n.getLeft() == null) {
            return n ;
        }
        return min(n.getLeft()) ;
    }

    public Key max() {
        if(root==null) {
            System.out.println("Root is Empty") ;
            return null ;
        }
        return (Key) max(root).getKey() ;
    }
    private Node max(Node n) {
        if(n.getRight() == null) {
            return n ;
        }
        return max(n.getRight()) ;
    }

    public void deleteMin() {
        if (root == null) System.out.println("Root is Empty") ;
        root = deleteMin(root) ;
    }
    public Node deleteMin(Node n) {
        if(n.getLeft()==null) {
            return n.getRight() ;
        }
        n.setLeft(deleteMin(n.getLeft())) ;
        return n ;
    }

    public void deleteMax() {
        if (root == null) System.out.println("Root is Empty") ;
        root = deleteMax(root) ;
    }
    public Node deleteMax(Node n) {
        if(n.getRight()==null) {
            return n.getLeft() ;
        }
        n.setRight(deleteMax(n.getRight())) ;
        return n ;
    }


    public void delete(Key k) {
        root = delete(root,k) ;
    }

    public Node delete (Node n, Key k) {
        if(n==null) return null;
        int t = n.getKey().compareTo(k) ;
        if (t > 0 ) n.setLeft(delete(n.getLeft(),k)) ;
        else if(t < 0) n.setRight(delete(n.getRight(),k)) ;
        else {
            if(n.getRight()==null) return n.getLeft() ;
            if(n.getLeft()==null) return n.getRight() ;
            Node target = n ;
            n = min(target.getRight()) ;
            n.setRight(deleteMin(target.getRight())) ;
            n.setLeft(target.getLeft());
        }
        return n;
    }


    public void print(Node n){  // 중위 순회
        if (n != null) {
            print(n.getLeft()); // n의 왼쪽 서브트리 순회
            System.out.print(n.getKey()+"/"+n.getValue()+" ");  // 노드 n 방문
            print(n.getRight());  // n의 오른쪽서브 트리 순회
        }

    }
}
