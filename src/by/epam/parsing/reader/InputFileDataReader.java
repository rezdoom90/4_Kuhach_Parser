package by.epam.parsing.reader;

import by.epam.parsing.exception.MissingFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.logging.log4j.Level.INFO;

public class InputFileDataReader {
	static Logger logger = LogManager.getLogger();

	public static String getFileData (String path) throws MissingFileException {
		final String DATA_PATH = "data/input.txt"; //input file path
		String s;

		try {
			if (path.isEmpty()) {
				logger.log(INFO, "Input string is empty. Using default.");
				s = new String(Files.readAllBytes(Paths.get(DATA_PATH)), StandardCharsets.UTF_8);
			} else {
				logger.log(INFO, "Using input string.");
				s = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
			}
		} catch (IOException e) {
			throw new MissingFileException("Can't find the file!");
		}

		return s;
	}
}
