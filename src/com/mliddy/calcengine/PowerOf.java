package com.mliddy.calcengine;

public class PowerOf extends CalculateBase implements MathProcessing {

    public PowerOf(){

    }

    public PowerOf(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate() {

    }


    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal,rightVal);
    }
}
