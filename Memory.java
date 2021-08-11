package mycalculator;

import java.text.DecimalFormat;

public class Memory {

    static double memory = 0;
    static boolean isOperatorAvailable = false;
    static boolean isOperandAvailable = false;
    static boolean isAddOnOperatorAvailable = false;   //To avoid two time negative sign (eg. --3)
    static double operand1;
    static double operand2;
    static String operator;
    static int pointer;
    static DecimalFormat df = new DecimalFormat();

    public static void memoryPlus(double value) {
        memory = memory + value;
    }

    public static void memoryMinus(double value) {
        memory = memory - value;
    }

    public static String getMemory() {
        return (df.format(memory)).replaceAll(",", "");
    }

    public static void setOperand1(String str) {
        operand1 = Double.parseDouble(str);
    }

    public static void setOperand2(String str) {
        operand2 = Double.parseDouble(str.substring(pointer));
    }

    public static boolean isDotAvailable(String str, int operatorNumber) {
        if (operatorNumber == 1) {
            return str.contains(".");
        } else {
            return str.substring(pointer).contains(".");
        }
    }
}
