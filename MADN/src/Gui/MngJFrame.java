package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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

import backend.Spiel;
import frontend.iBediener;


public class MngJFrame extends JFrame {

	private JLabel lblHeader, lblCenter;
	private JButton wuerfeln;
	private JPanel pnlCenter, pnlNorth, pnlEast, pnlWest, pnlSouth;
	private JTextArea ausgabe;
	private JButton laden;
	private JButton ueber;
	private JButton beenden;
	private JButton start;
	private JButton ok;
	private eventHandling e;
	
	private JFrame dialogfenster = new JFrame("Startfenster");
	private JTextField namen[] = new JTextField[4];
	private JComboBox farbwahl[] = new JComboBox[4];
	private JRadioButton kiAgg[] = new JRadioButton[4];
	private JRadioButton kiDef[] = new JRadioButton[4];
	private ButtonGroup group[] = new ButtonGroup[4];
	private JComboBox kiwahl[] = new JComboBox[4];
	
	private iBediener s;
	
	public MngJFrame() {
		
		this.e= new eventHandling(this);
		setTitle("Mensch ärger dich nicht");
		initComponents();
		initUI();
		this.e.setButtonBeenden(beenden);
		this.e.setButtonLaden(laden);
		this.e.setButtonStart(start);
		this.e.setButtonUeber(ueber);
		this.e.setButtonOk(ok);
		s= new Spiel();
//		dialogfenster();

	    
	}
	
	public JFrame getDialogFenster(){
		return dialogfenster;
	}
	public JTextField[] getNamen(){
		return namen;
	}
	public JComboBox[] getFarbe(){
		return farbwahl;
	}
	public JComboBox[] getKI(){
		return kiwahl;
	}
	
	public iBediener getSpiel(){
		return s;
	}
	private void initUI(){
		
		setTitle("Mensch aergere dich nicht");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel3= new JPanel();
		panel3.setLayout(new FlowLayout());
		
		start = new JButton("Start");
		laden = new JButton("Laden");
		beenden = new JButton("Beenden");
		ueber = new JButton("Ueber");
		

		start.addActionListener(e);
		laden.addActionListener(e);
		beenden.addActionListener(e);
		ueber.addActionListener(e);
		
		panel3.add(start,BorderLayout.CENTER);
		panel3.add(laden,BorderLayout.CENTER);
		panel3.add(beenden,BorderLayout.CENTER);
		panel3.add(ueber,BorderLayout.CENTER);
		getContentPane().add(panel3,BorderLayout.PAGE_END);
		
		
		
	}
	
	private void initComponents(){
	
		setContentPane(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Image img;
			{
			
			img= getToolkit().createImage("bgBild.jpg");
			
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 1);
			try{
				mt.waitForAll();}
			catch(Exception e){
			e.printStackTrace();
			}
				
			}
			protected void paintComponent(Graphics g){
				g.drawImage(img,0,0,getWidth(),getHeight(), this);
		}
		});
	}


	
	public void dialogfenster(){
		
		JPanel panel = new JPanel();
		dialogfenster.setSize(500,500);
		dialogfenster.add(panel);
		panel.setLayout(new GridLayout(6,3));
		
		JLabel name = new JLabel("Name");
		JLabel farbe = new JLabel("Farbe");
		JLabel ki1 = new JLabel("KI/Mensch");
		panel.add(name);
		panel.add(farbe);
		panel.add(ki1);
//		panel.add(ki2);
	
		String f[] = {"Red", "Yellow", "Blue", "Green"};
		String k[] = {"Mensch", "KI Aggressiv", "KI Defensiv"};
		for(int i=0; i< namen.length; i++){
			namen[i] = new JTextField();
			panel.add(namen[i]);
			farbwahl[i] = new JComboBox(f);
			panel.add(farbwahl[i]);
			
			kiwahl[i] = new JComboBox(k);
			panel.add(kiwahl[i]);
			
//			kiAgg[i] = new JRadioButton();
//			kiDef[i] = new JRadioButton();
//			group[i] = new ButtonGroup();
//			group[i].add(kiAgg[i]);
//			group[i].add(kiDef[i]);
//			panel.add(kiAgg[i]);
//			panel.add(kiDef[i]);
		}
		
		JButton ok = new JButton("Spiel starten");
		panel.add(ok);
		
		ok.addActionListener(e);
		e.setButtonOk(ok);
		
		dialogfenster.setAlwaysOnTop(true);
		dialogfenster.setContentPane(panel);
		dialogfenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.paintComponents(panel.getGraphics());
		dialogfenster.setVisible(true);
		dialogfenster.pack();
	}
	
	public void spiel(){
		JFrame fmSpiel = new JFrame();
		JPanel p1 = new JPanel();
		fmSpiel.add(p1);
		p1.setLayout(new BorderLayout());
			
		JPanel pCen = new JPanel();
		p1.add(pCen, BorderLayout.CENTER);
		
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
		
		fmSpiel.setSize(1000,800);
		fmSpiel.setResizable(false);
		fmSpiel.setVisible(true);
		fmSpiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[]args){
		
		MngJFrame main = new MngJFrame();
		main.setVisible(true);
	
		}
}
