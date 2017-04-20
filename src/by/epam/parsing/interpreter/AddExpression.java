package by.epam.parsing.interpreter;

public class AddExpression extends NonTerminalExpression{
    public int evaluate(Context c) {
        return getLeftNode().evaluate(c) + getRightNode().evaluate(c);
    }

    public AddExpression(Expression l, Expression r) {
        super(l, r);
    }
}
