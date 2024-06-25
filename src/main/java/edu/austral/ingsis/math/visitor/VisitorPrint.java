package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.fun.*;

public class VisitorPrint implements Visitor<String> {
  @Override
  public String visit(Add add) {
    return "(" + add.getLeft().accept(this) + " + " + add.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Sub sub) {
    return "(" + sub.getLeft().accept(this) + " - " + sub.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Multi mult) {
    return "(" + mult.getLeft().accept(this) + " * " + mult.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Div div) {
    return "(" + div.getLeft().accept(this) + " / " + div.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Variable variable) {
    return variable.getName();
  }

  @Override
  public String visit(Abs abs) {
    return "|" + abs.getFunction().accept(this) + "|";
  }

  @Override
  public String visit(Num num) {
    return correctValue(num.getValue());
  }

  @Override
  public String visit(SRoot sRoot) {
    return "sqrt(" + sRoot.getFunction().accept(this) + ")";
  }

  @Override
  public String visit(Power power) {
    return "(" + power.getFunction().accept(this) + " ^ " + power.getPower().accept(this) + ")";
  }

  public String correctValue(Double value) {
    if (value % 1 == 0) {
      return String.valueOf(value.intValue());
    } else {
      return String.valueOf(value);
    }
  }
}
