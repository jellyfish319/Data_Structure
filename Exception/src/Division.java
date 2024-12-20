import java.util.* ;
public class Division {
    public void divide(int a,int b) throws DivisionByZeroException {
            if (b!=0) {
                System.out.println((double) a/b) ;
            }
            else {
                throw new DivisionByZeroException("Can't Divide Integer by 0") ;
            }
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String str) {
        super(str) ;
    }
}