import java.awt.Color;

public class Bird {
	
	private int x;
	private int y;
	private color c;
	
	public enum color {red,green,blue};
	
	public Bird(int xpos, int ypos, color c){
		this.x = xpos;
		this.y = ypos;
		this.c = c;
	}
	
	public color getColor() {
		return c;
	}

	public void isClicked(){
		
	}
	
	

}
