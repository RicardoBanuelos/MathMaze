package mathmaze.gameparts;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import mathmaze.external.AudioPlayer;
import mathmaze.gameobject.EnemySpawner;
import mathmaze.gameobject.Handler;
import mathmaze.gameobject.MoveCubi;

public class GameLoop extends Canvas implements Runnable{

	private static final long serialVersionUID = 2214600181745071429L;
	
    static final int WIDTH = 1200, HEIGHT = WIDTH/12 *9;
	private Thread thread;
	private boolean running = false;
	
	private Hud hud;
	private Handler handler;
	private Menu menu;
	private Level level;
	private Test test;
	private Question question;
	private EnemySpawner spawner;
	
	//estados del juego, dependiendo cual este activo, el juego hara diferentes cosas
	public enum STATE {
		Menu,
		Instrucciones,
		Game,
		Test,
		End;
	};
	
	public static STATE GameState = STATE.Menu;
	public static boolean win = false;
	
	public GameLoop() {
	
		hud = new Hud();
		handler = new Handler(hud);
		menu = new Menu(handler,hud);
		level = new Level(handler,hud);
		question = new Question();
		test = new Test(handler,hud,question);
		spawner = new EnemySpawner(handler,hud);
		
		
		//agregamos teclado y mouse al juego
		this.addMouseListener(menu);
		this.addKeyListener(new MoveCubi(handler,level,hud,question,spawner));
		this.addKeyListener(test);
		
		AudioPlayer.playBackground("res/bg.wav");
		
		new Window(WIDTH,HEIGHT,"GameTest!",this);
	}
	
	//metodo que empieza el hilo
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	//metodo que termina el hilo
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//ciclo del juego, este llama el tick y render y corre el juego bonito
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double ammountOfTicks = 60.0;
		double ns = 1000000000 / ammountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//actualiza variables dependiendo en que estado se encuentre el juego
	private void tick() {
		if(GameState == STATE.Menu || GameState == STATE.Instrucciones || GameState == STATE.End) {
			menu.tick();
			handler.tick();
			spawner.tick();
		}
		if(GameState == STATE.Game) {
			level.tick();
			hud.tick();
			spawner.tick();
			handler.tick();
			if(hud.getHealth()<=0 || win) {
				if(win) {
					AudioPlayer.playSound("res/win.wav");
				}
				if(hud.getScore() > hud.getFileScore()) {
					String name;
					name = JOptionPane.showInputDialog("Tienes el nuevo record!\n Ingresa tu nombre:");
					if(name!=null) {
						hud.writeScore(name);
					}
				}
				GameState = STATE.End;
				spawner.resetSpawn();
				handler.clearEnemys();
				level.loadLevel();
				question.qlist.clear();
				question.setQuestions();
				win = false;
			}
		}
		if(GameState == STATE.Test) {
			level.tick();
			hud.tick();
			test.tick();
			handler.tick();
			if(hud.getHealth()<=0) {
				if(hud.getScore() > hud.getFileScore()) {
					String name;
					name = JOptionPane.showInputDialog("Tienes el nuevo record!\n Ingresa tu nombre:");
					if(name!=null) {
						hud.writeScore(name);
					}
				}
				GameState = STATE.End;
				spawner.resetSpawn();
				handler.clearEnemys();
				level.loadLevel();
				question.qlist.clear();
				question.setQuestions();
			}
		}
	}
	
	//pinta el juego dependiendo en que estado este el juego
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(GameState == STATE.Menu || GameState == STATE.Instrucciones || GameState == STATE.End) {
			handler.render(g);
			menu.render(g);
		}
		
		if(GameState == STATE.Game) {
			level.render(g);
			hud.render(g);
			handler.render(g);
		}
		if(GameState == STATE.Test) {
			level.render(g);
			hud.render(g);
			handler.render(g);
			test.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return (var = max);
		else if(var <= min)
			return (var = min);
		else
			return var;
	}
	
	public static void main(String[] args) {
		new GameLoop();
		
	}

}