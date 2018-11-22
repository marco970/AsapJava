package aSap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RaportExcell {
	
	public RaportExcell() throws IOException	{
		
		int year = 2018;
		int month = 2;
		int rowNumber = 9;
		CalendarTest ct = new CalendarTest(year, month);
		int dniMies = ct.getDayNo(month);
		
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Kupiec");
		sheet.autoSizeColumn(2);  
		
		HSSFCellStyle cs = workbook.createCellStyle();
		cs.setWrapText(true);
		
		//generowanie wierszy i komórek
		//ArrayList<HSSFRow> rowList = new ArrayList<HSSFRow>();
		//ArrayList<HSSFCell> cellList = new ArrayList<HSSFCell>();
		
		HSSFRow[] rowArr = new HSSFRow[rowNumber]; //robię na listach, to do wywalenia
		HSSFCell[][] cellArr = new HSSFCell[rowNumber][dniMies*2+3];
		
		//wygenerowanie wierszy i komórek
		//i - wiersze
		//j - kolumny
		System.out.println(dniMies+"-"+(dniMies*2-1+3)+"-"+rowNumber);
		for (int i=0; i<=rowNumber-1; i++)	{
			rowArr[i]=sheet.createRow(i);
			//rowArr[i].setHeightInPoints(100);
			//System.out.print(i+"--"+rowArr[i].toString());
			for(int j = 0; j<=dniMies*2-1+3; j++)	{
				//System.out.println(i+"*"+j);
				cellArr[i][j] = rowArr[i].createCell(j);
				cellArr[i][j].setCellStyle(cs);
			}
		}
			
		//
		
		//sheet.addMergedRegion(new CellRangeAddress(1,1,2,3));
		//sheet.addMergedRegion(new CellRangeAddress(1,1,4,5));
		//sheet.addMergedRegion(new CellRangeAddress(1,4,1,5));
		
		//generowanie paska z datami
		int l=1;
		for (int j = 2; j<=dniMies*2-1+2; j=j+2)	{
			cellArr[0][j+1].setCellValue(ct.getDayName(l));
			cellArr[1][j].setCellValue(ct.getDate(l));
			l++;
			sheet.addMergedRegion(new CellRangeAddress(1,1,j,j+1));
			cellArr[2][j].setCellValue("liczba\ngodzin");
			cellArr[2][j+1].setCellValue("opis postępowania\nlub nr z systemu");
			sheet.setColumnWidth(j+1, 5000);
			
		}
		
		
		
		
		
		workbook.write(new FileOutputStream(month+"Raport.xls"));
		workbook.close();	//ostatni wiersz
	}
	public static void main(String[] args) throws IOException	{
		new RaportExcell();
		//do testów, potem wywalić metodę
	}
}
