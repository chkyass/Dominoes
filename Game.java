import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {
	public int n;
	int it;
	boolean[][] boardGame;
	Set<Domino> lineMoves;
	Set<Domino> columnMoves;
	JFrame display;
	boolean displayOn;
	final static int COLUMN =0;
	final static int LINE =1;
	Player line;
	Player column;
	
	public Game(int size, boolean displayState){
		displayOn = displayState;
		n = size;
		boardGame = new boolean[n][n];
		for (int i = 0;i<n; i++)
			for(int j = 0; j<n; j++)
				boardGame[i][j] = true;
		
		lineMoves = new HashSet<Domino>();
		columnMoves = new HashSet<Domino>();
		if (displayOn){
			display = new JFrame();
			display.setTitle("Game");
			display.setSize(600,600);
			display.add(new Grillage());
			display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			display.setVisible(true);
		}
	}
	
	
	public boolean legal(Domino l){
		boolean test1 = (l.a.i >=0 && l.a.i < n && l.b.i >=0 && l.b.i < n && boardGame[l.a.i][l.a.j] && boardGame[l.b.i][l.b.j]);
		boolean horizontal = ((l.a.i == l.b.i) && ((l.a.j-l.b.j==1) || l.a.j-l.b.j==-1));
		boolean vertical = ((l.a.j == l.b.j) && ((l.a.i-l.b.i==1) || l.a.i-l.b.i==-1)); 
		return (test1 && (horizontal || vertical));
	}
	
	public void play() throws IllegalMove{
		Domino l;
		int turn;
		if (it%2 == 0)
			turn = LINE;
		else
			turn = COLUMN;
		if (turn == LINE){
			l = line.play();
			System.out.println(line.getName()+" play ("+l.a.i +","+l.a.j+") -> (" + l.b.i +","+l.b.j+")");
		}
		else{
			l = column.play();
			System.out.println(column.getName()+" play ("+l.a.i +","+l.a.j+") -> (" + l.b.i +","+l.b.j+")");
		}
		
		if (legal(l)){
			if (turn == LINE){
				lineMoves.add(l);
				column.update(l);
				line.update(l);
			}
			else{
				columnMoves.add(l);
				line.update(l);
				column.update(l);
			}
			boardGame[l.a.i][l.a.j] = false;
			boardGame[l.b.i][l.b.j] = false;
			if (displayOn){
				display();
			}
		}
		else{
			String guilty;
			if (turn == LINE)
				guilty = "LINE";
			else	
				guilty = "COLUMN";
			throw new IllegalMove("The move is illegal " + guilty + "!", turn);
		}	
	}

	
	public void display(){
		display.repaint();
	}
	

	/** classe interne pour l'display graphique du jeu */
	public class Grillage extends JPanel {

		public Grillage() {
			setBackground(Color.yellow);
		}

		public void paintComponent(Graphics g) {
			int step = 40;
			int border = 5;
			int pointSize = 8;

			g.setColor(Color.red);
			for (Domino l : lineMoves) {
				int x = (1 + l.a.i)*step;
				int y = (n - l.a.j)*step;
				if (l.a.i < l.b.i)
					g.fillRect(x,y, step, pointSize);
				else
					g.fillRect(x-step,y,step,pointSize);
			}
			g.setColor(Color.cyan);
			for (Domino l : columnMoves) {
				int x = (1 + l.a.i)*step;
				int y = (n - l.a.j)*step;
				if (l.a.j < l.b.j)
					g.fillRect(x,y-step, pointSize, step);
				else
					g.fillRect(x,y, pointSize, step);
			}
			g.setColor(Color.black);
			for (int  i= 1; i<=n; i++){
				for (int j=1;j<=n;j++){
					g.fillOval(i*step-pointSize/2, j*step, pointSize, pointSize);
				}
			}	
		}
	}
	
	public boolean isOver(){
		if (it%2 == 0){
			for (int i = 0; i<n-1; i++){
				for (int j = 0; j<n;j++){
					if (boardGame[i][j] && boardGame[i+1][j])
						return false;
				}
			}
		}
		else {
			for (int i = 0; i<n; i++){
				for (int j = 0; j < n-1; j++){
					if (boardGame[i][j] && boardGame[i][j+1])
						return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isOver(boolean[][] libre, int role){
		int n= libre.length;
		if (role == LINE){
			for (int i=0;i<n-1; i++){
				for (int j = 0; j<n; j++){
					if (libre[i][j] && libre[i+1][j])
						return false;
				}
			}
		}
		else {
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n-1; j++){
					if (libre[i][j] && libre[i][j+1])
						return false;
				}
			}
		}
		return true;
	}
	

	 public Player playGame(){

         System.out.println("Game begin");

         int winer = -1;

         while (!isOver()) {
             try{
                play();
             } catch(IllegalMove e){
                 System.out.println(e);
                 winer = it%2;
                 break;
             }
            it++;
         }

         if (displayOn)
             display();

         winer = it%2;

         if (winer == LINE) {
             System.out.println("The winner is " + line.getName());
            return line;
         }

         System.out.println("The winner is " + column.getName());
         return column;
	 }

	public void reset(){
		it = 0;
		line.reset();
		column.reset();
		for (int i = 0; i<n; i++)
			for (int j = 0; j<n; j++)
				boardGame[i][j] = true;
		lineMoves.clear();
		columnMoves.clear();
	}
	
	
	public static void main(String[] args){
		
		int taille =8;
		
		Player keyboard = new KeyboardPlayer();
		//Player clavier = new IAPlayer();
		Player IA = new IAPlayer();
		Game g = new Game(taille,true);
		
		g.line = keyboard;
		g.column = IA;
		g.line.setRole(LINE);
		g.column.setRole(COLUMN);
		
		
		Vector<String> result = new Vector<String>();
		for (int i=0;i<1;i++){
			g.reset();
			result.add(g.playGame().getName());
		}


		Player j = g.column;
		g.column = g.line;
		g.line = j;
		g.line.setRole(LINE);
		g.column.setRole(COLUMN);
		
		for (int i = 0; i<1; i++){
			g.reset();
			result.add(g.playGame().getName());
		}

	}
}
