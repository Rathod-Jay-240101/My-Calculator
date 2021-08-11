package mycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label MyLable;
    private boolean start = true;

    @FXML
    public void pressButton(ActionEvent event) {

        if (start) {
            start = false;
            MyLable.setText("");
        }

        String result, newLable;
        String lable = MyLable.getText();
        String value = ((Button) event.getSource()).getText();

        switch (value) {
            case "=":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand2(str);
                        result = Calculation.calculation(Memory.operand1, Memory.operand2, Memory.operator);
                        result = result.replaceAll(",", "");
                        MyLable.setText(result);
                        Memory.isOperatorAvailable = false;
                    } else {
                        //DO NOTHING
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        //DO NOTHING
                    } else {
                        //DO NOTHING
                    }
                }
                break;
            case "+":
            case "*":
            case "/":
            case "^":
            case "%":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand2(str);
                        result = Calculation.calculation(Memory.operand1, Memory.operand2, Memory.operator);
                        result = result.replaceAll(",", "");
                        Memory.setOperand1(result);
                        Memory.operator = value;
                        newLable = result + " " + value + " ";
                        MyLable.setText(newLable);
                        Memory.pointer = newLable.length();
                        Memory.isOperandAvailable = false;
                        Memory.isAddOnOperatorAvailable = false;
                    } else {
                        //DO NOTHING
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand1(str);
                        Memory.operator = value;
                        newLable = lable + " " + value + " ";
                        MyLable.setText(newLable);
                        Memory.pointer = newLable.length();
                        Memory.isOperatorAvailable = true;
                        Memory.isOperandAvailable = false;
                        Memory.isAddOnOperatorAvailable = false;
                    } else {
                        //DO NOTHING
                    }
                }
                break;
            case "-":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand2(str);
                        result = Calculation.calculation(Memory.operand1, Memory.operand2, Memory.operator);
                        result = result.replaceAll(",", "");
                        Memory.setOperand1(result);
                        Memory.operator = value;
                        newLable = result + " " + value + " ";
                        MyLable.setText(newLable);
                        Memory.pointer = newLable.length();
                        Memory.isOperandAvailable = false;
                        Memory.isAddOnOperatorAvailable = false;
                    } else {
                        if (Memory.isAddOnOperatorAvailable) {
                            //DO NOTHING
                        } else {
                            newLable = lable + value;
                            MyLable.setText(newLable);
                            Memory.isAddOnOperatorAvailable = true;
                        }
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand1(str);
                        Memory.operator = value;
                        newLable = lable + " " + value + " ";
                        MyLable.setText(newLable);
                        Memory.pointer = newLable.length();
                        Memory.isOperatorAvailable = true;
                        Memory.isOperandAvailable = false;
                        Memory.isAddOnOperatorAvailable = false;
                    } else {
                        newLable = lable + value;
                        MyLable.setText(newLable);
                        Memory.isAddOnOperatorAvailable = true;
                    }
                }
                break;
            case "log":
            case "!":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        //DO NOTHING
                    } else {
                        //DO NOTHING
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand1(str);
                        if(Memory.operand1 > 0) {
                            Memory.operator = value;
                            result = Calculation.calculation(Memory.operand1, Memory.operator);
                            result = result.replaceAll(",", "");
                            Memory.setOperand1(result);
                            newLable = result;
                            MyLable.setText(newLable);
                            Memory.pointer = newLable.length();
                        } else {
                            //DO NOTHING
                        }
                    } else {
                        //DO NOTHING
                    }
                }
                break;
            case "M+":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand2(str);
                        result = Calculation.calculation(Memory.operand1, Memory.operand2, Memory.operator);
                        result = result.replaceAll(",", "");
                        double memoryPlus = Double.parseDouble(result);
                        Memory.memoryPlus(memoryPlus);
                    } else {
                        //DO NOTHING
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        double memoryPlus = Double.parseDouble(str);
                        Memory.memoryPlus(memoryPlus);
                    } else {
                        //DO NOTHING
                    }
                }
                break;
            case "M-":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        Memory.setOperand2(str);
                        result = Calculation.calculation(Memory.operand1, Memory.operand2, Memory.operator);
                        result = result.replaceAll(",", "");
                        double memoryMinus = Double.parseDouble(result);
                        Memory.memoryMinus(memoryMinus);
                    } else {
                        //DO NOTHING
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        String str = lable;
                        double memoryMinus = Double.parseDouble(str);
                        Memory.memoryMinus(memoryMinus);
                    } else {
                        //DO NOTHING
                    }
                }
                break;
            case "M":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        lable = lable.substring(0, Memory.pointer);
                        newLable = lable + Memory.getMemory();
                        MyLable.setText(newLable);
                    } else {
                        newLable = lable + Memory.getMemory();
                        MyLable.setText(newLable);
                        Memory.isOperandAvailable = true;
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        MyLable.setText(Memory.getMemory());
                    } else {
                        MyLable.setText(Memory.getMemory());
                        Memory.isOperandAvailable = true;
                    }
                }
                break;
            case "CE":
                Memory.isOperandAvailable = false;
                Memory.isOperatorAvailable = false;
                Memory.isAddOnOperatorAvailable = false;
                MyLable.setText("");
                break;
            case ".":
                if (Memory.isOperatorAvailable) {
                    if (Memory.isOperandAvailable) {
                        if (!(Memory.isDotAvailable(lable, 2))) {
                            newLable = lable + value;
                            MyLable.setText(newLable);
                        } else {
                            //DO NOTHING
                        }
                    } else {
                        newLable = lable + "0" + value;
                        MyLable.setText(newLable);
                        Memory.isOperandAvailable = true;
                    }
                } else {
                    if (Memory.isOperandAvailable) {
                        if (!(Memory.isDotAvailable(lable, 1))) {
                            newLable = lable + value;
                            MyLable.setText(newLable);
                        } else {
                            //DO NOTHING
                        }
                    } else {
                        newLable = lable + "0" + value;
                        MyLable.setText(newLable);
                        Memory.isOperandAvailable = true;
                    }
                }
                break;
            default:
                Memory.isOperandAvailable = true;
                newLable = lable + value;
                MyLable.setText(newLable);
                break;
        }
    }
}
