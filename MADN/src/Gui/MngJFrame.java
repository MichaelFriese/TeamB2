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
import java.awt.Toolkit;
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
	private JComboBox kiwahl[] = new JComboBox[4];

	private JFrame fmSpiel = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel pCen = new JPanel();
	private JPanel[] red = new JPanel[8];

	public JPanel[] getRed() {
		return red;
	}

	private JPanel[] blue = new JPanel[8];
	private JPanel[] green = new JPanel[8];
	private JPanel[] yellow = new JPanel[8];
	private JPanel[] fields = new JPanel[40];

	private JButton[] figurenRed = new JButton[4];
	private JButton[] figurenBlue = new JButton[4];
	private JButton[] figurenGreen = new JButton[4];
	private JButton[] figurenYellow = new JButton[4];

	private JButton ziehen;

	private iBediener s;

	public MngJFrame() {

		this.e = new eventHandling(this);
		setTitle("Mensch ärger dich nicht");
		initComponents();
		initUI();
		this.e.setButtonBeenden(beenden);
		this.e.setButtonLaden(laden);
		this.e.setButtonStart(start);
		this.e.setButtonUeber(ueber);
		this.e.setButtonOk(ok);
		s = new Spiel(this);

		// dialogfenster();

	}

	public JFrame getDialogFenster() {
		return dialogfenster;
	}

	public JTextField[] getNamen() {
		return namen;
	}

	public JComboBox[] getFarbe() {
		return farbwahl;
	}

	public JComboBox[] getKI() {
		return kiwahl;
	}

	public iBediener getSpiel() {
		return s;
	}

	public JTextArea getAusgabe() {
		return ausgabe;
	}

	private void initUI() {

		setTitle("Mensch aergere dich nicht");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());

		start = new JButton("Start");
		laden = new JButton("Laden");
		beenden = new JButton("Beenden");
		ueber = new JButton("Ueber");

		ausgabe = new JTextArea(8, 0);

		start.addActionListener(e);
		laden.addActionListener(e);
		beenden.addActionListener(e);
		ueber.addActionListener(e);

		panel3.add(start, BorderLayout.CENTER);
		panel3.add(laden, BorderLayout.CENTER);
		panel3.add(beenden, BorderLayout.CENTER);
		panel3.add(ueber, BorderLayout.CENTER);
		getContentPane().add(panel3, BorderLayout.PAGE_END);
		
		for (int i = 0; i < 8; i++) {
			red[i] = new JPanel();
			red[i].setBackground(Color.RED);
			red[i].setLayout(null);
			blue[i] = new JPanel();
			blue[i].setBackground(Color.BLUE);
			blue[i].setLayout(null);
			green[i] = new JPanel();
			green[i].setBackground(Color.GREEN);
			green[i].setLayout(null);
			yellow[i] = new JPanel();
			yellow[i].setBackground(Color.YELLOW);
			yellow[i].setLayout(null);
			pCen.add(red[i]);
			pCen.add(blue[i]);
			pCen.add(green[i]);
			pCen.add(yellow[i]);
		}
		figurenSetzen();


	}

	private void initComponents() {

		setContentPane(new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Image img;
			{

				img = getToolkit().createImage("bgBild.jpg");

				MediaTracker mt = new MediaTracker(this);
				mt.addImage(img, 1);
				try {
					mt.waitForAll();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			protected void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		});
	}

	public void dialogfenster() {

		JPanel panel = new JPanel();
		dialogfenster.setSize(500, 500);
		dialogfenster.add(panel);
		panel.setLayout(new GridLayout(6, 3));

		JLabel name = new JLabel("Name");
		JLabel farbe = new JLabel("Farbe");
		JLabel ki1 = new JLabel("KI/Mensch");
		panel.add(name);
		panel.add(farbe);
		panel.add(ki1);
		// panel.add(ki2);
		
		JButton ok = new JButton("Spiel starten");
		
		ok.setEnabled(false);

		String f[] = { "Red", "Yellow", "Blue", "Green" };
		String k[] = { "Mensch", "KI Aggressiv", "KI Defensiv" };
		for (int i = 0; i < namen.length; i++) {
			namen[i] = new JTextField();
			namen[i].addCaretListener(new eventHandling(ok));
			panel.add(namen[i]);
			farbwahl[i] = new JComboBox(f);
			panel.add(farbwahl[i]);

			kiwahl[i] = new JComboBox(k);
			panel.add(kiwahl[i]);

			// kiAgg[i] = new JRadioButton();
			// kiDef[i] = new JRadioButton();
			// group[i] = new ButtonGroup();
			// group[i].add(kiAgg[i]);
			// group[i].add(kiDef[i]);
			// panel.add(kiAgg[i]);
			// panel.add(kiDef[i]);
		}

		
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

	public void spiel() {
		// File imageFile = new
		// File("/Users/tobi/Desktop/2000px-Menschenaergern.png");
		//
		// BufferedImage image = null;
		// try {
		// image = ImageIO.read(imageFile);
		// }
		// catch(IOException ioex) {
		// System.exit(1);
		// }
		JLabel bild = new JLabel();
		ImageIcon icon = new ImageIcon("/Users/tobi/Desktop/2000px-Menschenaergern.png");
		bild.add(new JLabel(icon));
		bild.setIcon(icon);

		fmSpiel.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(pCen, BorderLayout.CENTER);
		// pCen.add(new JLabel(new ImageIcon(image)));
		// pCen.add(bild);

		pCen.setLayout(null);
		pCen.setBackground(Color.WHITE);
		// JButton but1 = new JButton("asd");
		// but1.setEnabled(false);
		// pCen.add(but1);
		// but1.setBounds(20, 20, 30, 30);
		// pCen.setBackground(new Color(255,0,0));

		/* Spielfeld aus JPanel */

		for (int i = 0; i < 8; i++) {
			pCen.add(red[i]);
			pCen.add(blue[i]);
			pCen.add(green[i]);
			pCen.add(yellow[i]);
		}
		for (int i = 0; i < 40; i++) {
			fields[i] = new JPanel();
			fields[i].setBackground(Color.DARK_GRAY);
			fields[i].setLayout(null);
			pCen.add(fields[i]);
		}

		red[0].setBounds(20, 20, 30, 30);
		red[1].setBounds(70, 20, 30, 30);
		red[2].setBounds(20, 70, 30, 30);
		red[3].setBounds(70, 70, 30, 30);
		red[4].setBounds(70, 270, 30, 30);
		red[5].setBounds(120, 270, 30, 30);
		red[6].setBounds(170, 270, 30, 30);
		red[7].setBounds(220, 270, 30, 30);

		blue[0].setBounds(470, 20, 30, 30);
		blue[1].setBounds(520, 20, 30, 30);
		blue[2].setBounds(470, 70, 30, 30);
		blue[3].setBounds(520, 70, 30, 30);
		blue[4].setBounds(270, 70, 30, 30);
		blue[5].setBounds(270, 120, 30, 30);
		blue[6].setBounds(270, 170, 30, 30);
		blue[7].setBounds(270, 220, 30, 30);

		green[0].setBounds(470, 470, 30, 30);
		green[1].setBounds(520, 470, 30, 30);
		green[2].setBounds(470, 520, 30, 30);
		green[3].setBounds(520, 520, 30, 30);
		green[4].setBounds(470, 270, 30, 30);
		green[5].setBounds(420, 270, 30, 30);
		green[6].setBounds(370, 270, 30, 30);
		green[7].setBounds(320, 270, 30, 30);

		yellow[0].setBounds(20, 470, 30, 30);
		yellow[1].setBounds(70, 470, 30, 30);
		yellow[2].setBounds(20, 520, 30, 30);
		yellow[3].setBounds(70, 520, 30, 30);
		yellow[4].setBounds(270, 470, 30, 30);
		yellow[5].setBounds(270, 420, 30, 30);
		yellow[6].setBounds(270, 370, 30, 30);
		yellow[7].setBounds(270, 320, 30, 30);

		fields[0].setBounds(20, 220, 30, 30);
		fields[1].setBounds(70, 220, 30, 30);
		fields[2].setBounds(120, 220, 30, 30);
		fields[3].setBounds(170, 220, 30, 30);
		fields[4].setBounds(220, 220, 30, 30);

		fields[5].setBounds(220, 170, 30, 30);
		fields[6].setBounds(220, 120, 30, 30);
		fields[7].setBounds(220, 70, 30, 30);
		fields[8].setBounds(220, 20, 30, 30);

		fields[9].setBounds(270, 20, 30, 30);
		fields[10].setBounds(320, 20, 30, 30);

		fields[11].setBounds(320, 70, 30, 30);
		fields[12].setBounds(320, 120, 30, 30);
		fields[13].setBounds(320, 170, 30, 30);
		fields[14].setBounds(320, 220, 30, 30);

		fields[15].setBounds(370, 220, 30, 30);
		fields[16].setBounds(420, 220, 30, 30);
		fields[17].setBounds(470, 220, 30, 30);
		fields[18].setBounds(520, 220, 30, 30);

		fields[19].setBounds(520, 270, 30, 30);
		fields[20].setBounds(520, 320, 30, 30);

		fields[21].setBounds(470, 320, 30, 30);
		fields[22].setBounds(420, 320, 30, 30);
		fields[23].setBounds(370, 320, 30, 30);
		fields[24].setBounds(320, 320, 30, 30);

		fields[25].setBounds(320, 370, 30, 30);
		fields[26].setBounds(320, 420, 30, 30);
		fields[27].setBounds(320, 470, 30, 30);
		fields[28].setBounds(320, 520, 30, 30);

		fields[29].setBounds(270, 520, 30, 30);
		fields[30].setBounds(220, 520, 30, 30);

		fields[31].setBounds(220, 470, 30, 30);
		fields[32].setBounds(220, 420, 30, 30);
		fields[33].setBounds(220, 370, 30, 30);
		fields[34].setBounds(220, 320, 30, 30);

		fields[35].setBounds(170, 320, 30, 30);
		fields[36].setBounds(120, 320, 30, 30);
		fields[37].setBounds(70, 320, 30, 30);
		fields[38].setBounds(20, 320, 30, 30);
		fields[39].setBounds(20, 270, 30, 30);



		// pCen.setLayout(new GridLayout(12,12));
		// JButton array[] = new JButton[144];
		// for(int i=0; i<144; i++){
		// array[i] = new JButton(""+i);
		// array[i].setVisible(true);
		// pCen.add(array[i]);
		// }

		// ausgabe = new JTextArea(8,0);
		ausgabe.setEditable(false);
		// ausgabe.setText("123");
		mainPanel.add(new JScrollPane(ausgabe), BorderLayout.SOUTH);

		JPanel pWest = new JPanel();
		JLabel b1 = new JLabel("Wuerfelergebnis");
		pWest.add(b1);
		mainPanel.add(pWest, BorderLayout.WEST);

		JPanel pEast = new JPanel();
		ziehen = new JButton("Figur ziehen");
		ziehen.setEnabled(false);
		pEast.add(ziehen);
		mainPanel.add(pEast, BorderLayout.EAST);
		ziehen.addActionListener(e);
		e.setButtonZiehen(ziehen);

		fmSpiel.setSize(1000, 800);
		fmSpiel.setResizable(false);
		fmSpiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fmSpiel.setVisible(true);
	}

	public JPanel[] getBlue() {
		return blue;
	}

	public JPanel[] getGreen() {
		return green;
	}

	public JPanel[] getYellow() {
		return yellow;
	}

	public JPanel getpCen() {
		return pCen;
	}

	public JButton[] getFigurenBlue() {
		return figurenBlue;
	}

	public JButton[] getFigurenGreen() {
		return figurenGreen;
	}

	public JButton[] getFigurenYellow() {
		return figurenYellow;
	}

	public iBediener getS() {
		return s;
	}

	public JPanel[] getFields() {
		return fields;
	}

	public JButton[] getFigurenRed() {
		return figurenRed;
	}

	public static void main(String[] args) {

		MngJFrame main = new MngJFrame();
		main.setVisible(true);

	}

	public JButton getZiehen() {
		return ziehen;
	}

	public void figurButton(String farbe) {
		farbe=farbe.toUpperCase();
		switch (farbe) {
		case "RED":
			for (int i = 0; i < 4; i++) {
				figurenRed[i].setVisible(true);
			}
			break;

		case "BLUE":
			for (int i = 0; i < 4; i++) {
				figurenBlue[i].setVisible(true);
			}
			break;

		case "GREEN":
			for (int i = 0; i < 4; i++) {
				figurenGreen[i].setVisible(true);
			}
			break;
		case "YELLOW":
			for (int i = 0; i < 4; i++) {
				figurenYellow[i].setVisible(true);
			}
			break;
		}
	}
	
	public void figurenSetzen(){
		for (int i = 0; i < 4; i++) {
			figurenRed[i] = new JButton("" + (i + 1));
			figurenRed[i].setSize(30, 30);
			figurenRed[i].setForeground(Color.RED);
			red[i].add(figurenRed[i]);
			figurenRed[i].addActionListener(e);
			e.setFigurenRot(figurenRed);
			figurenRed[i].setVisible(false);
			
			figurenBlue[i] = new JButton("" + (i + 1));
			figurenBlue[i].setSize(30, 30);
			figurenBlue[i].setForeground(Color.BLUE);
			blue[i].add(figurenBlue[i]);
			figurenBlue[i].addActionListener(e);
			e.setFigurenBlau(figurenBlue);
			figurenBlue[i].setVisible(false);
			
			figurenGreen[i] = new JButton("" + (i + 1));
			figurenGreen[i].setSize(30, 30);
			figurenGreen[i].setForeground(Color.GREEN);
			green[i].add(figurenGreen[i]);
			figurenGreen[i].addActionListener(e);
			e.setFigurenGruen(figurenGreen);
			figurenGreen[i].setVisible(false);
			
			figurenYellow[i] = new JButton("" + (i + 1));
			figurenYellow[i].setSize(30, 30);
			figurenYellow[i].setForeground(Color.YELLOW);
			yellow[i].add(figurenYellow[i]);
			figurenYellow[i].addActionListener(e);
			e.setFigurenGelb(figurenYellow);
			figurenYellow[i].setVisible(false);
		}
	}

}
