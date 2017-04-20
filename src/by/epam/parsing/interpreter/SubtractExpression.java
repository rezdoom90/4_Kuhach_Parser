package by.epam.parsing.interpreter;

public class SubtractExpression extends NonTerminalExpression {
    @Override
    public int evaluate(Context c) {
        return getLeftNode().evaluate(c) - getRightNode().evaluate(c);
    }

    public SubtractExpression(Expression l, Expression r) {
        super(l, r);
    }
}
