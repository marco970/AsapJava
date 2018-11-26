package aSap;

import javax.swing.JButton;

public class RaportForm extends AbstractFormI {
	
	private JButton btnSave = new JButton("Generuj raport");
	//private JButton btnCancel = new JButton("Anuluj");

	public RaportForm(String title, String messageLabel, int monthNo) {
		super(title, messageLabel);
		
		btnSave.addActionListener(this);
		//btnCancel.addActionListener(this);
		
		//contentPane.add(btnCancel, "cell 0 2");
		contentPane.add(btnSave, "cell 0 1");

		
		
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args)	{
		new RaportForm("Hejka", "Witam", 3);
		
	}

}
