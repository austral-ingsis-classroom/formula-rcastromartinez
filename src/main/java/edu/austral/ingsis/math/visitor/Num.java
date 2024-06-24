package edu.austral.ingsis.math.visitor;

public class Num implements Function {
    private final Double value;

    public Num(Double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
