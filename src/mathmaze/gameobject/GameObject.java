package mathmaze.gameobject;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected float velX, velY;
	protected int Mx, My;
	public BufferedImage sprite = null; //Variable para definir sprite de objetos
	
	//de aqui nace cubi, y todos los objetos que agreguemos que sean como el,
	//contien posiscion x y para los pixeles
	//contiene mx y my para el desplazamiento en matriz
	//contiene velocidad para las particulas del menu y antes para cubi pero ya no
	public GameObject(int x, int y, int Mx, int My, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.Mx = Mx;
		this.My = My;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//setters y getters de las variables
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return velX;
	}
	public float velY() {
		return velY;
	}
	public void setMx(int Mx) {
		this.Mx = Mx;
	}
	public void setMy(int My) {
		this.My = My;
	}
	
	public int getMx() {
		return Mx;
	}
	public int getMy() {
		return My;
	}
}
