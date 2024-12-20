import java.util.* ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println(" :: Start the Program :: ") ;
        System.out.println(" [ Start to Input the Mathematical Expression ]\n (If you want to stop the program, input !)") ;
        System.out.println(" [ Infix to Postfix ] ") ;
        String string ;
        while (true) {
            System.out.print(" > Input the Mathematical Expression : ") ;
            string = scanner.nextLine() ;
            if ("!".equals(string)) {
                break ;
            }

            Postfix postfix = new Postfix(string) ;
            System.out.println("Input : " + postfix.getInfix()) ;
            System.out.println("Postfix : " + postfix.getPostfix()) ;
            System.out.println("Result of Calculation : " + postfix.calculate()+"\n") ;

        }
        System.out.println(" [Stop to Input the Expression] ") ;
        System.out.println(" :: Stop the program :: ") ;
    }
}