package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.VisitorPrint;
import org.junit.jupiter.api.Test;

public class PrintTest {

  private final Visitor<String> visitor = new VisitorPrint();

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1 + 6)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Add(new edu.austral.ingsis.math.visitor.Num(1.0), new edu.austral.ingsis.math.visitor.Num(6.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12 / 2)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(12.0), new edu.austral.ingsis.math.visitor.Num(2.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9 / 2) * 3)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(9.0), new edu.austral.ingsis.math.visitor.Num(2.0)), new edu.austral.ingsis.math.visitor.Num(3.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27 / 6) ^ 2)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Power(new edu.austral.ingsis.math.visitor.fun.Div(new edu.austral.ingsis.math.visitor.Num(27.0), new edu.austral.ingsis.math.visitor.Num(6.0)), new edu.austral.ingsis.math.visitor.Num(2.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.Variable("value")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(|value| - 8)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.fun.Abs(new edu.austral.ingsis.math.visitor.Variable("value")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5 - i) * 8)";
    final String result = visitor.visit(new edu.austral.ingsis.math.visitor.fun.Multi(new edu.austral.ingsis.math.visitor.fun.Sub(new edu.austral.ingsis.math.visitor.Num(5.0), new edu.austral.ingsis.math.visitor.Variable("i")), new edu.austral.ingsis.math.visitor.Num(8.0)));

    assertThat(result, equalTo(expected));
  }
}
