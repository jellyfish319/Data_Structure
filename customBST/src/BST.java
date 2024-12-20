public class BST <Key extends Comparable<Key>, Value> {
    public Node root ;
    public BST() {
        root = null ;
    }
    public BST(Key newId, Value newName) {
        root = new Node(newId, newName) ;
    }

    // 탐색 연산
    public Value get(Key target) {
        return get(root, target) ;
    }
    public Value get(Node start,Key target) {
        if(start == null) {
            return null ;
        } // 노드가 null일 경우 null 출력
        int t = start.id.compareTo(target) ; // 두 Key값을 비교
        if(t == 0) {
            return (Value) start.name ; // 두 Key값이 같을 경우 해당 노드의 Value 출력
        }
        else if (t > 0) {
            return get(start.left, target) ;
            // 노드의 Key값이 큰 경우 왼쪽 자식에서 다시 탐색
        }
        else {
            return get(start.right, target) ;
            // 노드의 Key값이 작은 경우 오른쪽 자식에서 다시 탐색
        }
    }

    // 삽입 연산
    public void put(Key target,Value v) {
        root = put(root, target, v) ;
        // root가 null일 경우 첫번째로 삽입되는 값을 갖는 노드로 root 지정
        // 재귀적 구문 시행 시 루트는 항상 마지막에 수행되기에 루트를 항상 마지막에 업데이트 시켜줌, 즉, 루트 노드가 null이 아닌 이상 루트는 변하지 않음
    }
    public Node put(Node start, Key target, Value v) {
        if(start == null) {
            return new Node(target, v) ;
            // 노드가 비어있을 경우 해당 값을 갖는 노드 생성
        }
        int t = start.id.compareTo(target) ; // 비교값
        if(t==0) {
            start.name = v ;
            // Key값이 동일한 경우 Value값만 업데이트
        }
        else if(t>0) {
            start.setLeft(put(start.left, target, v)) ;
            // 노드의 Key값이 큰 경우 왼쪽 자식에서 다시 삽입 연산 수행 후 해당 노드를 왼쪽 자식 노드로 설정
            // 만약 왼쪽 자식이 null일 경우 새로운 노드를 왼쪽 자식으로 갖고 왼쪽 자식이 존재할 경우 해당 노드를 그대로 setLeft() 함
        }
        else {
            start.setRight(put(start.right, target, v)) ;
            // 노드의 Key값이 작은 경우 오른쪽 자식에서 다시 삽입 연산 수행 후 해당 노드를 오른쪽 자식 노드로 설정
            // 만약 오른쪽 자식이 null일 경우 새로운 노드를 오른쪽 자식으로 갖고 오른쪽 자식이 존재할 경우 해당 노드를 그대로 setRigtt() 함
        }
        return start ;
        // 오른쪽 혹은 왼쪽 자식 노드가 업데이트 된 start 노드를 반환
        // 이를 통해 recursion으로 수행되면서 해당 삽입 연산을 수행하기 위해 거친 모든 노드들의 왼쪽 혹은 오른쪽 노드를 삽입이 이루어진 새로운 트리로 업데이트 가능
    }

    // 삭제 연산
    public void delete(Key target) { // 해당 Key값을 갖는 노드를 삭제
        root =  delete(root,target) ;
    }
    public Node delete(Node start, Key target) {
        if(start==null) {
            return null ; // 노드가 null일 경우 null 반환
        }
        int t = start.id.compareTo(target) ;
        if(t > 0) {
            start.setLeft(delete(start.left,target)) ;
            // 노드의 Key값이 큰 경우 왼쪽 자식 노드에서 delete를 다시 수행
            // delete를 한 후 업데이트된 노드로 왼쪽 자식 노드를 업데이트
        }
        else if(t < 0) {
            start.setRight(delete(start.right,target)) ;
            // 노드의 Key값이 작은 경우 오른쪽 자식 노드에서 delete를 다시 수행
            // delete를 한 후 업데이트 된 노드로 오른쪽 자식 노드를 업데이트
        }
        else { // 해당 Key값을 갖는 노드를 찾음
            if(start.right == null) {
                return start.left ;
                // 노드의 right가 null일 경우 left에 null 혹은 어떠한 노드가 있을 것이기에 left 노드를 return            // left 노드를 return해주면 재귀적 구문에서 해당 노드를 setLeft 혹은 setRight 하므로 자연스럽게 부모 노드의 left 혹은 right를 업데이트
            }
            else if(start.left == null) {
                return start.right ;
                // right != null 인 상황에서 left가 null 이므로 자식이 하나만 있는 상황
            }
            else {
                Node temp = min(start.right) ; // start에서의 최소 노드를 갖고옴
                temp.left = start.left ;
                start = deleteMin(start.right) ; // start에서의 최소 노드를 삭제 후 start를 업데이트
                temp.right = start.right ;
                // 최소 노드의 오른쪽과 왼쪽 노드를 start 노드의 왼쪽 오른쪽 자식 노드로 설정
                return temp ;
                // 새로 설정한 temp 노드를 return함으로서 start의 부모 노드의 왼쪽 혹은 오른쪽 자식 노드를 temp로 설정
            }
        }
        return start ;
    }

    // 최소, 최대 노드 찾기
    public Node min(Node start) {
        if(start == null) {
            return null ;
        }
        if(start.left == null) {
            return start ;
        }
        else {
            return min(start.left) ;
        }
    }
    public Node max(Node start){
        if(start.right == null) {
            return start ;
        }
        else {
            return max(start.right) ;
        }
    }

    // 최소, 최대 노드 삭제
    public void deleteMin() {
        root =  deleteMin(root) ;
    }
    public Node deleteMin(Node start) {
        if(start.left == null) {
            return start.right ;
            // 최소 노드의 오른쪽 자식이 있을 경우 이 노드가 최소 노드가 되므로 이 노드를 부모 노드에 연결해주어야 함
        }
        else {
            start.setLeft(deleteMin(start.left)) ; // start의 왼쪽 노드를 업데이트
        }
        return start ;
    }
    public void deleteMax() {
        root = deleteMax(root) ;
    }
    public Node deleteMax(Node start) {
        if(start.right == null) {
            return start.left ;
            // 최대 노드의 왼쪽 자식이 있을 경우 이 노드가 최대 노드가 되므로 부모 노드에 연결해주어야함
        }
        else {
            start.setRight(deleteMax(start.right)) ; // start의 오른쪽 노드를 업데이
        }
        return start ;
    }

    public void print(Node n){  // 중위 순회
        if (n != null) {
            print(n.left); // n의 왼쪽 서브트리 순회
            System.out.print(n.id+"/"+n.name+" ");  // 노드 n 방문
            print(n.right);  // n의 오른쪽서브 트리 순회
        }
    }
}