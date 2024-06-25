package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.VisitorEvaluate;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  private final Visitor<Double> visitor = new VisitorEvaluate();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {

    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Add(new edu.austral.ingsis.math.visitor.Num(1.0), new edu.austral.ingsis.math.visitor.Num(6.0)));

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(12.0), new edu.austral.ingsis.math.visitor.Num(2.0)));

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(9.0), new edu.austral.ingsis.math.visitor.Num(2.0)), new edu.austral.ingsis.math.visitor.Num(3.0)));

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Power(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(27.0), new edu.austral.ingsis.math.visitor.Num(6.0)), new edu.austral.ingsis.math.visitor.Num(2.0)));

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Power(new edu.austral.ingsis.math.visitor.Num(36.0), new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(1.0), new edu.austral.ingsis.math.visitor.Num(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.Num(136.0)));

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.Num(0.0), new edu.austral.ingsis.math.visitor.Num(136.0))));

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.Num(5.0), new edu.austral.ingsis.math.visitor.Num(5.0)), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(0d));
  }
}
