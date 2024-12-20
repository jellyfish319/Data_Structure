import java.util.NoSuchElementException;
public class DList <E> {

    protected int size ;
    protected DNode head ;
    protected DNode tail ;

    public DList() {
        head = new DNode(null, null, null) ;
        tail = new DNode(null, head, null) ;
        head.setNext(tail);

        size = 0 ;
    } // 초기 리스트 생성

    public void insertAfter(DNode p, E newItem){
        DNode t = p.getNext() ; // p 이후 노드를 객체 t에 저장
        DNode k = new DNode(newItem, p, t) ; // 해당 아이템이 들어갈 노드 생성
        p.setNext(k) ; // p의 다음 노드를 k로 지정
        t.setPre(k) ; // t의 이전 노드를 k로 지정
        size++;
    }

    public void insertBefore(DNode p, E newItem){
        DNode t = p.getPre() ; // p 이전 노드를 객체 t에 저장
        DNode k = new DNode(newItem, t, p) ; // 해당 아이템이 들어갈 노드 생성
        p.setPre(k) ; // p의 이전 노드를 k로 지정
        t.setNext(k) ; // t의 다음 노드를 k로 지정
        size++;
    }

    public void delete(DNode p) {
        if (p==null) {
            throw new NoSuchElementException() ;
        }
        DNode f = p.getPre() ;
        DNode r = p.getNext() ;

        f.setNext(r) ; // 타겟 노드의 이전 노드를 타겟 노드의 다음 노드로 연결
        r.setPre(f) ; // 타겟 노드의 다음 노드를 타겟 노드의 이전 노드로 연결
        size--;
    }
    public void print() {
        if (size == 0) {
            System.out.print("List is Empty") ;
        }
        else {
            for (DNode p = head.getNext(); p != tail; p = p.getNext()) {
                System.out.print(p.getItem() + "\t");
            }
        }
    }

    public void deleteByValue(E target) {
        DNode t = search(target) ;
        delete(t) ;
    }

    public DNode search(E target) {
        DNode t = head.getNext() ;
        for (DNode p = head.getNext() ; p.getItem() != target ; p = p.getNext()) {
            t = p.getNext() ;
        } // 타겟 값이 있는 노드까지 이동
        return t ;
    }

}
