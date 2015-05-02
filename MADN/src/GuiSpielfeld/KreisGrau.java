package GuiSpielfeld;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;




public class KreisGrau extends Kreis {
	
	
	

	public KreisGrau(){
		super();
	}
	
	
	
	 @Override
	 protected void paintComponent (Graphics g){
		 
		 super.paintComponent(g);
		 g.setColor(Color.DARK_GRAY);
		 g.fillOval(0,0,20, 20);
		 
	
		 

		 
		 
		 
		 
		 
	 }
	 

}