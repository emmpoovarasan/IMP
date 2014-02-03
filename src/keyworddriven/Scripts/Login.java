/**
 * 
 */
package keyworddriven.Scripts;

import junit.framework.TestCase;
import keyworddriven.Logs.GetLogger;
import keyworddriven.UtilFunctions.DefinedValuesFromGetProperties;
import keyworddriven.UtilFunctions.DriveKeywords;
import keyworddriven.UtilFunctions.ExtractDataFromExcel;

import org.junit.Before;
import org.junit.Test;

/**
 * @author POO
 *
 */
public class Login extends TestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//"src\\DataFiles\\KeywordDriven.xls"
		@SuppressWarnings("unused")
		ExtractDataFromExcel eExcel = new ExtractDataFromExcel(DefinedValuesFromGetProperties.getExcelFilePath());
		GetLogger.fileLogger("Got File Name : "+getClass().getName());
	}

	@Test
	public void testLogin() {
		DriveKeywords.doDriveKeywords(ExtractDataFromExcel.getDataFromExcelSheet(DefinedValuesFromGetProperties.getLoginSheetName()));
		GetLogger.fileLogger("Got Sheet Name : "+getClass().getName());
		//fail("Not yet implemented");
	}

}
