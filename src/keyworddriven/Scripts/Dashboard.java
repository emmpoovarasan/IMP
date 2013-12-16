/**
 * 
 */
package keyworddriven.Scripts;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import keyworddriven.UtilFunctions.DefinedValuesFromGetProperties;
import keyworddriven.UtilFunctions.DriveKeywords;
import keyworddriven.UtilFunctions.ExtractDataFromExcel;

import org.junit.Before;
import org.junit.Test;

/**
 * @author POO
 *
 */
public class Dashboard extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ExtractDataFromExcel eExcel = new ExtractDataFromExcel(DefinedValuesFromGetProperties.getExcelFilePath());
	}

	@Test
	public void testDashboard() {
		DriveKeywords.doDriveKeywords(ExtractDataFromExcel.getDataFromExcelSheet(DefinedValuesFromGetProperties.getDashboardSheetName()));
		//fail("Not yet implemented");
	}

}
