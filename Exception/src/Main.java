import java.util.* ;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;;
        int a = sc.nextInt() ;
        int b = sc.nextInt() ;
        Division D = new Division() ;
            try {
                D.divide(a,b); ;
            }
            catch(DivisionByZeroException e) {
                System.out.println(e.getMessage()) ;
            }
            finally {
                System.out.println("Finally block executed") ;
            }
        }
    }