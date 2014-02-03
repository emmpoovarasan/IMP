package keyworddriven.UtilFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DefinedValuesFromGetProperties {
	
	private static String getPropertiesFilePath(){
		String configFilePath = null;
		String current;
		try {
			current = new java.io.File(".").getCanonicalPath();
			// until IMP folder
			System.out.println("current Path is "+current);
			configFilePath = current+"\\src\\DataFiles\\config.properties";
			// if needed use the below comment section here.
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			configFilePath = null;
		}
		return configFilePath;
	}
	
	public static String getExcelFilePath(){
		String filePath = null;
		Properties prop = new Properties();
		try {
			//"C:\\Users\\POO\\git\\IMP\\src\\DataFiles\\config.properties"
			prop.load(new FileInputStream(getPropertiesFilePath()));
			filePath = prop.getProperty("ExcelFilePath");
			System.out.println(filePath);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return filePath;
	}
	
	public static String getLoginSheetName(){
		String loginSheetName = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(getPropertiesFilePath()));
			loginSheetName = prop.getProperty("loginSheetName");
			System.out.println(loginSheetName);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return loginSheetName;
	}
	
	public static String getDashboardSheetName(){
		String dashboardSheetName = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(getPropertiesFilePath()));
			dashboardSheetName = prop.getProperty("dashboardSheetName");
			System.out.println(dashboardSheetName);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dashboardSheetName;
	}
	
	public static String getDriverName(String KeyName){
		String driverNamePath = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(getPropertiesFilePath()));
			driverNamePath = prop.getProperty(KeyName);
			System.out.println(driverNamePath);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driverNamePath;
	}

}

//comment automated code.
			/*File f = new File(current);
			String[] folders = f.list();
			for(String folder : folders){
				if(new File(current+"\\"+folder).isDirectory()){
					// inside IMP folder - reading such as src, bin, Drivers, libs etc.. 
					System.out.println("This Directory "+folder);
					
					if("src".equalsIgnoreCase(folder)){
						File f1 = new File(current+"\\"+folder);
						String[] insideFolders = f1.list();
						
						for(String insideFolder : insideFolders){
							if(new File((current+"\\"+folder+"\\"+insideFolder)).isDirectory()){
								// until IMP/src/DataFiles folder and reads all files 
								System.out.println("Get Abs path "+f1.getAbsolutePath() + "insideFolder "+insideFolder);
								
								if("DataFiles".equalsIgnoreCase(insideFolder)){
									File f2 = new File(current+"\\"+folder+"\\"+insideFolder);
									String[] f2InsideFiles = f2.list();
									for(String f2InsideFile : f2InsideFiles){
										// until IMP/src/DataFiles folder and reads all files
										if(new File(current+"\\"+folder+"\\"+insideFolder+"\\"+f2InsideFile).isFile()){
											System.out.println("This is files "+f2InsideFile);
											if("config.properties".equalsIgnoreCase(f2InsideFile)){
												configFilePath = current+"\\"+folder+"\\"+insideFolder+"\\"+f2InsideFile;
											}
										}
									}
								}
								
							}
						}
					}
					
				}
			}*/
