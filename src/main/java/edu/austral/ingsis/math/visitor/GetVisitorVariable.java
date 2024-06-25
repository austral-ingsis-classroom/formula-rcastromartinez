package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.fun.*;
import java.util.ArrayList;
import java.util.List;

public class GetVisitorVariable implements Visitor<List<String>> {

  @Override
  public List<String> visit(Add add) {
    return execute(add.getLeft(), add.getRight());
  }

  @Override
  public List<String> visit(Sub sub) {
    return execute(sub.getLeft(), sub.getRight());
  }

  @Override
  public List<String> visit(Multi mult) {
    return execute(mult.getLeft(), mult.getRight());
  }

  @Override
  public List<String> visit(Div div) {
    return execute(div.getLeft(), div.getRight());
  }

  @Override
  public List<String> visit(Variable variable) {
    return List.of(variable.getName());
  }

  @Override
  public List<String> visit(Abs abs) {
    return abs.getFunction().accept(this);
  }

  @Override
  public List<String> visit(Num num) {
    return List.of();
  }

  @Override
  public List<String> visit(SRoot sRoot) {
    return sRoot.getFunction().accept(this);
  }

  @Override
  public List<String> visit(Power power) {
    return execute(power.getFunction(), power.getPower());
  }

  public List<String> execute(Function left, Function right) {
    List<String> leftVariables = left.accept(this);
    List<String> rightVariables = right.accept(this);
    List<String> variables = new ArrayList<>();
    variables.addAll(leftVariables);
    variables.addAll(rightVariables);
    return variables;
  }

  public List<String> getVariables(Function function) {
    return function.accept(this);
  }
}
