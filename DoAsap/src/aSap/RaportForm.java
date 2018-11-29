package aSap;

import javax.swing.JButton;
import javax.swing.JLabel;

public class RaportForm extends AbstractFormI {
	
	//private JButton btnSave = new JButton("Generuj raport");
	//private JButton btnCancel = new JButton("Anuluj");
	
	

	public RaportForm(String title, String messageLabel, int monthNo) {
		super(title, messageLabel);
		
		
	}
	public static void main(String[] args)	{
		new RaportForm("Raporcik", "Witam", 3);
		
	}

}
