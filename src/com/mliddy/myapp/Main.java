package com.mliddy.myapp;

import com.mliddy.calcengine.Adder;
import com.mliddy.calcengine.CalculateBase;
import com.mliddy.calcengine.CalculateHelper;
import com.mliddy.calcengine.Divider;
import com.mliddy.calcengine.DynamicHelper;
import com.mliddy.calcengine.PowerOf;
import com.mliddy.calcengine.InvalidStatementException;
import com.mliddy.calcengine.MathEquation;
import com.mliddy.calcengine.MathProcessing;
import com.mliddy.calcengine.Multiplier;
import com.mliddy.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {

//        double[] leftVals = {100, 25, 225, 11};
//        double[] rightVals = {50, 92, 17, 3};
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

        //useMathEquation();
        //useCalculatorBase();
        //useCalculateHelper();

        String[] statements = {
                "add 25 92",
                "add 10 20",
                "subtract 25 7",
                "power 6 2"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),new Subtractor(), new PowerOf()
        });



        for(String statement:statements){
            String output = helper.process(statement);
            System.out.println(output);
        }
    }
    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addx 0 0",
          "divide 100 50",
                "add 25 92",
                "subtract 225 17",
                "multiply 11 3"

        };




        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements) {
            try { // need try/catch because we have error handling on the process() method
                  // process() method declares that it throws an Exception, so we have to handle it
                helper.process(statement);
                //System.out.print("Result is: ");
                System.out.println(helper);
            }
            catch(InvalidStatementException ex){
                System.out.println(ex.getMessage());
                if(ex.getCause() != null){
                    System.out.println("Original Exception: " + ex.getCause().getMessage());
                    //not sure about this. Gives info on original exception
                    // any time there is an invalid statement expression we writ eit out
                    // and if there's a statement within it, we'll write that message out too
                    // Gives extra info. See output - has info on error("Non-numeric Data: add xx 25.0")
                    // and also the error itself ("Original Exception: For input string: "xx")
                }
            }
        }

        System.out.println("Break************************************");
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100,50);
        equations[1] = new MathEquation('a',25,92);
        equations[2] = new MathEquation('s',225,17);
        equations[3] = new MathEquation('m',11,3);



        for(MathEquation equation:equations){
            equation.execute();
            System.out.println("Result is: " + equation.getResult());
        }

        double leftDouble =9;
        double rightDouble =4;

        MathEquation equationOverload =new MathEquation('d');
        equationOverload.execute(leftDouble,rightDouble);
        System.out.println("Result = ");
        System.out.println(equationOverload.getResult());


        System.out.println("Using Inheritance");

        CalculateBase[] calculators = {
                new Divider(100, 50),
                new Adder(25,92),
                new Subtractor(225,17),
                new Multiplier(11,3)
        };

        for(CalculateBase calculator:calculators){

            calculator.calculate();
            System.out.print("Result =: ");
            System.out.println(calculator.getResult());
        }


    }
}
