import java.util.ArrayList;


public class MinMax {

    private Heuristic h;

    private int joueurMin;

    private int joueurMax;

    private int nbnoeuds = 0;
       
    private int nbfeuilles = 0;
    
    private Domino best=null ;
    
    public void print(){
    	System.out.println("le nombre de noeuds developpé par minmax est :"+nbnoeuds+"le nombre de feuille est "+nbfeuilles);
    }


    public MinMax(Heuristic h, int joueurMax, int joueurMin) {
        this.h = h;
        this.joueurMin = joueurMin;
        this.joueurMax = joueurMax;
  
    }
   
    public int max (int a, int b){
    if (a>b) return a;
    else return b;
    }
    
    public int min(int a, int b){
    if(a<b) return a;
    else return b;
    }
    
    /*public int maxMin(BoardGame p, int prof){
    	ArrayList<Domino> coupsPossibles = p.coupsPossibles(joueurMax, false);
    	if (prof <= 0 || coupsPossibles.size()==0){
		    nbfeuilles ++;
		    return h.eval(p,joueurMax,joueurMax);
	    }
	    else{
	    	int max = Integer.MIN_VALUE;
	    	for(Domino c : coupsPossibles){
				BoardGame cp = p.copy();
				cp.play(c);
				nbnoeuds ++;
				max = max(max, minMax(cp, prof--));
		   }
	    	return max;
	    }
    }*/
    
    /*public int minMax(BoardGame p, int prof){
    	ArrayList<Domino> coupsPossibles = p.coupsPossibles(joueurMin, false);
    	if (prof <= 0 || coupsPossibles.size()==0){
		    nbfeuilles ++;
		    return h.eval(p, joueurMax,joueurMin);
	    }
	    else{
	    	int min = Integer.MAX_VALUE;
		   	for(Domino c : coupsPossibles){
			   	 BoardGame cp = p.copy();
			   	 cp.play(c);
			   	 nbnoeuds ++;
			   	 min = min(min, maxMin(cp, prof--));
		   	}
		   	return min;
	    }
    }*/
    
    
    /*public Domino meilleurCoup(BoardGame p) {
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        ArrayList<Domino> cou = p.coupsPossibles(joueurMax, false);
        best = cou.get(0);
        for( int i = 1 ; i<cou.size(); i++){
        	BoardGame cp = p.copy();
        	cp.play(cou.get(i));
        	nbnoeuds ++;
        	max = max(max,minMax(cp, 2));
        	if(max!=max1) best = cou.get(i);
        	max1=max;
        }
        if (best == null ) System.out.print("prout");
        return best;
//    }*/


}
