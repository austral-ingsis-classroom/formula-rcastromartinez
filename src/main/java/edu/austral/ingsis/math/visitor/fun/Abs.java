package edu.austral.ingsis.math.visitor.fun;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Abs implements Function {
  private final Function function;

  public Abs(Function function) {
    this.function = function;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getFunction() {
    return function;
  }
}
