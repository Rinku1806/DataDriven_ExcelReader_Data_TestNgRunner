package utilities;

import org.json.simple.JSONObject;

import util.Xls_Reader;


public class ReadingXLS {

	public static void main(String[] args) {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\jsons\\xls_data\\Data.xlsx";
		Xls_Reader xls = new Xls_Reader(filePath);
		String sheetName="Stock Suite";
		String flag="addfreshstock";
		int iterationNumber=1;
		JSONObject data =new ReadingXLS().getTestData(sheetName, flag, iterationNumber, filePath);
		System.out.println(data);
		

	}
	@SuppressWarnings("unchecked")
	public JSONObject getTestData(String sheetName,String flag,int iterationNumber,String xlsFilePath) {
		Xls_Reader xls = new Xls_Reader(xlsFilePath);
		int flagRowNumber=1;
		while(!xls.getCellData(sheetName, 0, flagRowNumber).equals(flag)) {
			flagRowNumber++;
		}
		System.out.println("Flag Row Number "+ flagRowNumber);
		int colNamesRowNumber = flagRowNumber+1;
		int dataStartRomNumber = flagRowNumber+2;
		int index=1;
		while(!xls.getCellData(sheetName, 0, dataStartRomNumber).equals("")) {
			int colIndex=0;
			if(index == iterationNumber) {
				JSONObject json = new JSONObject();
				while(!xls.getCellData(sheetName, colIndex , colNamesRowNumber).equals("")) {
					String data = xls.getCellData(sheetName, colIndex, dataStartRomNumber);
					String colName=xls.getCellData(sheetName, colIndex, colNamesRowNumber);
					//System.out.println(colName+" -- "+data);
					json.put(colName, data);
					colIndex++;
				}
				return json;
			}else
				index++;
			
			System.out.println("-------");
			dataStartRomNumber++;
		}
		return new JSONObject();
	}

	public int getTestDataSets(String xlsFilePath, String dataflag, String sheetName) {
		Xls_Reader xls = new Xls_Reader(xlsFilePath);
		int flagRowNumber=1;
		while(!xls.getCellData(sheetName, 0, flagRowNumber).equals(dataflag)) {
			flagRowNumber++;
		}
		System.out.println("Flag Row Number "+ flagRowNumber);
		
		int dataStartRomNumber = flagRowNumber+2;
		int totalRows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRomNumber).equals("")) {
			totalRows++;
			dataStartRomNumber++;
		}
		System.out.println("Total Rows " + totalRows);
		return totalRows;
	}

}
