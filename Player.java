
public interface Player {
		
	public Domino play();
	public void update(Domino l);
	public void setRole(int direction);
	public String getName();
	public void reset();
}
