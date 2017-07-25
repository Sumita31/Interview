package Testing.calculator;

/**
 * Created by sumitachauhan on 7/4/17.
 */
public interface Calculator {

     Number calculate(Number num1, Number num2, Operation operation) throws InvalidCalculationException;
}
