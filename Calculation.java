package mycalculator;

import java.text.DecimalFormat;

public class Calculation {

    public static String calculation(double operand1, double operand2, String operator) {
        double ans;
        switch (operator) {
            case "+":
                ans = operand1 + operand2;
                break;
            case "-":
                ans = operand1 - operand2;
                break;
            case "*":
                ans = operand1 * operand2;
                break;
            case "/":
                ans = operand1 / operand2;
                break;
            case "^":
                ans = getPower(operand1, operand2);
                break;
            case "%":
                ans = operand1 % operand2;
                break;
            default:
                ans = 0;
                break;
        }
        DecimalFormat df = new DecimalFormat();
        String result = df.format(ans);
        return result;
    }
    
    public static String calculation(double operand, String operator) {
        double ans;
        switch (operator) {
            case "log":
                ans = getLog(operand);
                break;
            case "!":
                ans = getFactorial(operand);
                break;
            default:
                ans = 0;
                break;
        }
        DecimalFormat df = new DecimalFormat();
        String result = df.format(ans);
        return result;
    }
    
    private static double getPower(double a, double b) {
        double ans = a;
        for(int i=1; i<b; i++) {
            ans = ans * a;
        }
        return ans;
    }

    private static double getLog(double a) {
        return Math.log10(a);
    }

    private static double getFactorial(double a) {
        double ans = 1;
        for(int i=2; i<=a; i++) {
            ans = ans * i;
        }
        return ans;
    }
}
