package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.util.EventObject;

public class HelloController {

    @FXML
    private TextField display;

    private String currentInput = "";
    private double currentResult = 0;
    private String currentOperator = "";
    private double num;

    @FXML
    public void handleDigit(ActionEvent event) {

        Button button = (Button) event.getSource();
        currentInput += button.getText();
        int count = 0;
        for (int i=0; i < currentInput.length(); i++){
            if (currentInput.charAt(i) == '0'){
                count++;
            }
        }
        if(currentInput.equals("0") && count > 1){
            System.exit(0);
        }
        display.setText(currentInput);


    }



    @FXML
    public void handleOperator(ActionEvent event) {
        Button button = (Button) event.getSource();
        currentOperator = button.getText();
        currentResult = Double.parseDouble(currentInput);
        currentInput = "";
    }

    @FXML
    public void calculate() {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            switch (currentOperator) {
                case "+":
                    currentResult += secondOperand;
                    break;
                case "-":
                    currentResult -= secondOperand;
                    break;
                case "*":
                    currentResult *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        currentResult /= secondOperand;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(currentResult));
            currentInput = "";
            currentOperator = "";
        }


    }

    @FXML
    public void clear() {
        currentInput = "";
        currentResult = 0;
        currentOperator = "";
        display.clear();
    }
}
