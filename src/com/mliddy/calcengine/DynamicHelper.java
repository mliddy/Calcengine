package com.mliddy.calcengine;

public class DynamicHelper {

    // store a list of handlers
    private MathProcessing[] handlers; // list of dynamic handlers that an instance of DynamicHelper has access to

    // constructor accepts an array of handlers and stores it inside our class variable
    public DynamicHelper(MathProcessing[] handlers){
        this.handlers = handlers;
    }

    // work we did earlier in CalculateHelper, now we are doing in terms of the interface
    public String process(String statement){
        // IN: add 1.0 2.0
        // OUT: 1.0 + 2.0 = 3.0
        String[] parts = statement.split(MathProcessing.SEPARATOR); // split based on space character
        String keyword = parts[0];

        MathProcessing theHandler = null;
        //loop through the handler to find a keyword that can handle that statement
        for(MathProcessing handler:handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }

        double leftVal =Double.parseDouble(parts[1]); //1.0
        double rightVal =Double.parseDouble(parts[2]); //2.0

        double result = theHandler.doCalculation(leftVal,rightVal);
        // build string output value. Grab code from CalculateHelper
        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(" ");
        sb.append(theHandler.getSymbol());
        sb.append(" ");
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();


    }

}
