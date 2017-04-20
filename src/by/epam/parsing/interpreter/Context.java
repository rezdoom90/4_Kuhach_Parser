package by.epam.parsing.interpreter;

import java.util.HashMap;

public class Context {
    private HashMap varList = new HashMap();

    public void assign(String var, int value) {
        varList.put(var, new Integer(value));
    }

    public int getValue(String var) {
        Integer objInt = (Integer) varList.get(var);
        return objInt.intValue();
    }

    public Context() {
        initialize();
    }

    private void initialize() {
        assign("i", 20);
        assign("j", 40);
    }
}
