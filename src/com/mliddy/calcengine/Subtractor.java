package com.mliddy.calcengine;

public class Subtractor extends CalculateBase implements MathProcessing{

    public Subtractor() {
    }

    public Subtractor(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }


    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal - rightVal;
    }
}
