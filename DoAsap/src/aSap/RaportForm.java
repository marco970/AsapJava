package aSap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class RaportForm extends RawForm implements ActionListener {
	

	private JButton btnSave = new JButton("Generuj raport");
	private JButton btnCancel = new JButton("Anuluj");
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
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
		}
		//data - rok
		int n = cal.get(Calendar.YEAR);

		
		for (int i = 0; i <= n-2018+2; i++)	{
			yearList.add((n-i)+"");
		}
		String[] yearArr = new String[yearList.size()];
		//yearArr = (String[]) yearList.toArray();
		//buttons
		btnSave.addActionListener(this);	
		btnCancel.addActionListener(this);
		
		addToContPane(btnCancel, "cell 0 2");
		addToContPane(btnSave, "cell 0 2");
		//zawartość - specjalizacja
		JPanel panel = new JPanel();
		addToContPane(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[][][][]"));
		lblNewLabel_1 = new JLabel("zmień okres raportu");
		panel.add(lblNewLabel_1, "cell 0 0");
		
		lblNewLabel_2 = new JLabel("zmień miesiąc");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		lblNewLabel_3 = new JLabel("zmień rok");
		panel.add(lblNewLabel_3, "cell 2 2");
		
		comboBoxMonth = new JComboBox<String>(monthArr);
		panel.add(comboBoxMonth, "cell 0 3,growx");
		//comboBoxMonth.addActionListener(this);
		
		comboBoxYear = new JComboBox<Object>(yearList.toArray());
		panel.add(comboBoxYear, "cell 2 3,growx");
		//comboBoxYear.addActionListener(this);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object command= e.getActionCommand();
		if(command.equals("Anuluj"))	{
			closeThisFrame();
		}
		if(command.equals("Generuj raport"))	{
			ArrayList<String> monthsList = new ArrayList<String>(Arrays.asList(months));
			String a = comboBoxYear.getSelectedItem().toString();
			int y = Integer.parseInt(a);
			try {
				new RaportExcell(model , "Marcin Kuciak", 12-monthsList.indexOf(comboBoxMonth.getSelectedItem()), y);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			closeThisFrame();
			System.out.println((12-monthsList.indexOf(comboBoxMonth.getSelectedItem()))+" "+comboBoxYear.getSelectedItem());
		}


	}
}
