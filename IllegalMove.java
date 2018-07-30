
public class IllegalMove extends Exception {
	int tour;
	public IllegalMove(){
		super();
	}
	
	public IllegalMove(String s, int t){
		super(s);
		tour = t;
	}
}
