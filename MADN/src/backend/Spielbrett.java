package backend;

public class Spielbrett {

	private FeldWrapper spielbrett[];
	
	public Spielbrett() {

		spielbrett = new FeldWrapper[40];
		for (int i = 0; i < spielbrett.length; i++) {
			switch (i + 1) {
			case (1):
				spielbrett[i] = new FeldWrapper(true, false, FarbEnum.red);
			break;
			case (11):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.blue);
			break;
			case (21):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.yellow);
			break;
			case (31):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.green);
			break;
			case (10):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.blue);
			break;
			case (20):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.green);
			break;
			case (30):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.yellow);
			break;
			case (40):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.red);
			break;
			default:
				spielbrett[i] = new FeldWrapper(false, false,null);
			}

		}

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
