package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MngJFrame extends JFrame {

	private JLabel lblHeader, lblCenter;
	private JButton würfeln;
	private JPanel pnlCenter, pnlNorth, pnlEast, pnlWest, pnlSouth;
	private JTextArea ausgabe;

	public MngJFrame() throws IOException {

		setTitle("Mensch ärger dich nicht");

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createWidgets();
		addWidgets();
		pack();
	}

	private void addWidgets() {
		getContentPane().setLayout(new BorderLayout());
		//getContentPane().add(lblHeader, BorderLayout.NORTH);
		//getContentPane().add(pnlWest, BorderLayout.WEST);
		//getContentPane().add(lblCenter, BorderLayout.CENTER);
		getContentPane().add(pnlSouth, BorderLayout.SOUTH);

	}

	private void createWidgets() throws IOException {

		
		
		pnlCenter= new JPanel(); pnlCenter.setLayout(new GridBagLayout());
		pnlNorth= new JPanel();pnlNorth.setLayout(new GridBagLayout());
		pnlEast= new JPanel();pnlEast.setLayout(new GridBagLayout());
		pnlWest=new JPanel(); pnlWest.setLayout(new GridBagLayout());

		
		ausgabe = new JTextArea(5, 10);
		pnlSouth= new JPanel();
		
		pnlSouth.add(new JScrollPane(ausgabe));
		
		
		
		
		

		

	
	}

}
