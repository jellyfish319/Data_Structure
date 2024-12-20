import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;

	public BinaryTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node newRoot) {
		root = newRoot;
	}

	public boolean isEmpty() {
		return root == null;
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
		Node t;
		q.add(n) ;
		while (!q.isEmpty()) {
			t = q.remove();
			System.out.print(t.getKey() + " ");
			if (t.getLeft() != null) {
				q.add(t.getLeft());
			}
			if (t.getRight() != null) {
				q.add(t.getRight());
			}
		}
	}

	public int size(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + size(n.getRight()) + size(n.getLeft());
		}
	}

	public int height(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
		}
	}

	public static boolean isEqual(Node n, Node m) {
		if (n == null || m == null) {
			return n == m; // n과 m이 null인지 확인
		}
		if (n.getKey().compareTo(m.getKey()) != 0) {
			return false;
		} else {
			return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
		}
	}
	public Node copy(Node n) {
		Node t ;
		t = n ;
		if(t==null) {
			return null ;
		}
		else {
			t.setLeft(copy(n.getLeft()));
			t.setRight(copy(n.getRight()));
			return t ;
		}
	}
}