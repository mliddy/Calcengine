package com.mliddy.calcengine;

public class MathEquation {

    public double leftVal;
    public double rightVal;
    public double result;
    public char opCode;


    public MathEquation(){

    }

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation( char opCode,double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;

    }

    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal=rightVal;
        execute();
    }
    public void execute(){
        switch(opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd': {

                // following replaces the last 4 lines of if else
                // Read as: "val2 not equal to zero? If it's not, divide val1/val2. Otherwise return 0"
                result = rightVal != 0 ? leftVal / rightVal : 0;
                //    if(val2!=0)
                //      result = val1/val2;
                //else
                //  result = 0;
                break;

            } default:
                System.out.println("invalid Opcode");
                result = 0;
                break;

        }
    }


    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public double getResult() {
        return result;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
}
