package test.by.epam.parsing.parser;

import by.epam.parsing.entity.TextData;
import by.epam.parsing.exception.IllegalParserException;
import by.epam.parsing.exception.MissingFileException;
import by.epam.parsing.parser.AbstractParser;
import by.epam.parsing.parser.ParagraphParser;
import by.epam.parsing.reader.InputFileDataReader;
import org.junit.Before;
import org.junit.Test;

import static by.epam.parsing.entity.TextDataType.TEXT;
import static org.junit.Assert.assertTrue;

public class ParagraphParserTest {
    TextData textData;

    @Before
    public void initialize() throws MissingFileException, IllegalParserException {
        textData = new TextData(TEXT, InputFileDataReader.getFileData(""));
        AbstractParser parser1 = new ParagraphParser();

        textData.setTextComponents(parser1.parseComponents(textData));
    }

    @Test
    public void parseTest_FourParagraphsFound() {
        assertTrue(textData.getTextComponents().size() == 4);
    }
}
