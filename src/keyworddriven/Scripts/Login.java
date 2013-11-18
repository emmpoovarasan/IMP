/**
 * 
 */
package keyworddriven.Scripts;

import static org.junit.Assert.*;
import junit.framework.TestCase;
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
		ExtractDataFromExcel eExcel = new ExtractDataFromExcel("src\\DataFiles\\KeywordDriven.xls");
	}

	@Test
	public void testLogin() {
		DriveKeywords.doDriveKeywords(ExtractDataFromExcel.getDataFromExcelSheet("Sheet1"));
		//fail("Not yet implemented");
	}

}
