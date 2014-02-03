package keyworddriven.Logs;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GetLogger {
	static Logger logs = Logger.getLogger("My Log");
	static FileHandler fh;
	
	public static String fileLogger(String message){
		try {
			fh = new FileHandler("E:\\myloger.log");
			logs.addHandler(fh);
			SimpleFormatter formater = new SimpleFormatter();
			fh.setFormatter(formater);
			//logs.setUseParentHandlers(false);
			/*logs.info("My First Log");
			
			logs.info("Second message");*/
			logs.info(message);
			
		} catch (Exception e) {
			logs.info(e.getMessage());
		}
		return message;
	}
}
