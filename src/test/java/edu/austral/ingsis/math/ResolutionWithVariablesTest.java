package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.VisitorEvaluate;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ResolutionWithVariablesTest {

  private final VisitorEvaluate VariablesVisitor = new VisitorEvaluate();

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("x", 3d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Add(new edu.austral.ingsis.math.visitor.Num(1.0), new edu.austral.ingsis.math.visitor.Variable("x")));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("div", 4d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(12.0), new edu.austral.ingsis.math.visitor.Variable("div")));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("x", 3d, "y", 4d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(9.0), new edu.austral.ingsis.math.visitor.Variable("x")), new edu.austral.ingsis.math.visitor.Variable("y")));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("a", 9d, "b", 3d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Power(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(27.0), new edu.austral.ingsis.math.visitor.Variable("a")), new edu.austral.ingsis.math.visitor.Variable("b")));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("z", 36d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Power(new edu.austral.ingsis.math.visitor.Variable("z"), new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(1.0), new edu.austral.ingsis.math.visitor.Num(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("value", 8d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.Variable("value")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("value", 8d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.Variable("value")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    VisitorEvaluate visitor = VariablesVisitor.withVariable(Map.of("i", 2d));
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.Num(5.0), new edu.austral.ingsis.math.visitor.Variable("i")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(24d));
  }
}
