
public class Alien extends Sprite{
	
	private static final int EASY_SPEED = 1;
	private static final int MEDIUM_SPEED = 2;
	private static final int HARD_SPEED = 3;
	private int speed_y;
	private String type;

	public Alien(int x, int y) {
		super(x, y);
		speed_y = EASY_SPEED;
		type = "images/alien_EASY.png";
		visible = true;
	}
	


	public void update(){
		loadImage(type);
		y+=speed_y;
	}
	
	

}
