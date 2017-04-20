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

public class SentenceParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();

    private LinkedList<TextData> parse(String text) {
        LinkedList<TextData> sentences;
        final String REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

        sentences = new LinkedList<TextData>();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        while (m.find()) {
            TextData td = new TextData(TextDataType.SENTENCE, m.group());
            sentences.add(td);
        }

        logger.log(INFO, "Sentence parsing done.");
        return sentences;
    }

    @Override
    public LinkedList<TextData> parseComponents(TextData textData) throws IllegalParserException {
        LinkedList<TextData> list = null;

        if(SENTENCE <= textData.getType().getId()){
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
