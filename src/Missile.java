
public class Missile extends Sprite{
	private int speed_y;
	
	public Missile(int x, int y) {
		super(x+6, y);
		speed_y = 2;
		visible = true;
	}
		
	public void update(){
		y-=speed_y;
		loadImage("images/missile.png");
	}

	public int getSpeed_y() {
		return speed_y;
	}


	public void setSpeed_y(int speed_y) {
		this.speed_y = speed_y;
	}
	
}
