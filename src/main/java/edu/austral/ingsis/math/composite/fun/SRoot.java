package edu.austral.ingsis.math.composite.fun;

import edu.austral.ingsis.math.composite.Function;
import java.util.List;
import java.util.Map;

public class SRoot implements Function {
  private final Function function;

  public SRoot(Function function) {
    this.function = function;
  }

  @Override
  public List<String> getVariables() {
    return List.of();
  }

  @Override
  public String print() {
    return "√(" + function.print() + ")";
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return Math.sqrt(function.evaluate(variables));
  }
}
