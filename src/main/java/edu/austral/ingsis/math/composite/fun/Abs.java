package edu.austral.ingsis.math.composite.fun;

import edu.austral.ingsis.math.composite.Function;
import java.util.List;
import java.util.Map;

public class Abs implements Function {
  private final Function function;

  public Abs(Function function) {
    this.function = function;
  }

  @Override
  public List<String> getVariables() {
    return function.getVariables();
  }

  @Override
  public String print() {
    return "|" + function.print() + "|";
  }

  @Override
  public double evaluate(Map<String, Double> values) {
    return Math.abs(function.evaluate(values));
  }
}
