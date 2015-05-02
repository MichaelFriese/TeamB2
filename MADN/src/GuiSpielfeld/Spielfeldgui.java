package GuiSpielfeld;
import javax.swing.JFrame;




public class Spielfeldgui extends JFrame{
	
	public Spielfeldgui(){
	
	 
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 this.setLayout(null);
	 Kreis[] kreis= new Kreis[8];
	 for (int i=0; i<=7; i++){
		 kreis[i]= new Kreis();
	 }
	
	 kreis[0].setBounds(1, 0, 20, 20);
	this.add(kreis[0]);
	kreis[1].setBounds(1, 50, 20, 20);
	this.add(kreis[1]);
	
	kreis[2].setBounds(50, 1, 20, 20);
	this.add(kreis[2]);
	
	kreis[3].setBounds(50, 50, 20, 20);
	this.add(kreis[3]);

	kreis[4].setBounds(250, 50, 20, 20);
	this.add(kreis[4]);
	kreis[5].setBounds(250, 100, 20, 20);
	this.add(kreis[5]);
	kreis[6].setBounds(250, 150, 20, 20);
	this.add(kreis[6]);
	kreis[7].setBounds(250, 200, 20, 20);
	this.add(kreis[7]);
	
	
	
	
	
	
	KreisBlau[] kreisBlau= new KreisBlau[8];
	 for (int i=0; i<=7; i++){
		 kreisBlau[i]= new KreisBlau();
	 }
	 
	 
	 kreisBlau[0].setBounds(550, 0, 20, 20);
		this.add(kreisBlau[0]);
		
		kreisBlau[1].setBounds(550, 50, 20, 20);
		this.add(kreisBlau[1]);
		
		kreisBlau[2].setBounds(500, 50, 20, 20);
		this.add(kreisBlau[2]);
		
		kreisBlau[3].setBounds(500, 0, 20, 20);
		this.add(kreisBlau[3]);
	
	kreisBlau[4].setBounds(450, 250, 20, 20);
	this.add(kreisBlau[4]);
	
	kreisBlau[5].setBounds(400, 250, 20, 20);
	this.add(kreisBlau[5]);
	
	
	kreisBlau[6].setBounds(350, 250, 20, 20);
	this.add(kreisBlau[6]);
	
	kreisBlau[7].setBounds(300, 250, 20, 20);
	this.add(kreisBlau[7]);
	
	
	
	
	
	
	
	
	KreisGruen[] kreisGruen= new KreisGruen[8];
	 for (int i=0; i<=7; i++){
		 kreisGruen[i]= new KreisGruen();
	 }

	

	 kreisGruen[0].setBounds(500, 500, 20, 20);
	this.add(kreisGruen[0]);
	
	 kreisGruen[1].setBounds(500, 550, 20, 20);
	this.add(kreisGruen[1]);
	
	
	 kreisGruen[2].setBounds(550, 550, 20, 20);
	this.add(	 kreisGruen[2]);
	
	 kreisGruen[3].setBounds(550, 500, 20, 20);
	this.add(kreisGruen
			[3]);
	
	
	kreisGruen[4].setBounds(250, 450, 20, 20);
	this.add(kreisGruen[4]);
	
	
	kreisGruen[5].setBounds(250, 400, 20, 20);
	this.add(kreisGruen[5]);
	
	
	kreisGruen[6].setBounds(250, 350, 20, 20);
	this.add(kreisGruen[6]);
	
	kreisGruen[7].setBounds(250, 300, 20, 20);
	this.add(kreisGruen[7]);
	
	
	
	KreisGelb[] kreisGelb= new KreisGelb[8];
	 for (int i=0; i<=7; i++){
		 kreisGelb[i]= new KreisGelb();
	 }
	
	 kreisGelb[0].setBounds(0, 550, 20, 20);
	this.add(kreisGelb[0]);
	
	kreisGelb[1].setBounds(50, 550, 20, 20);
	this.add(kreisGelb[1]);
	
	kreisGelb[2].setBounds(50, 500, 20, 20);
	this.add(kreisGelb[2]);
	
	kreisGelb[3].setBounds(0, 500, 20, 20);
	this.add(kreisGelb[3]);
	
	
	kreisGelb[4].setBounds(50, 250, 20, 20);
	this.add(kreisGelb[4]);
	
	kreisGelb[5].setBounds(100, 250, 20, 20);
	this.add(kreisGelb[5]);
	
	
	kreisGelb[6].setBounds(150, 250, 20, 20);
	this.add(kreisGelb[6]);
	
	
	
	kreisGelb[7].setBounds(200, 250, 20, 20);
	this.add(kreisGelb[7]);
	
	KreisGrau[] kreisGrau= new KreisGrau[42];
	
	for (int i=0; i<42;i++){
		kreisGrau[i]= new KreisGrau();
	}
		kreisGrau[0].setBounds(0, 200, 20, 20);
	this.add(kreisGrau[0]);
	
	kreisGrau[1].setBounds(50, 200, 20, 20);
	this.add(kreisGrau[1]);
	
	kreisGrau[2].setBounds(100, 200, 20, 20);
	this.add(kreisGrau[2]);
	kreisGrau[3].setBounds(150, 200, 20, 20);
	this.add(kreisGrau[3]);
	kreisGrau[4].setBounds(200, 200, 20, 20);
	this.add(kreisGrau[4]);
	
	kreisGrau[5].setBounds(200, 150, 20, 20);
	this.add(kreisGrau[5]);
	
	kreisGrau[6].setBounds(200, 100, 20, 20);
	this.add(kreisGrau[6]);
	
	kreisGrau[7].setBounds(200, 50, 20, 20);
	this.add(kreisGrau[7]);
	
	kreisGrau[8].setBounds(200,0, 20, 20);
	this.add(kreisGrau[8]);
	
	kreisGrau[9].setBounds(250, 0, 20, 20);
	this.add(kreisGrau[9]);
	
	kreisGrau[10].setBounds(250, 0, 20, 20);
	this.add(kreisGrau[10]);
	
	kreisGrau[11].setBounds(300, 0, 20, 20);
	this.add(kreisGrau[11]);
	
	kreisGrau[12].setBounds(300, 50, 20, 20);
	this.add(kreisGrau[12]);
	
	kreisGrau[13].setBounds(300, 100, 20, 20);
	this.add(kreisGrau[13]);
	
	kreisGrau[14].setBounds(300, 150, 20, 20);
	this.add(kreisGrau[14]);
	
	kreisGrau[15].setBounds(300, 200, 20, 20);
	this.add(kreisGrau[15]);
	
	kreisGrau[16].setBounds(350, 200, 20, 20);
	this.add(kreisGrau[16]);
	
	kreisGrau[17].setBounds(400, 200, 20, 20);
	this.add(kreisGrau[17]);
	
	kreisGrau[18].setBounds(450, 200, 20, 20);
	this.add(kreisGrau[18]);
	
	kreisGrau[19].setBounds(500, 200, 20, 20);
	this.add(kreisGrau[19]);
	
	kreisGrau[20].setBounds(500, 250, 20, 20);
	this.add(kreisGrau[20]);
	
	kreisGrau[21].setBounds(500, 300, 20, 20);
	this.add(kreisGrau[21]);
	
	kreisGrau[22].setBounds(450, 300, 20, 20);
	this.add(kreisGrau[22]);
	
	kreisGrau[23].setBounds(400, 300, 20, 20);
	this.add(kreisGrau[23]);
	
	kreisGrau[24].setBounds(350, 300, 20, 20);
	this.add(kreisGrau[24]);
	
	kreisGrau[25].setBounds(300, 300, 20, 20);
	this.add(kreisGrau[25]);
	
	kreisGrau[26].setBounds(300, 350, 20, 20);
	this.add(kreisGrau[26]);
	
	kreisGrau[27].setBounds(300, 400, 20, 20);
	this.add(kreisGrau[27]);
	
	kreisGrau[28].setBounds(300, 450, 20, 20);
	this.add(kreisGrau[28]);
	
	kreisGrau[29].setBounds(300, 500, 20, 20);
	this.add(kreisGrau[29]);
	
	kreisGrau[30].setBounds(250, 500, 20, 20);
	this.add(kreisGrau[30]);
	
	kreisGrau[31].setBounds(200, 500, 20, 20);
	this.add(kreisGrau[31]);
	
	kreisGrau[32].setBounds(200, 450, 20, 20);
	this.add(kreisGrau[32]);
	
	kreisGrau[33].setBounds(200, 400, 20, 20);
	this.add(kreisGrau[33]);
	
	kreisGrau[34].setBounds(200, 350, 20, 20);
	this.add(kreisGrau[34]);
	
	kreisGrau[35].setBounds(200, 300, 20, 20);
	this.add(kreisGrau[35]);
	
	kreisGrau[36].setBounds(150, 300, 20, 20);
	this.add(kreisGrau[36]);
	
	kreisGrau[37].setBounds(100, 300, 20, 20);
	this.add(kreisGrau[37]);
		

	kreisGrau[38].setBounds(50, 300, 20, 20);
	this.add(kreisGrau[38]);
	
	kreisGrau[39].setBounds(0, 300, 20, 20);
	this.add(kreisGrau[39]);
	
	kreisGrau[40].setBounds(0, 250, 20, 20);
	this.add(kreisGrau[40]);
	
	 this.setVisible(true);
	 this.pack();
	 this.setSize(600, 600);
	 
	
	
	}
	
}
