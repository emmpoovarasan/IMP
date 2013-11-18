package keyworddriven.Logs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GetLogger {
	static Logger logger = Logger.getLogger("");
	
public static Logger fileLogger(String message){
	logger.setLevel(Level.OFF);
	return logger.getLogger(message);
}
}
