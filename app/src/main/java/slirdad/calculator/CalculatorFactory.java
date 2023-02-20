package slirdad.calculator;

public class CalculatorFactory {
    final private Calculator calculator = new Calculator();

    public Calculator getCalculator() {
        return calculator;
    }
}
