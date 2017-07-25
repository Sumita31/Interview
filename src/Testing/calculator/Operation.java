package Testing.calculator;

public interface Operation {

    Number op(Number num1, Number...numbers) throws InvalidCalculationException;
}
