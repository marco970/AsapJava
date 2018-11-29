package aSap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RaportForm extends RawForm implements ActionListener {
	
	private JButton btnSave = new JButton("Generuj raport");
	private JButton btnCancel = new JButton("Anuluj");

	public RaportForm(String title, String messageLabel, int monthNo) {
		super(title, messageLabel);
		
		btnSave.addActionListener(this);
		addToContPane(btnSave, "cell 0 2");
		btnCancel.addActionListener(this);
		addToContPane(btnCancel, "cell 0 2");
		//btnCancel.addActionListener(this);
		
		//contentPane.add(btnCancel, "cell 0 2");
		//contentPane.add(btnSave, "cell 0 1");

		
		
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaportForm rForm = new RaportForm("tytuł", "powitanie", 4);
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
