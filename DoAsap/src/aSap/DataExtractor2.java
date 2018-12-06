package aSap;

import java.util.ArrayList;
import java.util.Arrays;

public class DataExtractor2 {
	ArrayList<String> ZZ; //0, 10
	ArrayList<String> PZ; //1, 11
	ArrayList<String> DK; //3, 13
	String[] ZZrow; //0, 10
	ArrayList<String> PZrow; //1, 11
	ArrayList<String> DKrow; //3, 13
	ArrayList<Integer> ZZday;
	ArrayList<Integer> PZday;
	ArrayList<Integer> DKday;
	
	String monthStr;
	String yearStr;
	MainTableModel mod;
	int rowCount;
	
	//CalendarTest ct; 
	int dniMies;
	 
	
	public DataExtractor2(MainTableModel model, int month, int year, CalendarTest ct)	{
		ZZ = new ArrayList<String>();
		PZ = new ArrayList<String>();
		DK = new ArrayList<String>();
		
		//ZZrow = new ArrayList<String>();
		PZrow = new ArrayList<String>();
		DKrow = new ArrayList<String>();
		
		ZZday = new ArrayList<Integer>();
		PZday = new ArrayList<Integer>();
		DKday = new ArrayList<Integer>();
		
		monthStr = month+"";
		yearStr = year+"";
		mod = model;
		rowCount = model.getRowCount();
		extractData(0);
		//extractData(1);
		//extractData(3);
		
		
		dniMies = ct.getDayNo(month);
		
		DataCreator ZZdc = new DataCreator(dniMies);
		
		for (int i = 0; i<=ZZday.size()-1; i++)	{
			ZZdc.addDane(ZZday.get(i), ZZ.get(i));
		}
		//ZZdc.showAll();
		
		ZZrow = ZZdc.getAll();
		int i = 0;
		for (String el: ZZrow)	{
			System.out.println(i+" "+el);
			i++;
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
	public ArrayList<String> getIDs(String name)	{
		if ("ZZ".equals(name)) return ZZ;
		else if ("PZ".equals(name)) return PZ;
		else if ("DK".equals(name)) return DK;
		return null;
	}
	public ArrayList<Integer> getDays(String name)	{
		if ("ZZday".equals(name)) return ZZday;
		else if ("PZday".equals(name)) return PZday;
		else if ("DKday".equals(name)) return DKday;
		return null;
	}
	
	public String[] getZZrow()	{
		return ZZrow;
		
	}

}
