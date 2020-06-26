package com.mliddy.calcengine;

public class Adder extends CalculateBase{

    public Adder() {
    }

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate(){
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }


}
