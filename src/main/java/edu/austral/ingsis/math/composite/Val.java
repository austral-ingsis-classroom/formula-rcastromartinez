package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Val implements Function{
    private final double value;

    public Val(double value) {
        this.value = value;
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }

    @Override
    public String print() {
        if (value % 1 == 0) {
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }

    @Override
    public double evaluate(Map<String, Double> values){
        return value;
    }
}
