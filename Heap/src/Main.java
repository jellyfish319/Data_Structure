public class Main {

    public static void main(String[] args)	{

        Node[] a = new Node[16];     // a[0]은 사용 안함  

        a[1]  = new Node<Integer, String>(90, "watermelon");a[2]  = new Node<Integer, String>(80, "pear");

        a[3]  = new Node<Integer, String>(70, "melon");   	a[4]  = new Node<Integer, String>(50, "lime");

        a[5]  = new Node<Integer, String>(60, "mango");   	a[6]  = new Node<Integer, String>(20, "cherry");

        a[7]  = new Node<Integer, String>(30, "grape");   	a[8]  = new Node<Integer, String>(35, "orange");

        a[9]  = new Node<Integer, String>(10, "apricot");  a[10] = new Node<Integer, String>(15, "banana");

        a[11] = new Node<Integer, String>(45, "lemon");  	a[12] = new Node<Integer, String>(40, "kiwi");

        Heap<Integer, String> h = new Heap<Integer, String>(a,12);    // 힙 객체 생성

        System.out.println("힙 만들기 전:"); h.print();

        h.createHeap();  // 힙 만들기

        System.out.println("최소힙:"); h.print();

        System.out.println("min 삭제 후"); System.out.println(h.deleteMin().getName());

        h.print();

        h.insert(5,"apple"); System.out.println("5 삽입 후"); h.print();

    }

}