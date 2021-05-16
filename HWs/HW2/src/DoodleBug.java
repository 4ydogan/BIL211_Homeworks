
public class DoodleBug extends Bug {
	private int eaten = 0;
	
	public DoodleBug() {
		
	}
	
	public int getEaten() {
		return eaten;
	}
	
	public void eat() {
		eaten = 0;
	}
	
	public void notEat() {
		eaten++;
	}
}
