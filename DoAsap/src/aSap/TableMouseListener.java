package aSap;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class TableMouseListener extends MouseAdapter {
    
   private JTable table;
   private MainTableModel model;
   private EkranGlowny eg;
   private String[] popupString = {"modyfikacja", "zakończ postępowanie", "zawieś postepowanie"};
    
   public TableMouseListener(JTable table, MainTableModel model, EkranGlowny eg) {
       this.table = table;
       this.model = model;
       this.eg = eg;
   }
    
   @Override
   public void mousePressed(MouseEvent event) {
       Point point = event.getPoint();
       int currentRow = table.rowAtPoint(point);
       table.setRowSelectionInterval(currentRow, currentRow);
       
       String[] popupStr = {"modyfikacja"};
       
       Object status = model.getValueAt(currentRow, 4);
       
       if (!status.equals("open"))	{
    	   popupString = popupStr;
    	   //eg.setPopupContent(popupStr);
       }

       
   }
   public String[] getPopupString()	{
	   return popupString;
   }
	   
}
