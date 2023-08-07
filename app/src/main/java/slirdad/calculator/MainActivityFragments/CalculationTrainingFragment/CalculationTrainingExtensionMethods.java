package slirdad.calculator.MainActivityFragments.CalculationTrainingFragment;

import java.util.Random;

import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Calculator;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.CalculatorData;
import slirdad.calculator.MainActivityFragments.CalculatorFragment.Domain.Operation;

public class CalculationTrainingExtensionMethods {

    public static int getRandomInteger() {
        return (int) (Math.random() * 100);
    }

    public static Operation getRandomOperation() {
        Operation[] operations = Operation.values();
        return operations[new Random().nextInt(operations.length - 1)];
    }

    public static double calculate(CalculationTrainingViewHolder viewHolder, Calculator calculator, Operation operation) {
        String s = viewHolder.getFirstNumTextView().getText().toString();
        calculator.setResult(Double.parseDouble(s));
        calculator.setCurrentOperation(operation);
        CalculatorData calculatorData = calculator.operate(
                Double.parseDouble(viewHolder.getSecondNumTextView().getText().toString()),
                Operation.NONE, () -> {
        });
        return calculatorData.result;
    }
}
