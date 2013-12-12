/**
 * 
 */
package keyworddriven.Scripts;

import static org.junit.Assert.*;
import keyworddriven.UtilFunctions.DefinedValuesFromGetProperties;
import keyworddriven.UtilFunctions.DriveKeywords;
import keyworddriven.UtilFunctions.ExtractDataFromExcel;

import org.junit.Before;
import org.junit.Test;

/**
 * @author POO
 *
 */
public class Dashboard {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ExtractDataFromExcel eExcel = new ExtractDataFromExcel(DefinedValuesFromGetProperties.getExcelFilePath());
	}

	@Test
	public void test() {
		DriveKeywords.doDriveKeywords(ExtractDataFromExcel.getDataFromExcelSheet("Sheet2"));
		//fail("Not yet implemented");
	}

}
