package test.by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.exception.IllegalParserException;
import by.epam.parsing.exception.MissingFileException;
import by.epam.parsing.parser.AbstractParser;
import by.epam.parsing.parser.ParagraphParser;
import by.epam.parsing.parser.SentenceParser;
import by.epam.parsing.parser.TokenParser;
import by.epam.parsing.reader.InputFileDataReader;
import org.junit.Before;
import org.junit.Test;

import static by.epam.parsing.entity.TextDataType.TEXT;
import static org.junit.Assert.assertTrue;

public class TokenParserTest {
    TextData textData;

    @Before
    public void initialize() throws MissingFileException, IllegalParserException {
        textData = new TextData(TEXT, InputFileDataReader.getFileData(""));
        AbstractParser parser1 = new ParagraphParser();
        AbstractParser parser2 = new SentenceParser();
        AbstractParser parser3 = new TokenParser();
        parser1.setNext(parser2);
        parser2.setNext(parser3);

        textData.setTextComponents(parser1.parseComponents(textData));
    }

    @Test
    public void parseTest_TwoSentencesFound() {
        assertTrue(textData.getComponent(0).getComponent(0).getTextComponents().size() == 21);
    }
}
