package aSap;

import java.util.ArrayList;
import java.util.Arrays;

public class DataExtractor2 {
	ArrayList<String> ZZ; //0, 10
	ArrayList<String> PZ; //1, 11
	ArrayList<String> DK; //3, 13
	String[] ZZrow; //0, 10
	String[] PZrow; //1, 11
	String[] DKrow; //3, 13
	ArrayList<Integer> ZZday;
	ArrayList<Integer> PZday;
	ArrayList<Integer> DKday;
	
	String monthStr;
	String yearStr;
	MainTableModel mod;
	int rowCount;
	
	//CalendarTest ct; 
	int dniMies;
	Integer[] ZZHours;
	Integer[] PZHours;
	Integer[] DKHours;
	 
	
	public DataExtractor2(MainTableModel model, int month, int year, CalendarTest ct)	{
		ZZ = new ArrayList<String>();
		PZ = new ArrayList<String>();
		DK = new ArrayList<String>();
		
		ZZday = new ArrayList<Integer>();
		PZday = new ArrayList<Integer>();
		DKday = new ArrayList<Integer>();
		
		monthStr = month+"";
		yearStr = year+"";
		mod = model;
		rowCount = model.getRowCount();
		extractData(0);
		extractData(1);
		extractData(3);
				
		dniMies = ct.getDayNo(month);
		
		DataCreator ZZdc = new DataCreator(dniMies);
		DataCreator PZdc = new DataCreator(dniMies);
		DataCreator DKdc = new DataCreator(dniMies);
		
		createData(ZZdc, ZZ, ZZday);
		createData(PZdc, PZ, PZday);
		createData(DKdc, DK, DKday);

		/*
		ZZdc.showAll();
		PZdc.showAll();
		DKdc.showAll();
		
		*/
		
		
		
		ZZrow = ZZdc.getAll();
		ZZHours = ZZdc.getHours();
		
		PZrow = PZdc.getAll();
		PZHours = PZdc.getHours();

		DKrow = DKdc.getAll();
		DKHours = DKdc.getHours();


	}
	
	public String[] getExRow(String name)	{
		if (name.equals("DK")) return DKrow;	
		else if(name.equals("PZ")) return PZrow;
		else return ZZrow;
		
	}

	public Integer[] getExHours(String name)	{
		if (name.equals("DK")) return DKHours;	
		else if(name.equals("PZ")) return PZHours;
		else return ZZHours;
		
	}
	
	public void createData(DataCreator exDc, ArrayList<String> idEx, ArrayList<Integer> dayEx)	{
		for (int i = 0; i<=dayEx.size()-1; i++)	{
			exDc.addDane(dayEx.get(i), idEx.get(i));
		}

	}

	public void extractData(int position)	{
		for (int i=0; i<=rowCount-1; i++)	{
			String a = (String) mod.getValueAt(i, position+10);
			
			if (!(("").equals(a)||a==null))	{
				//System.out.println(a.substring(3, 5)+"  "+a.substring(6, 10));
				if (a.length()>=10)	{
					if (a.substring(3, 5).equals(monthStr)&&a.substring(6, 10).equals(yearStr)) {
						if (position == 0)	{
							ZZ.add((String) mod.getValueAt(i, position));
							ZZday.add(Integer.parseInt(a.substring(0, 2)));
						}
						else if (position == 1) {
							PZ.add((String) mod.getValueAt(i, position));
							PZday.add(Integer.parseInt(a.substring(0, 2)));
						}
						else if (position == 3) {
							DK.add((String) mod.getValueAt(i, position));
							DKday.add(Integer.parseInt(a.substring(0, 2)));
						}
						//System.out.println((String) mod.getValueAt(i, position)+"*"+a+" "+i);	
					}
				}
			}					
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalendarTest ct = new CalendarTest(2018, 11);
		new DataExtractor2(new MainTableModel(), 11, 2018, ct);

	}


}
