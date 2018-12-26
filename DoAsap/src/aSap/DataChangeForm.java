package aSap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DataChangeForm extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	private JButton btnSave = new JButton("Zapisz");
	private JButton btnCancel = new JButton("Anuluj");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JTextField textField_3;
	private MainTableModel model;
	

	private String[] labNames = {"data ZZ", "data PZ", "data WP", "data DK"};
	private JLabel[] labs;
	private JTextField[] tfs;
	private JLabel[] errMessage;
	
	private int rowNr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataChangeForm frame = new DataChangeForm(new MainTableModel(), 3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DataChangeForm(MainTableModel model, int rowNr) {
		
		this.model = model;
		this.rowNr = rowNr;
		
		labs = new JLabel[labNames.length];
		tfs  = new JTextField[labNames.length];
		errMessage = new JLabel[labNames.length];
		
		
		setTitle("Zmiana dat postępowania");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		contentPane.add(btnCancel, "cell 0 1");
		contentPane.add(btnSave, "cell 0 1");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		lblNewLabel = new JLabel("<html><font size=\"4\">Uwaga: ten formularz powinien być stosowany tylko w wyjątkowych przypadkach!</font>"
				+ "<p></p>"
				+ "<p>Zmiana dat postępowania:"
				+ "</p></html>");
		panel.add(lblNewLabel, "cell 0 0 3 1");
		//JLabel lblNewLabel_u = new JLabel(" ");
		//panel.add(lblNewLabel_u, "cell 0 1,alignx trailing");
		
		
		for (int i = 0; i<=labNames.length-1; i++)	{
			//JLabel aa = new JLabel(labNames[i]);
			//.out.println(labNames.length);
			labs[i] = new JLabel(labNames[i]);
			panel.add(labs[i], "cell 0 "+(i+2));
			
			tfs[i] = new JTextField(10);
			panel.add(tfs[i], "cell 1 "+(i+2));
			
			errMessage[i] = new JLabel("nieprawidłowa data");
			panel.add(errMessage[i], "cell 2 "+(i+2));
			
		}
		/*
		lblNewLabel_1 = new JLabel("DataZZ");
		panel.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField = new JTextField(10);
		panel.add(textField, "cell 1 2");
		//textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("DataPZ");
		panel.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField(10);
		textField_1.setText((String) model.getValueAt(rowNr, 10));
		
		panel.add(textField_1, "cell 1 3");
		//textField_1.setColumns(20);
		
		lblNewLabel_3 = new JLabel("DataWP");
		panel.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textField_2 = new JTextField(10);
		panel.add(textField_2, "cell 1 4");
		//textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("DataDK");
		panel.add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		textField_3 = new JTextField(10);
		panel.add(textField_3, "cell 1 5");
		//textField_3.setColumns(10);
		*/
		
		
		
	}

}
