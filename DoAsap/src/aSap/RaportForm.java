package aSap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class RaportForm extends RawForm implements ActionListener {
	

	private JButton btnSave = new JButton("Generuj raport");
	private JButton btnCancel = new JButton("Anuluj");
	

	
	private JLabel lblNewLabel_4;
	private JCheckBox plk;
	private JCheckBox pli;
	private JCheckBox cpo;
	
	
	private JComboBox<String> comboBoxMonth;
	private JComboBox<Object> comboBoxYear;
	private String[] months =
				{"grudzień", 
				"listopad",
				"październik",
				"wrzesień",
				"sierpień",
				"lipiec",
				"czerwiec",
				"maj",
				"kwiecień",
				"marzec",
				"luty",
				"styczeń"};
	private String[] monthArr = new String[12];
	private ArrayList<String> yearList = new ArrayList<String>();
	private MainTableModel model;

	public RaportForm(MainTableModel mod) {
		super("Generowanie Raportu", "powitanie");
		
		model = mod;
		//data - miesiąc
		Calendar cal = Calendar.getInstance();
		
		int m = cal.get(Calendar.MONTH)+1;
		int l = m;

		for (int i = m; i<=m+11; i++)	{
			if (i<=11) l=i;
			else l=i-12;
			monthArr[i-m] =  months[l];
			System.out.println(months[l]+" "+monthArr[i-m]+" "+i+" "+l+" "+m );
		}
		//data - rok
		int n = cal.get(Calendar.YEAR);

		
		for (int i = 0; i <= n-2018+2; i++)	{
			yearList.add((n-i)+"");
		}
		
		btnSave.addActionListener(this);	
		btnCancel.addActionListener(this);
		
		addToContPane(btnCancel, "cell 0 2");
		addToContPane(btnSave, "cell 0 2");
		//zawartość - specjalizacja
		JPanel panel = new JPanel();
		addToContPane(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[][][][]"));
		

		JLabel  lblNewLabel_1 = new JLabel("<html><u>zmień okres raportu:</u></html>");
		panel.add(lblNewLabel_1, "cell 0 0");
		
		JLabel  lblNewLabel_2 = new JLabel("zmień miesiąc");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		JLabel lblNewLabel_3 = new JLabel("zmień rok");
		panel.add(lblNewLabel_3, "cell 2 2");
		
		comboBoxMonth = new JComboBox<String>(monthArr);
		panel.add(comboBoxMonth, "cell 0 3,growx");
		
		comboBoxYear = new JComboBox<Object>(yearList.toArray());
		panel.add(comboBoxYear, "cell 2 3,growx");
		
		panel.add(new JLabel("         "), "cell 3 5, growx");
		
		JLabel lblNewLabel_4 = new JLabel("<html><u>wybierz spółki do raportu:</u></html>");
		panel.add(lblNewLabel_4, "cell 0 6");
		
		plk = new JCheckBox("PLK");
		panel.add(plk, "cell 0 7");
		
		pli = new JCheckBox("PLI");
		pli.setSelected(true);
		panel.add(pli, "cell 0 8");
		
		
		cpo = new JCheckBox("CPO");
		cpo.setSelected(true);
		panel.add(cpo, "cell 0 9");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object command= e.getActionCommand();
		if(command.equals("Anuluj"))	{
			closeThisFrame();
		}
		if(command.equals("Generuj raport"))	{
			ArrayList<String> monthsList = new ArrayList<String>(Arrays.asList(months));
			
			String u = " ";
			String w = " ";
			String v = " ";
			
			if (!plk.isSelected()) u = plk.getText();
			if (!pli.isSelected()) w = pli.getText();
			if (!cpo.isSelected()) v = cpo.getText();
			
			String a = comboBoxYear.getSelectedItem().toString();
			int y = Integer.parseInt(a);
			try {
				new RaportExcell(model , "Marcin Kuciak", 12-monthsList.indexOf(comboBoxMonth.getSelectedItem()), y, u, w, v);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			closeThisFrame();
			System.out.println((monthsList.indexOf(comboBoxMonth.getSelectedItem()))+" "+comboBoxYear.getSelectedItem());// do wywalenia
			System.out.println(u+w+v); //do wywalenia
			
		}


	}
}
