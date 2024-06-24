package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.List;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.GetVisitorVariable;
import edu.austral.ingsis.math.visitor.Num;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.fun.Add;
import edu.austral.ingsis.math.visitor.fun.Div;
import edu.austral.ingsis.math.visitor.fun.Multi;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = Collections.emptyList();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Div(new Num(12.0), new Variable("div"));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function = new Multi(new Div(new Num(9.0), new Variable("x")), new Variable("y"));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function = new Add(new Variable("a"), new Variable("b"));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function = new Multi(new Variable("z"), new Div(new Num(1.0), new Num(2.0)));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Add(new Variable("value"), new Num(8.0));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Add(new Variable("value"), new Num(8.0));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function = new Multi(new Add(new Num(5.0), new Variable("i")), new Num(8.0));
    final List<String> result = new GetVisitorVariable().getVariables(function);

    assertThat(result, containsInAnyOrder("i"));
  }
}
