package edu.austral.ingsis.math.composite.fun;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Power implements Function {
    private final Function base;
    private final Function exponent;

    public Power(Function base, Function exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }

    @Override
    public String print() {
        return "(" + base.print() + " ^ " + exponent.print() + ")";
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
    }

}
