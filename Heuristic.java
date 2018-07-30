import java.util.ArrayList;

public class Heuristic {
	public int eval (ArrayList<Domino> p, int player, int currentPlayer){
		if (player == 1) {
			int nbMovesMax = p.size();
			if(nbMovesMax == 0) {
				if(1 == currentPlayer)
					return Integer.MIN_VALUE;
			}

			int nbMovesMin = p.size();
			if(nbMovesMin == 0){
				if(0 == currentPlayer)
				    return Integer.MAX_VALUE;
			}

			return (nbMovesMax - nbMovesMin) ;
		} else {
			int nbMovesMax = p.size();
			if(nbMovesMax == 0){
				if(0 == currentPlayer) return Integer.MIN_VALUE;
			}


			int nbMovesMin = p.size();
			if(nbMovesMin==0){
				if(1 == currentPlayer) return Integer.MAX_VALUE;
			}

			return (nbMovesMax - nbMovesMin) ;
		}
	}
}
