package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.fun.*;

import java.util.List;

public class GetVisitorVariable implements Visitor<List<String>>{

    @Override
    public List<String> visit(Add add) {
        return List.of();
    }

    @Override
    public List<String> visit(Sub sub) {
        return List.of();
    }

    @Override
    public List<String> visit(Multi mult) {
        return List.of();
    }

    @Override
    public List<String> visit(Div div) {
        return List.of();
    }

    @Override
    public List<String> visit(Variable variable) {
        return List.of();
    }

    @Override
    public List<String> visit(Abs abs) {
        return List.of();
    }

    @Override
    public List<String> visit(Num num) {
        return List.of();
    }

    @Override
    public List<String> visit(SRoot sRoot) {
        return List.of();
    }
}
