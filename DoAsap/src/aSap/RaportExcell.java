package aSap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RaportExcell {
	
	public RaportExcell(String kupiec) throws IOException	{
		
		int year = 2018;
		int month = 2;
		int rowNumber = 9;
		CalendarTest ct = new CalendarTest(year, month);
		int dniMies = ct.getDayNo(month);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(kupiec);
		sheet.autoSizeColumn(2);  
		
		HSSFCellStyle cs = workbook.createCellStyle();
		cs.setWrapText(true);
		HSSFCellStyle style = workbook.createCellStyle();
		
		
		Font fontNormal = workbook.createFont();  
		fontNormal.setFontHeightInPoints((short)9);  
		fontNormal.setFontName("Tahoma");  
		
		cs.setFont(fontNormal);  
		
		//generowanie wierszy i komórek
		
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
		//Fonty
		HSSFFont f1 = workbook.createFont();
		f1.setBold(true);
		//f1.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());  
		
		
		Font f2 = workbook.createFont();
		f2.setBold(true);
		f2.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex()); 
		
		Font f3 = workbook.createFont();
		Font f4 = workbook.createFont();
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
		
		//generowanie pierwszych 2 kolumn
			
		sheet.setColumnWidth(0, 10000);
		sheet.setColumnWidth(1, 12000);
		RichTextString c10 = new HSSFRichTextString("Pracownik: "+kupiec);
		cellArr[1][0].setCellValue(c10);
		c10.applyFont(f2);
		
		RichTextString c20 = new HSSFRichTextString("RODZAJ USŁUGI/ ETAP POSTĘPOWANIA");
		cellArr[2][0].setCellValue(c20);
		RichTextString c21 = new HSSFRichTextString("ZAKRES ETAPU POSTĘPOWANIA");
		cellArr[2][1].setCellValue(c21);
		c20.applyFont(f1);
		c21.applyFont(f1);
		
		cellArr[3][0].setCellValue("Realizacja zakupów i wyboru dostawców\n- etap Zlecenie Zakupu (ZZ)");
		cellArr[3][1].setCellValue("Weryfikacja zasadności i trybu dokonania zakupu planowanego przez "
				+ "CP oraz poprawności i kompletności danych "
				+ "wprowadzonych przez komórkę CP inicjująca zakup.");
		rowArr[3].setHeightInPoints(100);
		cellArr[4][0].setCellValue("Realizacja zakupów i wyboru dostawców - etap Postępowanie Zakupowe (PZ)");
		cellArr[4][1].setCellValue("Przygotowanie regulaminów, kryteriów oceny, harmonogramu postępowania itd. "
				+ "\nPrzygotowanie i wysyłanie zapytań informacyjnych/ofertowych na podstawie merytorycznego wkładu CP."
				+ "\nAnaliza i ocena ofert otrzymanych w ramach prowadzonego postępowania, w tym wyjaśnianie z Oferentami szczegółów oferty."
				+ "\nProwadzenie negocjacji z oferentami, w tym ponowna analiza przesłanych ofert po negocjacjach."
				+ "\nPrzygotowanie dokumentacji podsumowującej postępowanie zakupowe oraz wprowadzenie jej do systemu zakupowego");
		
		rowArr[4].setHeightInPoints(150);
		cellArr[5][0].setCellValue("Obsługa umów zakupowych - etap Dokument Końcowy (DK)");
		//cellArr[5][1].setCellValue("");		
		rowArr[5].setHeightInPoints(100);
		cellArr[6][0].setCellValue("Inne");
		cellArr[6][1].setCellValue("Udział w uzgodnieniach i spotkaniach z przedstawicielami CP "
				+ "dotyczących planowanych postępowań zakupowych; przygotowanie danych w ramach  "
				+ "zleconych inicjatyw optymalizacyjnych, analizy rynku dostawców, itp.;");
		rowArr[6].setHeightInPoints(100);
		
		cellArr[7][1].setCellValue("SUMA");
		rowArr[7].setHeightInPoints(25);
		
		workbook.write(new FileOutputStream(month+"_Raport.xls"));
		workbook.close();	//ostatni wiersz
	}
	public static void main(String[] args) throws IOException	{
		new RaportExcell("Marcin Kuciak");
		//do testów, potem wywalić metodę
	}
}
