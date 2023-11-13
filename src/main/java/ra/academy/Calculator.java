package ra.academy;

public class Calculator {
    public static double calculate(double num1, double num2, String operator) throws Exception{
            double result = 0;
            switch (operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if(num2 == 0.0){
                        throw new ArithmeticException("Can't divide by zero!");
                    }
                    result = num1 / num2;
                    break;
            }
            return result;
    }
}
