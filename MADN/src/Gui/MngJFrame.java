package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

public class MngJFrame extends JFrame {

	private JLabel lblHeader, lblCenter;
	private JButton würfeln;
	private JPanel pnlCenter, pnlNorth, pnlEast, pnlWest, pnlSouth;
	private JTextArea ausgabe;

	public MngJFrame() throws IOException {

		setTitle("Mensch ärger dich nicht");

	    
	}


	
	public void dialogfenster(){
//		JFrame dialogfenster = new JFrame("Startfenster");
		JPanel panel = new JPanel();
		setSize(500,500);
		add(panel);
		panel.setLayout(new GridLayout(6,3));
		
		JLabel name = new JLabel("Name");
		JLabel farbe = new JLabel("Farbe");
		JLabel ki = new JLabel("KI");
		panel.add(name);
		panel.add(farbe);
		panel.add(ki);
		
		JTextField namen[] = new JTextField[4];
		JComboBox farbwahl[] = new JComboBox[4];
		JRadioButton kiauswahl[] = new JRadioButton[4];
		String f[] = {"Red", "Yellow", "Blue", "Green"};
		for(int i=0; i< namen.length; i++){
			namen[i] = new JTextField();
			panel.add(namen[i]);
			farbwahl[i] = new JComboBox(f);
			panel.add(farbwahl[i]);
			kiauswahl[i] = new JRadioButton();
			panel.add(kiauswahl[i]);
		}
		
		JButton ok = new JButton("Spiel starten");
		panel.add(ok);
		
		setAlwaysOnTop(true);
		setContentPane(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.paintComponents(panel.getGraphics());
		setVisible(true);
//		dialogfenster.pack();
	}
	
	public void spiel(){
		JPanel p1 = new JPanel();
		add(p1);
		p1.setLayout(new BorderLayout());
		
		

//		JTable table = new JTable( 12, 12 );
//		p1.add( new JScrollPane( table ), BorderLayout.CENTER );
//		GridBagLayout gbl = new GridBagLayout();
//		p1.add(gbl, BorderLayout.CENTER);
		JPanel pCen = new JPanel();
		p1.add(pCen, BorderLayout.CENTER);
		
//		pCen.setLayout(new GridBagLayout());
//		GridBagConstraints c=new GridBagConstraints();
//		
//		c.fill=GridBagConstraints.HORIZONTAL;
//	    c.gridx=0; c.gridy=0; //c.weightx=0.5;
//	    pCen.add(testbutton,c);
//	    c.gridx=1; c.gridy=1; //c.weightx=0.5;
//	    pCen.add(testbutton2,c);
		
		pCen.setLayout(new GridLayout(12,12));
		JButton array[] = new JButton[144];
		for(int i=0; i<144; i++){
			array[i] = new JButton(""+i);
			array[i].setVisible(true);
			pCen.add(array[i]);
		}

		
		
		JTextArea ausgabe = new JTextArea(8,0);
		p1.add(new JScrollPane(ausgabe), BorderLayout.SOUTH);
		
		JButton b1 = new JButton("bla");
		p1.add(b1, BorderLayout.WEST);
		
		JButton b2 = new JButton("bla");
		p1.add(b2, BorderLayout.EAST);
		
		
//		createWidgets();
//		addWidgets();
		setSize(1000,800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
