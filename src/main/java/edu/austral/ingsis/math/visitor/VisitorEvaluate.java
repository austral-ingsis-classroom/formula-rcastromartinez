package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.fun.*;
import java.util.Map;

public class VisitorEvaluate implements Visitor<Double> {
  private final Map<String, Double> variables;

  public VisitorEvaluate(Map<String, Double> variables) {
    this.variables = variables;
  }

  public VisitorEvaluate() {
    this.variables = Map.of();
  }

  @Override
  public Double visit(Add add) {
    return add.getLeft().accept(this) + add.getRight().accept(this);
  }

  @Override
  public Double visit(Sub sub) {
    return sub.getLeft().accept(this) - sub.getRight().accept(this);
  }

  @Override
  public Double visit(Multi mult) {
    return mult.getLeft().accept(this) * mult.getRight().accept(this);
  }

  @Override
  public Double visit(Div div) {
    return div.getLeft().accept(this) / div.getRight().accept(this);
  }

  @Override
  public Double visit(Variable variable) {
    return variables.get(variable.getName());
  }

  @Override
  public Double visit(Abs abs) {
    return Math.abs(abs.getFunction().accept(this));
  }

  @Override
  public Double visit(Num num) {
    return num.getValue();
  }

  @Override
  public Double visit(SRoot sRoot) {
    return Math.sqrt(sRoot.getFunction().accept(this));
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getFunction().accept(this), power.getPower().accept(this));
  }

  public VisitorEvaluate withVariable(Map<String, Double> variables) {
    return new VisitorEvaluate(variables);
  }
}
