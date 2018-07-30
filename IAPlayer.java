
public class IAPlayer implements Player {
	
	public int SENS;
	
	BoardGame plateau;
	AlphaBeta alphaBeta;
	int nbCoups;


	@Override
	public Domino play() {
	    return alphaBeta.bestMove(plateau, 2);
	}

	
	public void update(Domino l) {
	    this.nbCoups ++;
		plateau.joue(l);
	}
	
	public void setRole(int direction) {
		SENS = direction;
	}
	
	public String getName() {
		return "alphaBeta";

	}
	
	public void reset() {
		this.plateau = new BoardGame();
		this.nbCoups = 0 ;
		if(SENS == Game.COLUMN)
		    alphaBeta = new AlphaBeta(new Heuristic(), SENS, Game.LINE);
		else
		    alphaBeta = new AlphaBeta(new Heuristic(), SENS , Game.COLUMN);

	}
}
