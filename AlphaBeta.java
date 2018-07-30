import java.util.ArrayList;


public class AlphaBeta {
		
    private Heuristic h;
    private int playerMin;
    private int playerMax;

    
    public AlphaBeta(Heuristic h, int playerMax, int playerMin) {
        this.h = h;
        this.playerMin = playerMin;
        this.playerMax = playerMax;

    }
    
    public int max (int a, int b) {
        if (a > b)
            return a;
        return b;
    }
    
    public int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }

    
    public int maxAlphaBeta(BoardGame p, int inf, int sup, int depth) {
        ArrayList<Domino> possiblesMoves = p.coupsPossibles(playerMax);
    	if(depth <= 0 || possiblesMoves.size() == 0) {
    		return h.eval(possiblesMoves, playerMax, playerMax);
    	} else {
        	for(Domino c : possiblesMoves) {
	    		BoardGame cp = p.copy();
	    		cp.joue(c);
	    		inf = max(inf,minAlphaBeta(cp, inf, sup, depth-1));

	    		if(inf >= sup)
	    		    return sup;
    		}
    	}
    	return inf;
    }
    
    public int minAlphaBeta(BoardGame p, int inf, int sup, int depth) {
        ArrayList<Domino> possiblesMoves = p.coupsPossibles(playerMin);
    	if(depth <= 0 || possiblesMoves.size() == 0) {
    		return h.eval(possiblesMoves, playerMax, playerMin);
    	} else {
    		for (Domino c : possiblesMoves) {
    			BoardGame cp = p.copy();
    			cp.joue(c);
    			sup = min(sup,maxAlphaBeta(cp, inf, sup, depth--));

    			if(inf >= sup)
    			    return inf;
    		}
    	}
    	return sup;
    }
    
    public Domino bestMove(BoardGame p, int depth) {
    	int inf = Integer.MIN_VALUE;
	    int maxVal = Integer.MIN_VALUE;


	    ArrayList<Domino> possiblesMoves = p.coupsPossibles(playerMax);
	    Domino best = possiblesMoves.get(0);
	    for(int i = 0 ; i<possiblesMoves.size(); i++) {
	        BoardGame cp = p.copy();
			cp.joue(possiblesMoves.get(i));
			inf = max(inf,minAlphaBeta(cp, inf, Integer.MAX_VALUE, depth));

			if(inf != maxVal) {
				best = possiblesMoves.get(i);
				maxVal = inf;
			}
    	}

	    return best;
    }
}
