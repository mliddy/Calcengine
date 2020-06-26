package com.mliddy.calcengine;

public interface MathProcessing {

    String SEPARATOR = " "; // character we use to split statements apart
    String getKeyword(); // returns a keyword that a particularly implementation knows how to handle. e.g. /add
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);

}
