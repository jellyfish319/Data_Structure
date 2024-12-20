public class Heap <Key extends Comparable<Key>, Value>{
    Node[] heap ; // Node를 담는 array
    int size ;

    Heap(Node[] a, int size) {
        heap = a ;
        this.size = size ;
    }

    public int size() {
        return size ;
    } // heap의 크기를 출력

    public boolean greater(int i, int j) {
        return (heap[i].getKey().compareTo(heap[j].getKey()) > 0) ;
    }

    public void swap(int i, int j) {
        Node tmp = heap[i] ;
        heap[i] = heap[j] ;
        heap[j] = tmp ;
    }

    public void createHeap() { // min heap으로 구성해주는 함수
        for(int i = size/2 ; i > 0 ; i--) { // terminal Node의 부모노드부터 비교하면서 올라가면 됨, bottom-up 방식
            downheap(i) ;
        }
    }

    public void downheap(int i) {
        while(2*i <= size) {
            int leftChild = 2*i ; // 자식노드
            if(leftChild < size && greater(leftChild, leftChild +1)) { // left child == size 일 경우 sibling이 존재하지 않음
                leftChild++ ; // 자식노드 중 더 큰 자식노드를 찾기
            }
            if(!greater(i, leftChild)) {
                break ; // 자식노드보다 작을 경우 min heap조건을 만족하므로 break
            }
            swap(i, leftChild) ; // 자식노드보다 클 경우 min heap조건을 만족하지 않으므로 swap
            i = leftChild; // 다시 i를 내려보낼 수 있는지 확인하기 위해 i=k로 업데이트
        }
    }

    public void upheap(int i) {
        while(i > 1 && greater(i/2, i)) { // i/2 즉, 부모노드의 key가 크고 root node가 아닐경우
            swap(i/2, i) ; // 부모노드와 자리를 바꿈
            i /= 2 ; // index 업데이트
        }
    }

    public void insert(Key newkey, Value newvalue) {
        Node t = new Node(newkey, newvalue) ;
        heap[++size] =  t ; // heap의 마지막 index에 Node 삽입
        upheap(size); // 삽입한 노드를 upheap하여 정렬시킴
    }

    public Node deleteMin() {
        Node del = heap[1] ;
        heap[1] = heap[size--] ;
        heap[size+1] = null ;
        downheap(1);
        return del ;
    }

    public void print() {
        for (int i = 1 ; i <= size ; i++) {
            System.out.print("[" + heap[i].getKey()+ " : " + heap[i].getName() + "] ");
        }
        System.out.println() ;
    }
}
