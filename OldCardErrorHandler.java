package validator;

import java.io.IOException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class OldCardErrorHandler extends DefaultHandler {

	public OldCardErrorHandler(String log) throws IOException {
		// установка файла и формата вывода ошибок
		// logger.addAppender(new FileAppender(new SimpleLayout(), log));
	}

	public void warning(SAXParseException e) {
		System.out.print(getLineAddress(e) + "-" + e.getMessage());
	}

	public void error(SAXParseException e) {
		System.out.print(getLineAddress(e) + " - " + e.getMessage());
	}

	public void fatalError(SAXParseException e) {
		System.out.print(getLineAddress(e) + " - " + e.getMessage());
	}

	private String getLineAddress(SAXParseException e) {
		// определение строки и столбца ошибки
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
}
