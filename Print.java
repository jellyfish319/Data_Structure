import java.util.LinkedList;
import java.util.Queue;

public class Print {
	public Print(Node n) {
		print(n);
	}
	public void print(Node n) {
		
		System.out.println("preorder: ");
		preorder(n);
		
		System.out.println("inorder: ");
		inorder(n);
		
		System.out.println("postorder: ");
		postorder(n);
		
		System.out.println("levelorder: ");
		levelorder(n);
	}
	public void preorder(Node n) {
		if(n != null) {
		System.out.println(n.getKey() + " ");
		preorder(n.getLeft());
		preorder(n.getRight());
	}}
	public void inorder(Node n) {
		if(n != null) {
		inorder(n.getLeft());
		System.out.println(n.getKey() + " ");
		inorder(n.getRight());
	}}
	
	public void postorder (Node n) {
		if(n != null) {
		inorder(n.getLeft());
		inorder(n.getRight());
		System.out.println(n.getKey() + " ");
	}}
	
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
