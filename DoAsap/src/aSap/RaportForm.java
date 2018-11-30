package aSap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
		{"styczeń",
			"luty",
			"marzec",
			"kwiecień",
			"maj",
			"czerwiec",
			"lipiec",
			"sierpień",
			"wrzesień",
			"październik",
			"listopad",
			"grudzień"};
	private String[] monthArr = new String[12];

	public RaportForm(String title, String messageLabel) {
		super(title, messageLabel);
		
		//data
		//LocalTime lc = LocalTime.now();
		Calendar cal = Calendar.getInstance();
		
		//String month = new SimpleDateFormat("MMMMMMMMMMM").format(cal.getTime());
		
		int m = cal.get(Calendar.MONTH);
		//System.out.println(cal.get(Calendar.MONTH));
		int l = m;
		for (int i = m; i<=m+11; i++)	{
			if (i<=11) l=i;
			else l=i-12;
			monthArr[i-m] =  months[l];
		}
		

		btnSave.addActionListener(this);
		
		btnCancel.addActionListener(this);
		addToContPane(btnCancel, "cell 0 2");
		addToContPane(btnSave, "cell 0 2");

		JPanel panel = new JPanel();
		addToContPane(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[][][][]"));
		lblNewLabel_1 = new JLabel("zmień okres raportu");
		panel.add(lblNewLabel_1, "cell 0 0");
		
		lblNewLabel_2 = new JLabel("zmień miesiąc");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		lblNewLabel_3 = new JLabel("zmień rok");
		panel.add(lblNewLabel_3, "cell 2 2");
		
		comboBoxMonth = new JComboBox(monthArr);
		panel.add(comboBoxMonth, "cell 0 3,growx");
		
		comboBoxYear = new JComboBox();
		panel.add(comboBoxYear, "cell 2 3,growx");
		
		
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaportForm rForm = new RaportForm("Generowanie Raportu", "powitanie");
					//rFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub



	}
}
