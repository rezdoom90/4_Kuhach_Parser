package by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.entity.TextDataType;
import by.epam.parsing.exception.IllegalParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

import static org.apache.logging.log4j.Level.INFO;

public class TokenParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();

    private LinkedList<TextData> parse(String text) {
        LinkedList<TextData> tokens;
        final String REGEX = "\\s+";

        tokens = new LinkedList<TextData>();
        String[] sen = text.split(REGEX);
        for (int i = 0; i < sen.length; i++) {
            TextData td = new TextData(TextDataType.TOKEN, sen[i]+" ");
            tokens.add(td);
        }

        logger.log(INFO, "Token parsing done.");
        return tokens;
    }

    @Override
    public LinkedList<TextData> parseComponents(TextData textData) throws IllegalParserException {
        LinkedList<TextData> list = null;

        if(TOKEN <= textData.getType().getId()){
            list = parse(textData.getText());
        } else {
            throw new IllegalParserException();
        }
        if(next != null){
            for(int i = 0; i < list.size(); i++){
                LinkedList<TextData> li = next.parseComponents(list.get(i));
                list.get(i).setTextComponents(li);
            }
        }

        return list;
    }
}
