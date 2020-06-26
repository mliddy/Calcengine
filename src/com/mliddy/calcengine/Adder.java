package com.mliddy.calcengine;

public class Adder extends CalculateBase implements MathProcessing{

    public Adder() {
    }

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate(){
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }


    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
         setLeftVal(leftVal);
         setRightVal(rightVal);
         calculate();
        return getResult();
    }

}
