package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
  List<String> getVariables();

  String print();

  double evaluate(Map<String, Double> variables);
}
