package edu.austral.ingsis.math.composite.fun;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Sub implements Function {
    private final Function left;
    private final Function right;

    public Sub(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }

    @Override
    public String print() {
        return "(" + left.print() + " - " + right.print() + ")";
    }

    @Override
    public double evaluate(Map<String, Double> values) {
        return left.evaluate(values) - right.evaluate(values);
    }
}
