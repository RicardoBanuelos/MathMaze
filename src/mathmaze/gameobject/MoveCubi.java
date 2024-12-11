package mathmaze.gameobject;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mathmaze.gameparts.GameLoop;
import mathmaze.gameparts.Hud;
import mathmaze.gameparts.Level;
import mathmaze.gameparts.Question;

public class MoveCubi extends KeyAdapter{
	
	private Handler handler;
	private Level level;
	private Hud hud;
	private Question question;
	private EnemySpawner spawner;
	private boolean[] keyDown = new boolean[4];
	private int[][] currentMatrix = new int[20][20];
	
	public MoveCubi(Handler handler, Level level, Hud hud, Question question,EnemySpawner spawner) {
		this.handler = handler;
		this.level = level;
		this.hud = hud;
		this.question = question;
		this.spawner = spawner;
		keyDown[0] = true;
		keyDown[1] = true;
		keyDown[2] = true;
		keyDown[3] = true;
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(GameLoop.GameState == GameLoop.STATE.Game) {
			if(key == KeyEvent.VK_DELETE) {
				level.cheat();
			}
			if(key == KeyEvent.VK_ESCAPE) {
				GameLoop.GameState = GameLoop.STATE.Menu;
				spawner.resetSpawn();
				handler.clearEnemys();
				hud.resetGame();
				level.loadLevel();
				question.qlist.clear();
				question.setQuestions();
			}
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				//aqui corremos el for del arreglo del handler, cuando detecta a cubi valida esto
				if(tempObject.getID() == ID.Player) {
					//dependiendo que tecla toque, checa si la matriz no es uno, si es el caso, permite a cubi
					//moverse, valida wsad, para arriba, abajo,derecha, izquierda y las flechas up down etc
					//evento para w
				currentMatrix = level.getMatrix();
					if(key == KeyEvent.VK_UP) {
						if(keyDown[0]) {
							if(currentMatrix[tempObject.getMy()-1][tempObject.getMx()]!=1) {
								tempObject.setY(tempObject.getY()-40);
								tempObject.setMy(tempObject.getMy()-1);
								//System.out.println("Mx = "+tempObject.getMx()+"My = "+tempObject.getMy());
								keyDown[0] = false;
							}
						}
					}
					//evento para s
					if(key == KeyEvent.VK_DOWN) {
						if(keyDown[1]) {
							if(currentMatrix[tempObject.getMy()+1][tempObject.getMx()]!=1) {
								tempObject.setY(tempObject.getY()+40); 
								tempObject.setMy(tempObject.getMy()+1);
								//System.out.println("Mx = "+tempObject.getMx()+"My = "+tempObject.getMy());
								keyDown[1] = false;
							}
						}
					}
					//evento para d
					if(key == KeyEvent.VK_RIGHT) {
						if(keyDown[2]) {
							if(currentMatrix[tempObject.getMy()][tempObject.getMx()+1]!=1) {
								tempObject.setX(tempObject.getX()+40);
								tempObject.setMx(tempObject.getMx()+1);
								//System.out.println("Mx = "+tempObject.getMx()+"My = "+tempObject.getMy());
								keyDown[2] = false;
							}
						}
					}
					//evento para a
					if(key == KeyEvent.VK_LEFT) {
						if(keyDown[3]) {
							if(currentMatrix[tempObject.getMy()][tempObject.getMx()-1]!=1) {
								tempObject.setX(tempObject.getX()-40);
								tempObject.setMx(tempObject.getMx()-1);
								//System.out.println("Mx = "+tempObject.getMx()+"My = "+tempObject.getMy());
								keyDown[3] = false;
							}
						}
					}
				}
			}
		}
		
		else if(GameLoop.GameState == GameLoop.STATE.Menu) {
			if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		}
		
		else if(GameLoop.GameState == GameLoop.STATE.Instrucciones) {
			if(key == KeyEvent.VK_ESCAPE) GameLoop.GameState = GameLoop.STATE.Menu;
		}

	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player) {
				//key events for player 1
				if(key == KeyEvent.VK_UP) keyDown[0] = true;
				if(key == KeyEvent.VK_DOWN) keyDown[1] = true;
				if(key == KeyEvent.VK_RIGHT) keyDown[2] = true;
				if(key == KeyEvent.VK_LEFT) keyDown[3] = true;
				
			}
		}
	}
}
