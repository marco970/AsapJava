package aSap;

public class DataCreator {
	
	//String nazwa;
	int dniMiesNo;
	String[] a;
	
	
	public DataCreator(int dniMiesNo) {
		
		
		
		//this.nazwa = nazwa;
		this.dniMiesNo = dniMiesNo;
		a = new String[dniMiesNo+1];
		for (int i = 1; i <= dniMiesNo; i++)	{
			a[i] = "";
		}
	
	}
	public void addDane(int adr, String content)	{
		a[adr] = a[adr] +" "+content;
	}
	public void showAll()	{
		for (int i = 1; i<=dniMiesNo; i++)	{
			System.out.println(i+" "+a[i]);
		}
	}
	public String[] getAll()	{
		return a;		
	}
	
	
	
	

}
