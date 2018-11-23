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
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
		fontNormal.setFontHeightInPoints((short) 9);  
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
		
		//Fonty i style
				HSSFFont f1 = workbook.createFont();
					//f1.setBold(true);
					//f1.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());  
					f1.setFontHeightInPoints((short) 9);  
					f1.setFontName("Tahoma");  
				
				
				Font f2 = workbook.createFont();
					f2.setBold(true);
					f2.setFontHeightInPoints((short) 9);
					f2.setFontName("Tahoma"); 
				
				Font f3 = workbook.createFont();
					f3.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());  
					f3.setBold(true);
					f3.setFontHeightInPoints((short) 9);  
					f3.setFontName("Tahoma");  
					
				Font f4 = workbook.createFont();
					f4.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());  
					f4.setBold(true);
					f4.setFontHeightInPoints((short) 9);  
					f4.setFontName("Tahoma");  
				
				Font f5 = workbook.createFont();
					f5.setFontHeightInPoints((short) 8);  
					f5.setFontName("Tahoma"); 
					
					
				CellStyle cs1 = workbook.createCellStyle();
					cs1.setAlignment(HorizontalAlignment.CENTER);
					cs1.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
					cs1.setWrapText(true);
					cs1.setFont(f1);
				
				CellStyle cs2 = workbook.createCellStyle();
					cs2.setAlignment(HorizontalAlignment.CENTER);
					cs2.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
					cs2.setWrapText(true);
					cs2.setFont(f2);
				
				CellStyle cs3 = workbook.createCellStyle();
					cs3.setAlignment(HorizontalAlignment.LEFT);
					cs3.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
					cs3.setWrapText(true);
					cs3.setFont(f2);
				
				CellStyle cs4 = workbook.createCellStyle();
					cs4.setAlignment(HorizontalAlignment.LEFT);
					cs4.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
					cs4.setWrapText(true);
					cs4.setFont(f3);
					
				CellStyle cs5 = workbook.createCellStyle();
					cs5.setAlignment(HorizontalAlignment.LEFT);
					cs5.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
					cs5.setWrapText(true);
					cs5.setFont(f5);
					
				CellStyle cs6 = workbook.createCellStyle();
				CellStyle cs7 = workbook.createCellStyle();
				
				//generowanie paska z datami
				int l=1;
				for (int j = 2; j<=dniMies*2-1+2; j=j+2)	{
					cellArr[0][j+1].setCellValue(ct.getDayName(l));
					cellArr[0][j+1].setCellStyle(cs1);
					cellArr[1][j].setCellValue(ct.getDate(l));
					cellArr[1][j].setCellStyle(cs2);
					l++;
					sheet.addMergedRegion(new CellRangeAddress(1,1,j,j+1));
					cellArr[2][j].setCellValue("liczba\ngodzin");
					cellArr[2][j].setCellStyle(cs1);
					cellArr[2][j+1].setCellValue("opis postępowania\nlub nr z systemu");
					cellArr[2][j+1].setCellStyle(cs1);
					sheet.setColumnWidth(j+1, 5000);	
				}
				
				//generowanie pierwszych 2 kolumn
					
				sheet.setColumnWidth(0, 10000);
				sheet.setColumnWidth(1, 12000);
				//RichTextString c10 = new HSSFRichTextString("Pracownik: "+kupiec);
				
				rowArr[1].setHeightInPoints(30);
				cellArr[1][0].setCellValue("Pracownik: "+kupiec);
				cellArr[1][0].setCellStyle(cs4);
				
				
				rowArr[2].setHeightInPoints(25);
				//RichTextString c20 = new HSSFRichTextString("RODZAJ USŁUGI/ ETAP POSTĘPOWANIA");
				cellArr[2][0].setCellValue("RODZAJ USŁUGI/ ETAP POSTĘPOWANIA");
				//RichTextString c21 = new HSSFRichTextString("ZAKRES ETAPU POSTĘPOWANIA");
				cellArr[2][1].setCellValue("ZAKRES ETAPU POSTĘPOWANIA");
				cellArr[2][0].setCellStyle(cs3);
				cellArr[2][1].setCellStyle(cs3);
				
				rowArr[3].setHeightInPoints(100);
				RichTextString c30 = new HSSFRichTextString("Realizacja zakupów i wyboru dostawców - etap Zlecenie Zakupu (ZZ)");
				c30.applyFont(45, 65, f4);
				cellArr[3][0].setCellValue(c30);
				cellArr[3][0].setCellStyle(cs3);
				cellArr[3][1].setCellValue("Weryfikacja zasadności i trybu dokonania zakupu planowanego przez "
						+ "CP oraz poprawności i kompletności danych "
						+ "wprowadzonych przez komórkę CP inicjująca zakup.");
				cellArr[3][1].setCellStyle(cs5);
				
				
				rowArr[4].setHeightInPoints(150);
				RichTextString c40 = new HSSFRichTextString("Realizacja zakupów i wyboru dostawców - etap Postępowanie Zakupowe (PZ)");
				c40.applyFont(45, 71, f4);
				cellArr[4][0].setCellValue(c40);
				cellArr[4][0].setCellStyle(cs3);
				cellArr[4][1].setCellValue("Przygotowanie regulaminów, kryteriów oceny, harmonogramu postępowania itd. "
						+ "\nPrzygotowanie i wysyłanie zapytań informacyjnych/ofertowych na podstawie merytorycznego wkładu CP."
						+ "\nAnaliza i ocena ofert otrzymanych w ramach prowadzonego postępowania, w tym wyjaśnianie z Oferentami szczegółów oferty."
						+ "\nProwadzenie negocjacji z oferentami, w tym ponowna analiza przesłanych ofert po negocjacjach."
						+ "\nPrzygotowanie dokumentacji podsumowującej postępowanie zakupowe oraz wprowadzenie jej do systemu zakupowego");
				cellArr[4][1].setCellStyle(cs5);
				
								
				rowArr[5].setHeightInPoints(100);
				RichTextString c50 = new HSSFRichTextString("Obsługa umów zakupowych - etap Dokument Końcowy (DK)");
				c50.applyFont(30, 52, f4);
				cellArr[5][0].setCellValue(c50);
				cellArr[5][0].setCellStyle(cs3);
				
				//cellArr[5][1].setCellValue("");		
				
				rowArr[6].setHeightInPoints(100);
				cellArr[6][0].setCellValue("Inne");
				cellArr[6][0].setCellStyle(cs3);
				cellArr[6][1].setCellValue("Udział w uzgodnieniach i spotkaniach z przedstawicielami CP "
						+ "dotyczących planowanych postępowań zakupowych; przygotowanie danych w ramach  "
						+ "zleconych inicjatyw optymalizacyjnych, analizy rynku dostawców, itp.;");
				cellArr[6][1].setCellStyle(cs5);
				
				cellArr[7][1].setCellValue("SUMA");
				cellArr[7][1].setCellStyle(cs3);
				rowArr[7].setHeightInPoints(25);
				
				workbook.write(new FileOutputStream(month+"_Raport.xls"));
				workbook.close();	//ostatni wiersz
		}
	public static void main(String[] args) throws IOException	{
		new RaportExcell("Marcin Kuciak");
		//do testów, potem wywalić metodę
	}
}
