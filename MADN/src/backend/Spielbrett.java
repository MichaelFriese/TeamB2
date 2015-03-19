package backend;

public class Spielbrett {

	private FeldWrapper spielbrett[];
	
	public Spielbrett() {

		spielbrett = new FeldWrapper[40];
		for (int i = 0; i < spielbrett.length; i++) {
			switch (i + 1) {
			case (1):
				spielbrett[i] = new FeldWrapper(true, false, FarbEnum.RED);
			break;
			case (11):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.BLUE);
			break;
			case (21):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.YELLOW);
			break;
			case (31):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.GREEN);
			break;
			case (10):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.BLUE);
			break;
			case (20):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.GREEN);
			break;
			case (30):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.YELLOW);
			break;
			case (40):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.RED);
			break;
			default:
				spielbrett[i] = new FeldWrapper(false, false,null);
			}

		}

	}
	
	public FeldWrapper[] getSpielbrett() {
		return spielbrett;
	}
	public void setSpielbrett(){
		
	}
	
	
	
	
	
	@Override 
	public String toString(){
		String s="";
		for(FeldWrapper w:spielbrett){
			s+=w.toString()+"\n";
		}
		return s;
	}
}
