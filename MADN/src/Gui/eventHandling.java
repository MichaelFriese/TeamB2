package Gui;

import java.awt.BorderLayout;
import java.awt.Component;
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
	private JButton[] figurenRot;
	private JButton[] figurenGruen;
	private JButton[] figurenGelb;
	private JButton[] figurenBlau;
	private JButton ziehen;
	private int spielfigurID=0;
		

	public void setFigurenGruen(JButton[] figurenGruen) {
		this.figurenGruen = figurenGruen;
	}

	public void setFigurenGelb(JButton[] figurenGelb) {
		this.figurenGelb = figurenGelb;
	}

	public void setFigurenBlau(JButton[] figurenBlau) {
		this.figurenBlau = figurenBlau;
	}

	public eventHandling(MngJFrame frame){
		this.frame=frame;
		setButtonSchliessen(schliessen);
	}
	
	public void setButtonZiehen(JButton ziehen){
		this.ziehen = ziehen;
	}
	public void setFigurenRot(JButton[] figurenRot) {
		this.figurenRot = figurenRot;
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
							frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
						}else if(frame.getKI()[i].getSelectedItem().toString().equals("KI Defensiv")){
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "defensiv");
							frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
						}
						else{
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "null");
							frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
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
			JButton schliessen = new JButton("schlie�en");
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
		
		if(EventSource == figurenRot[0]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 1;
		}
		
		if(EventSource == figurenRot[1]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 2;
		}
		
		
		if(EventSource == figurenRot[2]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 3;
		}
		
		
		if(EventSource == figurenRot[3]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 4;
		}
		
		if(EventSource == figurenBlau[0]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 1;
		}
		
		if(EventSource == figurenBlau[1]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 2;
		}
		
		
		if(EventSource == figurenBlau[2]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 3;
		}
		
		
		if(EventSource == figurenBlau[3]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 4;
		}
		
		
		
		if(EventSource == figurenGelb[0]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 1;
		}
		
		if(EventSource == figurenGelb[1]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 2;
		}
		
		
		if(EventSource == figurenGelb[2]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 3;
		}
		
		
		if(EventSource == figurenGelb[3]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 4;
		}
		
		
		if(EventSource == figurenGruen[0]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 1;
		}
		
		if(EventSource == figurenGruen[1]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 2;
		}
		
		
		if(EventSource == figurenGruen[2]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 3;
		}
		
		
		if(EventSource == figurenGruen[3]){
			frame.getZiehen().setEnabled(true);
			spielfigurID = 4;
		}
		
		if(EventSource == ziehen){
			Spiel sp = (Spiel) frame.getS();
			int oldPos = sp.getSpieler().get(0).getSpielfigur(spielfigurID).getSpielfeld().getPosition();
			frame.getS().zugDurchfuehren(spielfigurID);
			int newPos = sp.getSpieler().get(0).getSpielfigur(spielfigurID).getSpielfeld().getPosition();
			
			frame.getFields()[newPos-1].add(frame.getFigurenRed()[0]);
//			frame.getRed()[0].repaint(200);
			frame.getFields()[oldPos-1].repaint(200);
			frame.getFields()[newPos-1].repaint(200);
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

