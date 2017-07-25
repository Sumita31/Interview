package Testing.calculator;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PositiveTwoCalculatorTest {

    private PositiveTwoCalculator positiveTwoCalculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This is beforeclass");
    }

    @AfterClass
    public static void afterclass() {
        System.out.println("This is afterclass");
    }

    @Before
    public void setup() {
        System.out.println("This is setup");
        positiveTwoCalculator = new PositiveTwoCalculator();
    }

    @After
    public void tearDown() {
        System.out.println("This is tearDown");
        positiveTwoCalculator = null;
    }

    @Test
    public void testFirstArgIsNull() throws InvalidCalculationException {
        Operation operation = mock(Operation.class);
        try {
            positiveTwoCalculator.calculate(null, new Integer(1), operation);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void secondArgIsNull() throws InvalidCalculationException {
        Operation operation = mock(Operation.class);
        try {
            positiveTwoCalculator.calculate(new Integer(1), null, operation);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void opIsNull() throws InvalidCalculationException {
        Number output = positiveTwoCalculator.calculate(new Integer(1), new Integer(1), null);
        assertEquals(-1, output.intValue());
    }

    @Test
    public void testCorrectReturn() throws InvalidCalculationException {
        Number num1 = mock(Number.class);
        Number num2 = mock(Number.class);
        Operation operation = mock(Operation.class);
        positiveTwoCalculator.calculate(num1, num2, operation);
        verify(operation).op(num1, num2); // on mock objects
    }

    @Test
    public void testReturnCorrectValue() throws InvalidCalculationException {
        Number num1 = mock(Number.class);
        Number num2 = mock(Number.class);
        Number result = mock(Number.class);

        Operation operation = mock(Operation.class);
        when(operation.op(num1, num2)).thenReturn(result); //stubbing

        Number output = positiveTwoCalculator.calculate(num1, num2, operation);
        assertEquals(result, output);
    }


}