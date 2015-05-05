package Gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import backend.FarbEnum;
import backend.Spiel;
import backend.Spieler;
import backend.Spieler.Spielfigur;
import frontend.iBediener;

public class eventHandling extends JFrame implements ActionListener, iBediener,CaretListener {

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
	private JButton ButtonWuerfel;
	private static JButton schliessen;
	private MngJFrame frame;
	private JFrame dialogfenster = new JFrame("Startfenster");
	private JButton[] figurenRot;
	private JButton[] figurenGruen;
	private JButton[] figurenGelb;
	private JButton[] figurenBlau;
	private JButton ziehen;
	private int spielfigurID = 0;
	private JButton aktuelleFigur;
	private JButton btn;

	public void setFigurenGruen(JButton[] figurenGruen) {
		this.figurenGruen = figurenGruen;
	}

	public void setFigurenGelb(JButton[] figurenGelb) {
		this.figurenGelb = figurenGelb;
	}

	public void setFigurenBlau(JButton[] figurenBlau) {
		this.figurenBlau = figurenBlau;
	}

	public eventHandling(MngJFrame frame) {
		this.frame = frame;
		setButtonSchliessen(schliessen);
	}
	
	public eventHandling(JButton btn){
		this.btn= btn;
	}
	

	public void setButtonZiehen(JButton ziehen) {
		this.ziehen = ziehen;
	}

	public void setFigurenRot(JButton[] figurenRot) {
		this.figurenRot = figurenRot;
	}

	public void setButtonOk(JButton ok) {
		this.ButtonOk = ok;
	}

	public void setButtonStart(JButton start) {
		this.ButtonStart = start;
	}
	public void setButtonWuerfel(JButton wuerfel){
		this.ButtonWuerfel=wuerfel;
	}

	public void setButtonLaden(JButton laden) {
		this.ButtonLaden = laden;
	}

	public void setButtonUeber(JButton ueber) {
		this.ButtonUeber = ueber;
	}

	public void setButtonBeenden(JButton beenden) {
		this.ButtonBeenden = beenden;
	}

	public void setButtonSchliessen(JButton schliessen) {
		this.ButtonSchliessen = schliessen;
	}

	@Override
	public void actionPerformed(ActionEvent a_event) {
		Object EventSource = a_event.getSource();
		if (EventSource == ButtonBeenden) {
			System.exit(0);
		}
		if(EventSource == ButtonWuerfel){
		}
		if (EventSource == ButtonOk) {
			String label = a_event.getActionCommand();
			if (label.equals("Spiel starten")) {
				for (int i = 0; i < 4; i++) {
					if (!frame.getNamen()[i].getText().equals("")) {
						if (frame.getKI()[i].getSelectedItem().toString().equals("KI Aggressiv")) {
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "aggressiv");
							frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
						} else if (frame.getKI()[i].getSelectedItem().toString().equals("KI Defensiv")) {
							frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "defensiv");
							frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
						} else {
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

		if (EventSource == ButtonStart) {

			frame.dialogfenster();
		}
		if (EventSource == ButtonUeber) {
			{

				JFrame ueber = new JFrame();
				ueber.setLayout(null);
				ueber.setResizable(false);
				ueber.setTitle("Ueber uns");
				ueber.setSize(300, 150);
				ueber.setLocationRelativeTo(null);
				ueber.setAlwaysOnTop(true);
				JLabel text = new JLabel("Autoren: \n Doerte, Michael, Tobi");
				text.setBounds(getWidth() / 2, 0, 500, 100);
				JButton schliessen = new JButton("schlie�en");
				schliessen.addActionListener(this);
				schliessen.setBounds(100, 75, 100, 30);
				ueber.add(text);
				ueber.add(schliessen);
				ueber.setVisible(true);
			}
			if (EventSource == ButtonSchliessen) {
				System.exit(0);
			}

		}

		if (EventSource == ButtonLaden) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			laden(chooser.getSelectedFile().getName(), "csv");
		}

		Spiel sp = (Spiel) frame.getS();
		Spieler lokalAmZug = sp.getAmZug();

		if (EventSource == figurenRot[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED)) {
				// figurenRot[0].setFont(new
				// Font(figurenRot[0].getFont().getName(),Font.BOLD,figurenRot[0].getFont().getSize()));
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenRot[0];
			}
		}

		if (EventSource == figurenRot[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenRot[1];
			}
		}

		if (EventSource == figurenRot[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenRot[2];
			}
		}

		if (EventSource == figurenRot[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenRot[3];
			}
		}

		if (EventSource == figurenBlau[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenBlau[0];
			}
		}

		if (EventSource == figurenBlau[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenBlau[1];
			}
		}

		if (EventSource == figurenBlau[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenBlau[2];
			}
		}

		if (EventSource == figurenBlau[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenBlau[3];
			}
		}

		if (EventSource == figurenGelb[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenGelb[0];
			}
		}

		if (EventSource == figurenGelb[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenGelb[1];
			}
		}

		if (EventSource == figurenGelb[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenGelb[2];
			}
		}

		if (EventSource == figurenGelb[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenGelb[3];
			}
		}

		if (EventSource == figurenGruen[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenGruen[0];
			}
		}

		if (EventSource == figurenGruen[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenGruen[1];
			}
		}

		if (EventSource == figurenGruen[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenGruen[2];
			}
		}

		if (EventSource == figurenGruen[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN)) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenGruen[3];
			}
		}

