import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Object obj = new Integer(10);
        Class<?> objClass = obj.getClass();
        System.out.println(objClass.getName());

        }
    }


    import java.util.* ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println(" :: Start the Program :: ") ;
        System.out.println(" [Start to Input the Mathematical Expression] ") ;
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












else {
        if (infix.charAt(i) == '(') {
        stack.push(String.valueOf(infix.charAt(i)));
        }
        else if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
        while (true) {
        if (stack.size() == 0) {
        stack.push(String.valueOf(infix.charAt(i))) ;
        break ;
        } else if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
        System.out.print(stack.pop());
        } else {
        stack.push(String.valueOf(infix.charAt(i)));
        break;
        }
        }
        } else if (infix.charAt(i) == '*' || infix.charAt(i) == '/' || infix.charAt(i) == '%') {
        while (true) {
        if (stack.size() == 0) {
        stack.push(String.valueOf(infix.charAt(i))) ;
        break ;
        } if (stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
        System.out.print(stack.pop());
        } else {
        stack.push(String.valueOf(infix.charAt(i)));
        break;
        }
        }
        } else if (infix.charAt(i) == ')') {
        while (true) {
        System.out.print(stack.pop()) ;
        if (stack.peek().equals("(")) {
        stack.pop() ;
                            break ;
                                    }
                                    }
                                    }
                                    }










public void infixtoPostfix() {
    postStack = new Stack<String>() ;
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < infix.length(); i++) {
        if (Character.isDigit(infix.charAt(i))) {
            String a = String.valueOf(infix.charAt(i)) ;
            System.out.print(a) ;
        } else {
            if (infix.charAt(i) == '(') {
                stack.push(String.valueOf(infix.charAt(i)));
            }
            else if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(infix.charAt(i))) ;
                        break ;
                    } else if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
                        System.out.print(stack.pop());
                    } else {
                        stack.push(String.valueOf(infix.charAt(i)));
                        break;
                    }
                }
            } else if (infix.charAt(i) == '*' || infix.charAt(i) == '/' || infix.charAt(i) == '%') {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(infix.charAt(i))) ;
                        break ;
                    } if (stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
                        System.out.print(stack.pop());
                    } else {
                        stack.push(String.valueOf(infix.charAt(i)));
                        break;
                    }
                }
            } else if (infix.charAt(i) == ')') {
                while (true) {
                    System.out.print(stack.pop()) ;
                    if (stack.peek().equals("(")) {
                        stack.pop() ;
                        break ;
                    }
                }
            }
        }
    }
    while (!stack.isEmpty()) {
        System.out.print(stack.pop());
    }
    System.out.println() ;
}









public Stack infixtoPostfix() {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < infix.length(); i++) {
        if (Character.isDigit(infix.charAt(i))) {
            postStack.push(String.valueOf(infix.charAt(i))) ;
            postfix = postfix.concat(postStack.peek()) ;
        }
        else {
            if (infix.charAt(i) == '(') {
                stack.push(String.valueOf(infix.charAt(i)));
            }
            else if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(infix.charAt(i))) ;
                        break ;
                    } else if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
                        postStack.push(stack.pop());
                        postfix = postfix.concat(postStack.peek()) ;
                    } else {
                        stack.push(String.valueOf(infix.charAt(i)));
                        break;
                    }
                }
            }
            else if (infix.charAt(i) == '*' || infix.charAt(i) == '/' || infix.charAt(i) == '%') {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(infix.charAt(i))) ;
                        break ;
                    } if (stack.peek().equals("*") || stack.peek().equals("%") || stack.peek().equals("/")) {
                        postStack.push(stack.pop());
                        postfix = postfix.concat(postStack.peek()) ;
                    } else {
                        stack.push(String.valueOf(infix.charAt(i)));
                        break;
                    }
                }
            }
            else if (infix.charAt(i) == ')') {
                while (true) {
                    postStack.push(stack.pop()) ;
                    postfix = postfix.concat(postStack.peek()) ;
                    if (stack.peek().equals("(")) {
                        stack.pop() ;
                        break ;
                    }
                }
            }
        }
    }
    while (!stack.isEmpty()) {
        postStack.push(stack.pop());
        postfix = postfix.concat(postStack.peek()) ;
    }
    return postStack ;
}



public double calculate() {
    Stack<Double> stack = new Stack<>() ;
    for (int i=0 ; i < postfix.length() ; i++) {
        if (Character.isDigit(postfix.charAt(i))) {
            double num = Character.getNumericValue(postfix.charAt(i));
            stack.push(num);
        }
        else if (postfix.charAt(i) == '+') {
            double num1 = stack.pop() ;
            double num2 = stack.pop() ;
            double num = num1+num2 ;
            stack.push(num);
        }
        else if (postfix.charAt(i) == '-') {
            double num1 = stack.pop() ;
            double num2 = stack.pop() ;
            double num = num1-num2 ;
            stack.push(num);
        }
        else if (postfix.charAt(i) == '*') {
            double num1 = stack.pop() ;
            double num2 = stack.pop() ;
            double num = num1*num2 ;
            stack.push(num);
        }
        else if (postfix.charAt(i) == '/') {
            double num1 = stack.pop() ;
            double num2 = stack.pop() ;
            double num = num1/num2 ;
            stack.push(num);
        }
        else if (postfix.charAt(i) == '%') {
            double num1 = stack.pop() ;
            double num2 = stack.pop() ;
            double num = num1%num2 ;
            stack.push(num);
        }
    }
    return stack.pop() ;
}