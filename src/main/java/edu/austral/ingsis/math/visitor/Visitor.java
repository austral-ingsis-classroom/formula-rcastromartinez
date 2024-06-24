package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.fun.*;

public interface Visitor<T> {
     T visit(Add add);
     T visit(Sub sub);
     T visit(Multi mult);
     T visit(Div div);
     T visit(Variable variable);
     T visit(Abs abs);
     T visit(Num num);
     T visit(SRoot sRoot);
     T visit(Power power);
}
