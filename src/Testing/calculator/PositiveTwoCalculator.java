package Testing.calculator;

public class PositiveTwoCalculator implements Calculator {

    public Number calculate(Number num1, Number num2, Operation operation)
            throws InvalidCalculationException {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Numbers cannot be null");
        }
        if ((num1.doubleValue() < 0) || (num2.doubleValue() < 0)) {
            throw new IllegalArgumentException("Numbers cannot be negative");
        }
        if(operation == null) return -1;

        return operation.op(num1, num2);
    }
}
