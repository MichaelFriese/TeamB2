package GuiSpielfeld;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Kreis extends JPanel{

	public Kreis(){
		this.setSize(50,50);
		this.setVisible(true);
		this.setPreferredSize(new Dimension (20,20));
	}
	
	
	
	 @Override
	 protected void paintComponent (Graphics g){
		 
		 super.paintComponent(g);
		 g.setColor(Color.red);
		 g.fillOval(0,0,20, 20);
		 
	
		 

		 
		 
		 
		 
		 
	 }
	 
	
		 
	 }
	 
	 
	 
	 
	



