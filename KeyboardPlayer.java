import java.util.Scanner;


public class KeyboardPlayer implements Player {
	Scanner scan;
	int role;
	
	public String getName() {
	    return  "Keyboard";
	}
	
	public KeyboardPlayer() {
	    scan = new Scanner(System.in);
	}
	
	public void setRole(int r) {
		role = r;
	}
	
	public void reset(){}
	
	public void update(Domino l){}
	
	@Override
	public Domino play() {
		System.out.println("The left corner have the coordinates 0 0");
		System.out.println("Enter the cooridinates of the left corner of the domino. Separate the two composantes of coordinates with space");
		String l = scan.nextLine();
		String[] s = l.split(" ");
		int i = Integer.parseInt(s[0]);
		int j = Integer.parseInt(s[1]);
		if (role == Game.LINE)
			return new Domino(new Cell(i,j), new Cell(i+1,j));
		else
			return new Domino(new Cell(i,j), new Cell(i,j+1));
	}
}
