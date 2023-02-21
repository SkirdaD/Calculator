package slirdad.calculator;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorFactory {
    public static Calculator getCalculator() {
        return new Calculator();
    }
}