		if (EventSource == ziehen) {
			frame.getS().zugDurchfuehren(spielfigurID);
			int newPos = lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getPosition();
			
			/*---Ins Endfeld laufen--*/	
			switch(lokalAmZug.getSpielfigur(spielfigurID).getFarbe()){
			case RED:
				if(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")){
					int posEndfeld=Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getRed()[posEndfeld+3].add(aktuelleFigur);
				}else{
					frame.getFields()[newPos - 1].add(aktuelleFigur);					
				}
				break;
			case BLUE:
				if(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")){
					int posEndfeld=Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getBlue()[posEndfeld+3].add(aktuelleFigur);
				}else{
					frame.getFields()[newPos - 1].add(aktuelleFigur);					
				}
				break;
			case GREEN:
				if(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")){
					int posEndfeld=Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getGreen()[posEndfeld+3].add(aktuelleFigur);
				}else{
					frame.getFields()[newPos - 1].add(aktuelleFigur);					
				}
				break;
			case YELLOW:
				if(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")){
					int posEndfeld=Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getYellow()[posEndfeld+3].add(aktuelleFigur);
				}else{
					frame.getFields()[newPos - 1].add(aktuelleFigur);					
				}
				break;
			}

			
			/*---Schmeissen--*/
			if(sp.getGeschmissen() != null){	
				switch(sp.getGeschmissen().getFarbe()){
				case RED:
					if(sp.getGeschmissen().getSpielfeld().getID().contains("1")){
						frame.getRed()[0].add(figurenRot[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("2")){
						frame.getRed()[1].add(figurenRot[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("3")){
						frame.getRed()[2].add(figurenRot[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("4")){
						frame.getRed()[3].add(figurenRot[sp.getGeschmissen().getID()-1]);
					}
					break;
				case BLUE:
					if(sp.getGeschmissen().getSpielfeld().getID().contains("1")){
						frame.getBlue()[0].add(figurenBlau[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("2")){
						frame.getBlue()[1].add(figurenBlau[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("3")){
						frame.getBlue()[2].add(figurenBlau[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("4")){
						frame.getBlue()[3].add(figurenBlau[sp.getGeschmissen().getID()-1]);
					}
					break;
				case GREEN:
					if(sp.getGeschmissen().getSpielfeld().getID().contains("1")){
						frame.getGreen()[0].add(figurenGruen[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("2")){
						frame.getGreen()[1].add(figurenGruen[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("3")){
						frame.getGreen()[2].add(figurenGruen[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("4")){
						frame.getGreen()[3].add(figurenGruen[sp.getGeschmissen().getID()-1]);
					}
					break;
				case YELLOW:
					if(sp.getGeschmissen().getSpielfeld().getID().contains("1")){
						frame.getYellow()[0].add(figurenGelb[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("2")){
						frame.getYellow()[1].add(figurenGelb[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("3")){
						frame.getYellow()[2].add(figurenGelb[sp.getGeschmissen().getID()-1]);
					}else if(sp.getGeschmissen().getSpielfeld().getID().contains("4")){
						frame.getYellow()[3].add(figurenGelb[sp.getGeschmissen().getID()-1]);
					}
					break;
				}

			}
			System.out.println("geschmissen "+ sp.getGeschmissen());
			
			frame.getpCen().repaint();
			ziehen.setEnabled(false);
		}
	}

	public Object laden(String dateiname, String dateieinde) {
		iBediener s = new Spiel();
		return s.laden(dateiname, "");

	}

	public void actionPerformedNew(ActionEvent a_event2) {
		Object EventSourceNew = a_event2.getSource();
		if (EventSourceNew == ButtonSchliessen) {
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
	public void Speichern(String dateiname, String dateiende) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		JTextField field= (JTextField)e.getSource();
		
		String text= field.getText();
		btn.setEnabled(!text.trim().isEmpty());
		
	}

	@Override
	public int getWuerfel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setIconBild(int erg) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
