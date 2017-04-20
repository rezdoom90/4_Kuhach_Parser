package by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.exception.IllegalParserException;

import java.util.LinkedList;

public abstract class AbstractParser {
    protected AbstractParser next;
    protected static final int PARAGRAPH = 4;
    protected static final int SENTENCE = 3;
    protected static final int TOKEN = 2;
    protected static final int SYMBOL = 1;


    public AbstractParser(){
    }

    public void setNext(AbstractParser next){
        this.next = next;
    }

    public abstract LinkedList<TextData> parseComponents(TextData textData) throws IllegalParserException;
}
