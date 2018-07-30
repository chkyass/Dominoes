
public class Domino {
	Cell a,b;
	
	public Domino(Cell p1, Cell p2){
		a = p1; b=p2;
	}

	public Domino(int xi, int xj, int yi, int yj){
		a = new Cell(xi,xj);
		b = new Cell(yi,yj);
	}
	
	public String toString(){
		return "("+a.i+","+a.j+")"+ "("+b.i+","+b.j+")";
	}
}
