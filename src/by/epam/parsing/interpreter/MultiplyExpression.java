package by.epam.parsing.interpreter;

public class MultiplyExpression extends NonTerminalExpression {
    public MultiplyExpression(Expression l, Expression r) {
        super(l, r);
    }
    public int evaluate(Context c) {
        return getLeftNode().evaluate(c) * getRightNode().evaluate(c);
    }
}
