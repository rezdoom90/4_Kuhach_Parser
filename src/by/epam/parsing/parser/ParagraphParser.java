package by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.entity.TextDataType;
import by.epam.parsing.exception.IllegalParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

import static org.apache.logging.log4j.Level.INFO;

public class ParagraphParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();

    private LinkedList<TextData> parse(TextData textData) {
        LinkedList<TextData> paragraphs;
        final String REGEX = "(?m)(?!\\A)(?=^\\s{4})";

        paragraphs = new LinkedList<TextData>();
        String[] par = textData.getText().split(REGEX);
        for (int i = 0; i < par.length; i++) {
            TextData td = new TextData(TextDataType.PARAGRAPH, par[i]);
            paragraphs.add(td);
        }

        logger.log(INFO, "Paragraph parsing done.");
        return paragraphs;
    }

    @Override
    public LinkedList<TextData> parseComponents(TextData textData) throws IllegalParserException {
        LinkedList<TextData> list = null;

        if(PARAGRAPH <= textData.getType().getId()){
            list = parse(textData);
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
