package Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import backend.Spiel;
import frontend.iBediener;

public class MngJFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private iBediener s;
	
	private JFrame dialogfenster = new JFrame("Startfenster");
	private JTextField namen[] = new JTextField[4];
	private JComboBox farbwahl[] = new JComboBox[4];
	private JRadioButton kiAgg[] = new JRadioButton[4];
	private JRadioButton kiDef[] = new JRadioButton[4];
	private ButtonGroup group[] = new ButtonGroup[4];
	private JComboBox kiwahl[] = new JComboBox[4];
	
	public MngJFrame() throws IOException {

		setTitle("Mensch ärger dich nicht");
		s = new Spiel();
	    
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
		
		ok.addActionListener(this);
		
		dialogfenster.setAlwaysOnTop(true);
		dialogfenster.setContentPane(panel);
		dialogfenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.paintComponents(panel.getGraphics());
		dialogfenster.setVisible(true);
		dialogfenster.pack();
	}
	
	public void actionPerformed(ActionEvent e){
		String label = e.getActionCommand();
		if(label.equals("Spiel starten")){
			for(int i=0; i<4; i++){
				if(!namen[i].getText().equals("")){
					if(kiwahl[i].getSelectedItem().toString().equals("KI Aggressiv")){
						s.SpielerHinzufuegen(namen[i].getText(), farbwahl[i].getSelectedItem().toString(), "aggressiv");
					}else if(kiwahl[i].getSelectedItem().toString().equals("KI Defensiv")){
						s.SpielerHinzufuegen(namen[i].getText(), farbwahl[i].getSelectedItem().toString(), "defensiv");
					}
					else{
						s.SpielerHinzufuegen(namen[i].getText(), farbwahl[i].getSelectedItem().toString(), "null");
					}
				}
			}
			s.initSpiel();
//			dialogfenster.setVisible(false);
			dialogfenster.dispose();
			spiel();
		}
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
		

		setSize(1000,800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
