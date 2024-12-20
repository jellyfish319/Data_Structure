import java.util.EmptyStackException ;
public class Stack<E> {
    private E s[] ;
    private int top ;
    public Stack() {
        s = (E[]) new Object[1] ;
        top = -1 ;
    }
    public int size() {
        return top+1 ;
    }
    public boolean isEmpty() {
        return(top == -1) ;
    }

    public E peek() {
        return s[top] ;
    }

    public void push(E item) {
        if (size() == s.length) {
            resize(2*s.length) ;
        }
        s[++top] = item ;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException() ;
        }
        E item = s[top] ;
        s[top--] = null ;
        if (size() == s.length/4&&size()>0) {
            resize(s.length/2);
        }
        return item ;
    }

    private void resize(int newSize) {
        Object[] t = new Object[newSize] ;
        for (int i = 0 ; i < size() ; i++) {
            t[i] = s[i] ;
        }
        s = (E[]) t ;
    }

    public void print() {
        for (int i = 0 ; i < size() ; i++){
            System.out.print(s[i]) ;
        }
        System.out.println() ;
    }
}
