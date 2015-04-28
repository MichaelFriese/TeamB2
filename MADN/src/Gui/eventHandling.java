package Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import backend.Spiel;
import frontend.iBediener;

public class eventHandling extends JFrame implements ActionListener, iBediener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton ButtonStart;
	private JButton ButtonLaden;
	private JButton ButtonUeber;
	private JButton ButtonBeenden;
	private JButton ButtonSchliessen;
	private JButton ButtonOk;
	private static JButton schliessen;
	private MngJFrame frame;
	private JFrame dialogfenster = new JFrame("Startfenster");
		
	public eventHandling(MngJFrame frame){
		this.frame=frame;
		setButtonSchliessen(schliessen);
	}
	
	public void setButtonOk(JButton ok){
		this.ButtonOk=ok;
	}
	public void setButtonStart(JButton start){
		this.ButtonStart=start;
	}
	public void setButtonLaden(JButton laden){
		this.ButtonLaden=laden;
	}
	public void setButtonUeber(JButton ueber){
		this.ButtonUeber=ueber;
	}
	public void setButtonBeenden(JButton beenden){
		this.ButtonBeenden=beenden;
	}
	public void setButtonSchliessen(JButton schliessen){
		this.ButtonSchliessen=schliessen;
	}

	@Override
	public void actionPerformed(ActionEvent a_event) {
		Object EventSource=a_event.getSource();
		if(EventSource == ButtonBeenden){
			System.exit(0);
		}
		if(EventSource == ButtonOk){
			String label = a_event.getActionCommand();
			if(label.equals("Spiel starten")){
				for(int i=0; i<4; i++){
					if(!frame.getNamen()[i].getText().equals("")){
						if(frame.getKI()[i].getSelectedItem().toString().equals("KI Aggressiv")){
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "aggressiv");
						}else if(frame.getKI()[i].getSelectedItem().toString().equals("KI Defensiv")){
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "defensiv");
						}
						else{
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "null");
						}
					}
				}
				frame.getSpiel().initSpiel();
				frame.getDialogFenster().setVisible(false);
				frame.getDialogFenster().dispose();
				frame.spiel();
			}
		}
		
		if(EventSource == ButtonStart){
//			JPanel panel = new JPanel();
//			setSize(500,500);
//			add(panel);
//			panel.setLayout(new GridLayout(6,3));
//			
//			JLabel name = new JLabel("Name");
//			JLabel farbe = new JLabel("Farbe");
//			JLabel ki = new JLabel("KI");
//			panel.add(name);
//			panel.add(farbe);
//			panel.add(ki);
//			
//			JTextField namen[] = new JTextField[4];
//			JComboBox farbwahl[] = new JComboBox[4];
//			JRadioButton kiauswahl[] = new JRadioButton[4];
//			String f[] = {"Red", "Yellow", "Blue", "Green"};
//			for(int i=0; i< namen.length; i++){
//				namen[i] = new JTextField();
//				panel.add(namen[i]);
//				farbwahl[i] = new JComboBox(f);
//				panel.add(farbwahl[i]);
//				kiauswahl[i] = new JRadioButton();
//				panel.add(kiauswahl[i]);
//			
//				setAlwaysOnTop(true);
//				setContentPane(panel);
//				panel.paintComponents(panel.getGraphics());
//				setVisible(true);
//			}
//			JButton ok = new JButton("Spiel starten");
//			panel.add(ok);
//			
//			setAlwaysOnTop(true);
//			setContentPane(panel);
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//			panel.paintComponents(panel.getGraphics());
//			setVisible(true);
			frame.dialogfenster();
		}
		if(EventSource == ButtonUeber){{
			
			JFrame ueber = new JFrame();
			ueber.setLayout(null);
			ueber.setResizable(false);
			ueber.setTitle("Ueber uns");
			ueber.setSize(300,150);
			ueber.setLocationRelativeTo(null);
			ueber.setAlwaysOnTop(true);
			JLabel text = new JLabel("Autoren: \n Doerte, Michael, Tobi");
			text.setBounds(getWidth()/2,0,500,100);
			JButton schliessen = new JButton("schließen");
			schliessen.addActionListener(this);
			schliessen.setBounds(100, 75, 100, 30);
			ueber.add(text);
			ueber.add(schliessen);
			ueber.setVisible(true);
			}
			if(EventSource == ButtonSchliessen){
				System.exit(0);
			}
			
		}
		
		
		
		if(EventSource == ButtonLaden){
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			laden(chooser.getSelectedFile().getName(), "csv");
			
		}
	}
		public Object laden(String dateiname, String dateieinde) {
		iBediener s = new Spiel();
		return s.laden(dateiname, "");
		
		}
		public void actionPerformedNew(ActionEvent a_event2){
			Object EventSourceNew=a_event2.getSource();
			if(EventSourceNew == ButtonSchliessen){
				System.exit(0);
			}
		}
		@Override
		public void SpielerHinzufuegen(String name, String farbe, String ki) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initSpiel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void zugDurchfuehren(int ID) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void zugDurchfuehrenSchmeissenTest(int ID) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void zugDurchfuehrenEndfeldTest(int ID) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initTestSpiel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initTestSpielZugAggressiv() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initTestSpielZugDefensiv() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Speichern(String dateiname, String dateiende)
				throws IOException {
			// TODO Auto-generated method stub
			}
		
	}

