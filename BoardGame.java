import java.util.ArrayList;


public class BoardGame {
	
	boolean board[][] = new boolean[8][8];
	ArrayList<Domino> moves;
	
    public BoardGame() {
		for (int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				board[i][j] = true;
			}
		}
	}
	
	public BoardGame(boolean p[][]) {
		board = p;
	}
	
	
	public BoardGame copy() {
		boolean copy [][] = new boolean [8][8];
		for (int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				copy[i][j]= board[i][j];
			}
		}
		return new BoardGame(copy);
	}


	
	public ArrayList<Domino> coupsPossibles(int direction) {
		moves = new ArrayList<>();
		if (direction == 1){
			for (int i = 0; i<7; i++) {
				for(int j = 0; j<8; j++) {
					if(board[i][j] && board[i+1][j]) moves.add(new Domino(i,j,i+1,j));
				}
			}
		}else{
			for (int i = 0; i<8; i++) {
				for(int j = 0; j<7; j++) {
					if(board[i][j] && board[i][j+1]) moves.add(new Domino(i,j,i,j+1));
				}
			}
		}
		return moves;
	}
	
	public void joue(Domino d) {
		board[d.a.i][d.a.j] = false;
		board[d.b.i][d.b.j] = false;
	}
	
}

