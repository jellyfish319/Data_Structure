import java.util.NoSuchElementException ;

public class ArrayQueue<E> {
    private E[] q ;
    private int size,front,rear ;
    public ArrayQueue() {
        q = (E[]) new Object[2] ;
        size = front = rear = 0 ;
    }

    public int size() {return size ;}

    public boolean isEmpty() { return (size==0) ;}

    public void add(E newItem) {
        if((rear+1)%q.length==front) {
            resize(2*q.length) ;
        }
        q[(rear+1)%q.length] = newItem ;
        rear = (rear+1)%q.length ;
        size++ ;
    }


    public E remove() {
        if(isEmpty()) {
            throw new NoSuchElementException() ;
        }

        E t = q[(front+1)%q.length] ;
        front = (front+1)%q.length ;
        size-- ;
        q[front] = null ;
        if(size>0&&size==q.length/4) {
            resize(q.length/2) ;
        }
        return t ;
    }
    public void resize(int newSize) {
        Object[] t = new Object[newSize] ;
        for (int i = 0 ; i < q.length ; i++) {
            t[i] = q[i%q.length] ;
        }
        front = 0 ;
        rear = size ;
        q = (E[]) t ;
    }
    public void print() {
        for (int i = 0 ; i < q.length ; i++) {
            System.out.print(q[i%q.length] + " ");
        }
        System.out.println() ;
    }


}
