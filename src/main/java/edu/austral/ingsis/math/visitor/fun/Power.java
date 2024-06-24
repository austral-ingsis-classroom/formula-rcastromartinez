package edu.austral.ingsis.math.visitor.fun;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Function {
    private final Function function;
    private final Function power;

    public Power(Function function, Function power) {
        this.function = function;
        this.power = power;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }

    public Function getFunction() {
        return function;
    }

    public Function getPower() {
        return power;
    }
}
