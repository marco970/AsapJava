package aSap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class RawForm {
	private JFrame frame;
	JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;


	/**
	 * Create the framevccnnn
	 */
	public RawForm(String title, String mainLab) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 600);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel(mainLab);
		frame.getContentPane().add(lblNewLabel, "cell 0 0");
		
		panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[][][][]"));
		
		lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1, "cell 0 0");
		
		lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2, "cell 0 2");
		
		lblNewLabel_3 = new JLabel("New label");
		panel.add(lblNewLabel_3, "cell 2 2");
		
		comboBox = new JComboBox();
		panel.add(comboBox, "cell 0 3,growx");
		
		comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "cell 2 3,growx");
		
		frame.setVisible(true);
		
		
	}
	public void addToContPane(JComponent c, String migCoords)	{
		frame.getContentPane().add(c, migCoords);
	}
	public void addToPanel(JComponent c, String migCoords)	{
		panel.add(c, migCoords);
	}

}
