package mathmaze.gameobject;

import java.awt.Graphics;
import java.util.ArrayList;

import mathmaze.gameparts.GameLoop;
import mathmaze.gameparts.Hud;

public class Handler {
	
	//arreglo que contiene a cubi, y cualquier enemigo que agreguemos, incluso los cubis del menu
	public ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	private Hud hud = new Hud();
	
	public int speed = 2;
	
	public Handler(Hud hud) {
		this.hud = hud;
	}
	
	//actualiza las variables de todos los objetos
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			
			GameObject tempObject = null;
			tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	//actualiza los graficos de todos los objetos
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			
			GameObject tempObject = null;
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	//elimina a todos los objetos menos a cubi
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = null;
			tempObject = object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				object.clear();
				if(GameLoop.GameState == GameLoop.STATE.Game) {
				addObject(new Cubi(tempObject.getX(),tempObject.getY(), tempObject.getMx(), tempObject.getMy(), ID.Player,this,hud));
				}
			}
		}
	}
	
	//agrega objeto
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	//quita objeto
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
