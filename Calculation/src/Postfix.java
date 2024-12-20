public class Postfix {

    String infix ;
    String postfix ;

    Stack<String> postStack ;
    public Postfix(String string) {
        infix = string ;
        postStack = new Stack<>() ;
        postfix = "" ;
    }

    public void infixtoPostfix() {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            if (Character.isDigit(infix.charAt(i))) {
                postfix = postfix.concat(String.valueOf(infix.charAt(i))) ;
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
                            postfix = postfix.concat(stack.pop()) ;
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
                            postfix = postfix.concat(stack.pop()) ;
                        } else {
                            stack.push(String.valueOf(infix.charAt(i)));
                            break;
                        }
                    }
                }
                else if (infix.charAt(i) == ')') {
                    while (true) {
                        postfix = postfix.concat(stack.pop()) ;
                        if (stack.peek().equals("(")) {
                            stack.pop() ;
                            break ;
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix = postfix.concat(stack.pop()) ;
        }
    }

    public String getInfix() {
        return infix ;
    }

    public String getPostfix() {
        infixtoPostfix() ;
        return postfix ;
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
                double num = num2+num1 ;
                stack.push(num);
            }
            else if (postfix.charAt(i) == '-') {
                double num1 = stack.pop() ;
                double num2 = stack.pop() ;
                double num = num2-num1 ;
                stack.push(num);
            }
            else if (postfix.charAt(i) == '*') {
                double num1 = stack.pop() ;
                double num2 = stack.pop() ;
                double num = num2*num1 ;
                stack.push(num);
            }
            else if (postfix.charAt(i) == '/') {
                double num1 = stack.pop() ;
                double num2 = stack.pop() ;
                double num = num2/num1 ;
                stack.push(num);
            }
            else if (postfix.charAt(i) == '%') {
                double num1 = stack.pop() ;
                double num2 = stack.pop() ;
                double num = num2%num1 ;
                stack.push(num);
            }
        }
        return stack.pop() ;
    }

}
