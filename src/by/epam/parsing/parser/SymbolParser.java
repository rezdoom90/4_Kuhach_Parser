package by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.entity.TextDataType;
import by.epam.parsing.exception.IllegalParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.logging.log4j.Level.INFO;

public class SymbolParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();

    private LinkedList<TextData> parse(String text) {
        LinkedList<TextData> symbols;
        final String REGEX = ".|\\s";

        symbols = new LinkedList<TextData>();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        while (m.find()) {
            TextData td = new TextData(TextDataType.SYMBOL, m.group());
            symbols.add(td);
        }

        logger.log(INFO, "Symbol parsing done.");
        return symbols;
    }

    @Override
    public LinkedList<TextData> parseComponents(TextData textData) throws IllegalParserException {
        LinkedList<TextData> list = null;

        if(SYMBOL <= textData.getType().getId()){
            list = parse(textData.getText());
        } else {
            throw new IllegalParserException();
        }
        if(next != null){
            throw new IllegalParserException();
        }

        return list;
    }
}
