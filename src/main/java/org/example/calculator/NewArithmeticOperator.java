package org.example.calculator;

public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculator(PositiveNumber operand1, PositiveNumber operand2);
}
