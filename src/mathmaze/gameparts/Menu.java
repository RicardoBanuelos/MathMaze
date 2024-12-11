package mathmaze.gameparts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import mathmaze.external.AudioPlayer;
import mathmaze.gameobject.Cubi;
import mathmaze.gameobject.Handler;
import mathmaze.gameobject.ID;

public class Menu extends MouseAdapter{
	
	//private Game game;
	private Handler handler;
	private Hud hud;
	private Random r = new Random();
	protected Cubi cubi;
	
	public Menu(Handler handler, Hud hud) {
		this.handler = handler;
		this.hud = hud;
		cubi = new Cubi(80,200,1,4,ID.Player,handler,hud);
	}
	//cuando usuario hace click
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//si esta en el menu//
		if(GameLoop.GameState == GameLoop.STATE.Menu) {
			//si presiona play, cambia estado a game y agrega al jugador 
			if(mouseOver(mx,my,505, 210, 210, 80)) {
				AudioPlayer.playSound("res/button.wav");
				GameLoop.GameState = GameLoop.STATE.Game;
				handler.addObject(cubi);
				handler.clearEnemys();
			}
			//si presiona instrucciones cambia de estado y muestra instrucciones
			if(mouseOver(mx,my,350, 369, 520, 60)) {
				AudioPlayer.playSound("res/button.wav");
				GameLoop.GameState = GameLoop.STATE.Instrucciones;
			}
			//si presiona exit pues se sale duh
			if(mouseOver(mx,my,515, 510, 180, 60)) {
				AudioPlayer.playSound("res/button.wav");
				System.exit(1);
			}
		}
		//si esta en estado instrucciones
		if(GameLoop.GameState == GameLoop.STATE.Instrucciones) {
			//si presina back regresa estado a menu
			if(mouseOver(mx,my,495, 720, 220,65)) {
				AudioPlayer.playSound("res/button.wav");
				GameLoop.GameState = GameLoop.STATE.Menu;
			}
		}
		if(GameLoop.GameState == GameLoop.STATE.End) {
			if(mouseOver(mx,my,500, 460, 220, 60)) {
				AudioPlayer.playSound("res/button.wav");
				GameLoop.GameState = GameLoop.STATE.Menu;
				hud.resetGame();
			}
		}
	}
	public void mouseReleased(MouseEvent e) {

	}
	//funcion que regresa falso o verdadero dependiendo donde este el mouse
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		Font font = new Font("algerian", 2, 100);
		Font font2 = new Font("algerian", 0, 80);
		Font font3 = new Font("algerian", 2, 60);
		Font font4 = new Font("arial",2,30);
		
		/*for(int i = 0; i < 1200/20; i++) {
			for(int j = 0; j < 900/20; j++) {
				g.setColor(Color.white);
				g.drawRect(i*20, j*20, 20, 20);
			}
		}*/
		if(GameLoop.GameState == GameLoop.STATE.Menu || GameLoop.GameState == GameLoop.STATE.End) {
			//dibujar caritas aztecas
		}
		//si el estado esta en menu...
		if (GameLoop.GameState == GameLoop.STATE.Menu) {
			//pinta titulo
			g.setColor(Color.orange);
			g.setFont(font);
			g.drawString("Math Maze", 310, 144);
			//pinta boton play
			g.setFont(font2);
			//g.drawRect(505, 210, 210, 80);
			g.drawString("Play", 505, 278);
			//pinta boton instrucciones
			//g.drawRect(350, 369, 520, 60);
			g.drawString("Instructions", 350, 425);
			//pinta boton exit
			//g.drawRect(515, 510, 180, 60);
			g.drawString("Exit", 515, 567);

		}
		//si el estado pasa de menu a instrucciones...
		if (GameLoop.GameState == GameLoop.STATE.Instrucciones) {
			//titulo
			g.setColor(Color.orange);
			g.setFont(font);
			g.drawString("Instrucciones", 250, 100);
			//boton para regresar al menu
			g.setFont(font2);
			//g.drawRect(495, 720, 220,65);
			g.drawString("Back", 495, 780);
			//rectangulos para escribir como jugar el juego
			//g.drawRect(100,200,450,450);
			//g.drawRect(650,200,450,450);
			g.setFont(font4);
			g.drawString("Para moverte utiliza las flechas",100,225);
			g.drawString("del teclado.",100,255);
			g.drawString("Consigue gemas     para adquirir", 100, 315);
			g.drawString("puntaje.", 100, 345);
			g.drawImage(Level.gem, 335, 295, null);
			g.drawString("Para obtener una gema, contesta",100,420);
			g.drawString("correctamente la prueba que se ",100,460);
			g.drawString("te otorgue.",100,500);
			g.drawString("Cada 5 gemas que consigas abre", 100, 580);
			g.drawString("el portal al siguiente nivel.", 100, 620);
			g.setColor(new Color(r.nextInt(255),0,r.nextInt(255)));
			g.fillOval(490, 610, 40, 40);
			g.setColor(Color.orange);
			g.drawString("Contestar mal una prueba resulta",650,225);
			g.drawString("en perdida de vida y puntaje.",650,255);
			g.drawString("Evita a los enemigos, estos quitan", 650, 315);
			g.drawString("vida y puntos al jugador.", 650, 345);
			g.drawImage(Level.enemySpriteSheet, 850, 365, null);
			g.drawImage(Level.enemySpriteSheet, 820, 365, null);
			g.drawImage(Level.enemySpriteSheet, 880, 365, null);
			g.drawString("Hay 9 niveles, conforme avances", 650, 420);
			g.drawString("estos seran mas dificiles.", 650, 460);
			g.drawString("Ahora sabes todo, mucha suerte", 650, 520);
			g.drawString(" y no mueras!", 650, 560);
		}
		if(GameLoop.GameState == GameLoop.STATE.End) {
			g.setColor(Color.orange);
			g.setFont(font3);
			g.drawString("You finished with a score of: "+hud.getScore(), 120, 170);
			g.setFont(font2);
			//g.drawRect(500, 460, 220, 60);
			g.drawString("Back", 500, 515);
		}
	}
	
}


