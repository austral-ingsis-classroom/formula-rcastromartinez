package edu.austral.ingsis.math.visitor.fun;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Add implements Function {
    private final Function left;
    private final Function right;

    public Add(Function left, Function right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }
}
