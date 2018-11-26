package aSap;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public abstract class AbstractFormI implements ActionListener {
	
	private JFrame newFrame;
	private JPanel panel;
	

	//private JButton btnBack = new JButton("Dalej");
	protected JPanel contentPane;

	public AbstractFormI(String title, String messageLabel)	{
		newFrame = new JFrame(title);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.setVisible(true);
		newFrame.setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		newFrame.setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		panel = new JPanel();
		contentPane.add(panel, "cell 0 0, grow");
		panel.setLayout(new MigLayout("", "[][][]", "[][][]"));
		

		//btnBack.addActionListener(this);
		
		
		JLabel titleLab = new JLabel(messageLabel);
		//titleLab.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(titleLab, "dock north");
		//contentPane.add(btnBack, "cell 0 1");
		
		//przyciski
		//contentPane.add(btnCancel, "cell 0 1");
		
		//contentPane.add(btnNext, "cell 0 1");
		//contentPane.add(btnSave, "cell 0 1");
		
		

		//btnBack.setVisible(false);

		
		
		
		
	}//---koniec konstruktora
	


	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object command= e.getActionCommand();
		if(command.equals("Anuluj"))	{
			//newFrame.setVisible(false);
		}
	}
	

}
	