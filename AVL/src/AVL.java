import java.util.LinkedList;
import java.util.Queue;

public class AVL<Key extends Comparable<Key>, Value> {
    public Node root ;

    public Node getRoot() {
        return root ;
    }

    public AVL() {
        root = null ;
    }

    public void put(Key k ,Value v) {
        root = put(root,k,v) ;
    }
    private Node put(Node node, Key k, Value v) {
        if(node==null) {
            return new Node(k,v,1) ;
        }
        int i = k.compareTo((Key) node.id) ;
        if(i < 0) {
            node.left = put(node.left,k,v) ;
        }
        else if (i > 0) {
            node.right = put(node.right, k, v) ;
        }
        else {
            node.name = v;
            return node ;
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return balance(node) ;
    }

    public Node rotateRight(Node n) {
            Node x = n.left ;
            n.left = x.right;
            x.right = n ;
            n.height = Math.max(height(n.left), height(n.right)) + 1 ;
            x.height = Math.max(height(x.left), height(x.right)) + 1 ;
            return x ;
    }

    public Node rotateLeft(Node n) {
            Node x = n.right ;
            n.right = x.left;
            x.left = n ;
            n.height = Math.max(height(n.left), height(n.right)) + 1 ;
            x.height = Math.max(height(x.left), height(x.right)) + 1 ;
            return x ;
    }

    public Node balance(Node n) {
        if (diff(n) > 1) {
            if(diff(n.left) < 0) {
                n.left = rotateLeft(n.left) ;
            }
            n = rotateRight(n) ;
        }
        else if (diff(n) < -1) {
            if(diff(n.right) > 0) {
                n.right = rotateRight(n.right) ;
            }
            n = rotateLeft(n) ;
        }
        return n ;
    }

    public int diff(Node n) {
        return height(n.left) - height(n.right) ;
    }

    public int height(Node n) {
        if(n==null) return 0;
        else return n.height ;
    }

    public void del(Key k) {
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
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        return balance(n) ;
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


    public void preorder(Node n) {
        if(n!=null) {
            System.out.print(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void inorder(Node n) {
        if(n!=null) {
            inorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorder(n.getRight());
        }
    }

    public void postorder(Node n) {
        if(n!=null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey() + " ");
        }
    }

    public void levelorder(Node n) {
        Queue<Node> q = new LinkedList<Node>() ;
        Node t ;

        q.add(n) ;
        while(!q.isEmpty()) {
            t = q.remove() ;
            System.out.print(t.id+" ") ;
            if(t.left!=null) {
                q.add(t.left) ;
            }
            if(t.right!=null) {
                q.add(t.right) ;
            }
        }
    }

    public void print(Node n){
        System.out.print("inorder : ") ;
        inorder(root);
        System.out.println() ;

        System.out.print("preorder : ") ;
        preorder(root);
        System.out.println() ;

        System.out.print("level order : ") ;
        levelorder(root);
        System.out.println() ;
    }
}
