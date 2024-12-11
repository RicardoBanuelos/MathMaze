package mathmaze.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import mathmaze.gameparts.Level;

public class VerticalEnemy extends GameObject{
	
	private int clamp1;
	private int clamp2;
	
	public VerticalEnemy(int x, int y, int Mx, int My, int clamp1, int clamp2, int velocidad, ID id) {
		super(x, y, Mx, My, id);
		this.clamp1 = clamp1;
		this.clamp2 = clamp2;
		velY = velocidad;
		
		/*BufferedImageLoader loader = new BufferedImageLoader();
		try {
			sprite = loader.loadImage("res/enemy.png");
		}catch(IOException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void tick() {
		y+=velY;
		if(y<=clamp1 || y>= clamp2) {
			velY*=(-1);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Level.enemySpriteSheet,x,y,null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,30,30);
	}

}
