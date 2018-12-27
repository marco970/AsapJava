package aSap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

public class PopupContent extends JPopupMenu implements PropertyChangeListener, ActionListener {

	private JTable lista;
	private MainTableModel data;
	private JFrame frame;
	private String[] popupStr;
	
	public PopupContent(JTable list, MainTableModel dane, JFrame fram)	{
		super();
		lista=list;
		data = dane;
		frame = fram;
		//System.out.println("pc kontruktor - jestem");
		String[] popupStr = {"modyfikacja", "zmień daty", "zakończ postępowanie", "zawieś postepowanie"};
		this.popupStr = popupStr;
		doMassAddMenu(this, popupStr);		
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.removeAll();
		String[] a = (String[]) evt.getNewValue();
		doMassAddMenu(this, a);
		
	}
	public void doMassAddMenu(JPopupMenu popup, String...args)	{
		for (int i =0; i<=args.length-1; i++)	{
			JMenuItem menuItem = mi(args[i]);	
			popup.add(menuItem);
		}
	}
	
	public JMenuItem mi(String str)	{
		JMenuItem mi = new JMenuItem(str);
		mi.addActionListener(this);	
		mi.setActionCommand(str);
		return mi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String u = e.getActionCommand();
	
		if (u.equals("modyfikacja"))	{
			int selectedRow = lista.getSelectedRow();
			int realSelectedRow = lista.convertRowIndexToModel(selectedRow);
			new OpForm2("Edycja postępowania", realSelectedRow, data);
		}
		if (u.equals("zakończ postępowanie"))	{
			int selectedRow = lista.getSelectedRow();
			int realSelectedRow = lista.convertRowIndexToModel(selectedRow);
			if (data.getValueAt(realSelectedRow, 2)==null || "".equals(data.getValueAt(realSelectedRow, 2)))	{
				JOptionPane.showMessageDialog(frame, "Nie można zakończyć tego postępowania");
			}
			else {
				System.out.println("kończę");
				data.cellUpdate("done", realSelectedRow, 4);
				try {
					new Zapis(data);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		
		}
		if (u.equals("zmień daty"))	{
			//System.out.println("Zmiana dat");
			//new DataChangeForm(data, lista.getSelectedRow());
			new DateChangeForm2(data, lista.getSelectedRow());
		}
		if (u.equals("zawieś postepowanie"))	{
			int selectedRow = lista.getSelectedRow();
			int realSelectedRow = lista.convertRowIndexToModel(selectedRow);
			if(data.getValueAt(realSelectedRow, 4).equals("open"))	{
				data.cellUpdate("on hold", realSelectedRow, 4);
			}
			else if (data.getValueAt(realSelectedRow, 4).equals("done")) {
				JOptionPane.showMessageDialog(frame, "Nie można zamkniętego postępowania");
			}
			else if (data.getValueAt(realSelectedRow, 4).equals("on hold")) {
				JOptionPane.showMessageDialog(frame, "Postępowanie już jest zawieszone");
			}
		}
		if (u.equals("odwieś postępowanie"))	{
			//int selectedRow = lista.getSelectedRow();
			int realSelectedRow = lista.convertRowIndexToModel(lista.getSelectedRow());
			if (data.getValueAt(realSelectedRow, 4).equals("on hold")) {
				data.cellUpdate("open", realSelectedRow, 4);
			}
		}
	}

}
