package com.mliddy.calcengine;

public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathCommand command;
    double leftValue;
    double rightValue;
    double result;
    String statement;

    public void process(String statement) throws InvalidStatementException{
        // add 1.0 2.0
        this.statement = statement;
        String[] parts = statement.split(" ");
        if(parts.length!=3){
            throw new InvalidStatementException("Incorrect Number of fields",statement);
        }

        String commandString = parts[0];

        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        }
        catch (NumberFormatException ex){
            throw new InvalidStatementException("Non-numeric Data", statement,ex);
        }

        setCommandFromString(commandString); // setCommandFromString now has the appropriate enumeration value inside it

        if(command == null){
            throw new InvalidStatementException("Invalid command",statement);
        }

        CalculateBase calculator = null;

        switch (command){
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue,rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue,rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue,rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString){
        // add -> MathCOmmand.Add

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())) // take enum value and make it a String
            command = MathCommand.Add;
            else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString())) // take enum value and make it a String
                command = MathCommand.Subtract;
            else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString())) // take enum value and make it a String
                    command = MathCommand.Divide;
            else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString())) // take enum value and make it a String
                        command = MathCommand.Multiply;

    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch(command){ // notation that is more compact, dosnt need break, for example;
            case Add -> symbol = ADD_SYMBOL;
            case Subtract -> symbol=SUBTRACT_SYMBOL;
            case Multiply -> symbol=MULTIPLY_SYMBOL;
            case Divide -> symbol=DIVIDE_SYMBOL;

        }
        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
  //      return "The result of the request: '"+ statement + "' is: "+ result;
    }
}