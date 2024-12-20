import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    Node root ;

    public RedBlackTree() {
        root = null ;
    }
    public boolean isEmpty() {
        return root == null ;
    }
    public boolean isRed(Node n) {
        if(n==null) {
            return Node.BLACK ;
        }
        return (n.color == Node.RED) ;
    }
    public Node getRoot() {
        return root ;
    }

    // 노드들에 대한 기본 연산

    // rotateRight : 이진트리에서의 rotateRight와 동일
    // color를 바꾸는 process가 추가
    private Node rotateRight(Node n) {
        Node t = n.left ;
        n.left = t.right ;
        t.right = n ;
        t.color = n.color ;
        n.color = Node.RED ;
        return t ;
    }
    private Node rotateLeft(Node n) {
        Node t = n.right ;
        n.right = t.left ;
        t.left = n ;
        t.color = n.color ;
        n.color = Node.RED ;
        return t ;
    }

    private void flipColors(Node n) {
        n.color = !n.color ;
        n.right.color = !n.right.color ;
        n.left.color = !n.left.color ;
    }


    // get 함수 : 해당 key를 가진 Node의 Value 출력
    public Value get(Key k) {
        return get(root, k) ;
    }
    private Value get(Node n , Key k) {
        if(n == null) {
            return null ;
        }
        int t = k.compareTo((Key) n.id) ;
        if(t>0) {
            return get(n.right,k) ;
        }
        else if (t<0) {
            return get(n.left, k) ;
        }
        else {
            return (Value) n.name ;
        }
    }

    public void put(Key k, Value v) {
        root = put(root,k,v) ;
        root.color = Node.BLACK ;
    }
    private Node put(Node n,Key k,Value v) {
        if(n==null) {
            return new Node(k,v, Node.RED) ;
        }
        int t = k.compareTo((Key) n.id) ;
        if(t>0) {
            n.right = put(n.right,k,v) ;
        }
        else if(t<0) {
            n.left = put(n.left,k,v) ;
        }
        else {
            n.setValue(v);
        }
        // 이진트리에서의 put과 동일

        // 색을 fix해주는 process가 추가됨
        return fix(n) ;
    }

    // fix method
    private Node fix(Node n) {
        if(!isRed(n.left)&&isRed(n.right)) { // left 자식 노드는 BLACK , right 자식 노드는 RED인 경우
            n = rotateLeft(n) ;
        }
        if(isRed(n.left)&&isRed(n.left.left)) { // 왼쪽 자식 노드가 연속적으로 RED일 경우
            n = rotateRight(n) ;
        }
        if(isRed(n.left)&&isRed(n.right)) { // 모든 자식의 노드가 RED일 경우
            flipColors(n);
        }
        return n ;
    }

    // deleteMin : 최솟값 삭제 연산
    // 왼쪽 노드로 계속 내려가면서 RED link를 옮겨 최종적으로 삭제되는 노드를 RED로 만든 후 삭제
    // link를 옮기는 방법은 두 가지 경우가 존재
    private Node moveRedLeft(Node n) {
        /*
        (공통조건)
        n.left와 n.right 모두 BLACK임

        1. n.right.left가 BLACK일 경우
            - flip 수행
        2. n.right.left가 RED일 경우
            - flip 수행
            - rotateRight(n.right) 수행
            - rotateLeft(n) 수행
            - 다시 flip
         */
        flipColors(n);
        if(isRed(n.right.left)) {
            n.right = rotateRight(n.right) ;
            n = rotateLeft(n) ;
            flipColors(n);
        }
        return n ;
    }

    private Node moveRedRight(Node n) {
        flipColors(n) ; // case 1 && case 2
        if(isRed(n.left.left)) { // case 2
            n = rotateRight(n) ; // left만 끌어올리면 되기에 rotateLeft만 수행
            flipColors(n);
        }
        return n;
    }

    
    // 최솟값 삭제 연산
    public void deleteMin() {
        root = deleteMin(root);
        root.color = Node.BLACK ;
    }
    private Node deleteMin(Node n) {
        if(n.left == null) {
            return null ; // 최솟값일 경우 null return
        }
        if(!isRed(n.left)&&!isRed(n.left.left)) { // 모든 자식이 BLACK인 상황
            n = moveRedLeft(n) ;
        }
        n.left = deleteMin(n.left) ; // left 자식을 갱신
        return fix(n) ;
    }

    // 최솟값을 갖는 노드를 찾는 연산
    private Node min(Node n) {
        if(n.left == null) {
            return n;
        }
        return min(n.left) ;
    }

    // delete 연산

    public void delete(Key k) {
        root = delete(root, k) ;
        root.color = Node.BLACK ;
    }

    private Node delete(Node n, Key k) {
        int t = k.compareTo((Key) n.id) ;
        if(t < 0) { // target값이 Node의 값 보다 작을 경우 왼쪽으로 이동
            if(!isRed(n.left)&&!isRed(n.left.left)) {
                n = moveRedLeft(n) ; // deleteMin과 동일한 process 수행, 왼족 link에 대하여 수행하는 것이기에
            }
            n.left = delete(n.left, k) ; // delete를 다시 수행
        }
        else { // target값이 Node의 Key보다 같거나 큼
            if(isRed(n.left)) { // Node의 left가 RED
                n = rotateRight(n) ; // 오른쪽 RED link를 내려보냄
            }
            if(t == 0 && n.right == null) { // Node가 terminal Node
                return null ; // 해당 노드 삭제
            }
            if(!isRed(n.right)&&!isRed(n.right.left)) { // right가 BLACK이고 right.left가 BALCK 혹은 Null일 경우
                n = moveRedRight(n) ; // 오른쪽으로 RED link를 내려보냄
            }
            if(t==0) {
                Node successor = min(n.right) ;
                n.name = get(n.right, (Key) successor.id) ;
                n.id = successor.id ;
                n.right = deleteMin(n.right) ;
            }
            else {
                n.right = delete(n.right, k) ;
            }
        }
        return fix(n) ;
    }




    // print 구현부

    public void print(Node n) {

        System.out.println("preorder: ");
        preorder(n);

        System.out.println("inorder: ");
        inorder(n);

        System.out.println("postorder: ");
        postorder(n);

        System.out.println("levelorder: ");
        levelorder(n);
        System.out.println() ;
    }
    public void preorder(Node n) {
        if(n != null) {
            System.out.println(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    public void inorder(Node n) {
        if(n != null) {
            inorder(n.getLeft());
            System.out.println(n.getKey() + " ");
            inorder(n.getRight());
        }
    }

    public void postorder (Node n) {
        if(n != null) {
            inorder(n.getLeft());
            inorder(n.getRight());
            System.out.println(n.getKey() + " ");
        }
    }

    public void levelorder (Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getKey()+" ");
            if(t.getLeft()!=null) {
                q.add(t.getLeft());
            }
            if(t.getRight()!=null) {
                q.add(t.getRight());
            }
        }
    }
}
