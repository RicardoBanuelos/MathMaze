package mathmaze.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import mathmaze.external.AudioPlayer;
import mathmaze.gameparts.GameLoop;
import mathmaze.gameparts.Hud;
import mathmaze.gameparts.Level;

public class Cubi extends GameObject{
	
	private Random r = new Random();
	private Handler handler;
	private Hud hud;
	
	//cubi es nuestra clase JUGADOR, pero le pusimos cubi porque asi queremos que se llame el jugador
	public Cubi(int x, int y, int Mx, int My, ID id, Handler handler, Hud hud) {
		super(x, y, Mx, My, id);
		this.handler = handler;
		this.hud = hud;
	}

	@Override
	//tick actualiza variables de cubi
	public void tick() {
		//el clamp solo fue utilizado para cuando el juego todavia no tenia habilitada la matriz para ser seguida,
		//resulta inutil en el momento
		x = GameLoop.clamp(x, 40, 830 - 30);
		y = GameLoop.clamp(y, 40, 830 - 30);
		//clampMatrix es para que no se salga de los limites de la matriz
		//y no crashe el juego
		Mx = clampMatrix(Mx,0,19);
		My = clampMatrix(My,0,19);
		//detecta si el jugador llega a una prueba, en caso de que si, cambia a estado de
		//question
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				if(hud.getLevel() == 1) {
					if(Level.levelOne[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelOne[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(2);
						rellocateCubi(80,760,1,18);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 2) {
					if(Level.levelTwo[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelTwo[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(3);
						rellocateCubi(80,80,1,1);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 3) {
					if(Level.levelThree[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelThree[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(4); 
						rellocateCubi(80,400,1,9);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 4) {
					if(Level.levelFour[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelFour[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(5);
						rellocateCubi(80,400,1,9);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 5) {
					if(Level.levelFive[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelFive[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(6);
						rellocateCubi(400,720,9,17);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 6) {
					if(Level.levelSix[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelSix[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(7);
						rellocateCubi(400,320,9,7);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 7) {
					if(Level.levelSeven[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelSeven[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(8);
						rellocateCubi(760,80,18,1);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 8) {
					if(Level.levelEight[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelEight[My][Mx]==5) {
						AudioPlayer.playSound("res/tp.wav");
						hud.setLevel(9);
						rellocateCubi(80,360,1,8);
						handler.clearEnemys();
					}
				}
				if(hud.getLevel() == 9) {
					if(Level.levelNine[My][Mx]==2) {
						GameLoop.GameState = GameLoop.STATE.Test;
					}
					if(Level.levelNine[My][Mx]==5) {
						GameLoop.win = true;
					}
				}
			}
		}
		collision();
	}
	//metodo que detecta si cubi intersecta con otro objeto
	//por el momento inutil ya que no hemos agregado enemigos
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Enemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					AudioPlayer.playSound("res/hurt.wav");
					hud.setScore(hud.getScore()-3);
					if(hud.getLevel() <= 3 && hud.getLevel() >=1)
						hud.setHealth(hud.getHealth()-1);
					else if(hud.getLevel() <= 6 && hud.getLevel() >=4)
						hud.setHealth(hud.getHealth()-2);
					else if(hud.getLevel() <= 9 && hud.getLevel() >=7)
						hud.setHealth(hud.getHealth()-4);
				}
			}
		}
		
	}
	
	public void rellocateCubi(int x, int y, int mx, int my) {
		this.x = x;
		this.y = y;
		this.Mx = mx;
		this.My = my;
	}

	@Override
	//render que pinta a cubi
	public void render(Graphics g) {

		g.setColor(new Color(r.nextInt(255),0,r.nextInt(255)));
		g.fillRect(x, y, 20, 20);
		g.setColor(Color.black);
		g.drawRect(x, y, 20, 20);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,20,20);
	}
	
	private static int clampMatrix(int var, int min, int max) {
		if(var<=min) {
			return (var=min);
		}
		else if(var>=max) {
			return (var=max);
		}
		else {
			return var;
		}
	}
}
