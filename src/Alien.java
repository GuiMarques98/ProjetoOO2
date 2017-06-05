
public class Alien extends Sprite{
	
	private static final int speed_y = 1;
	private String type;

	public Alien(int x, int y) {
		super(x, y);
		type = "images/alien_EASY.png";
		visible = true;
	}
	
	public Alien(int x, int y, String type) {
		super(x, y);
		this.type = type;
		visible = true;
	}

	public void update(){
		loadImage(type);
		y+=speed_y;
	}
	
	

}
