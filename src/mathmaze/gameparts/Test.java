package mathmaze.gameparts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import mathmaze.external.AudioPlayer;
import mathmaze.gameobject.GameObject;
import mathmaze.gameobject.Handler;
import mathmaze.gameobject.ID;

public class Test extends KeyAdapter{
	private Handler handler;
	private Hud hud;
	private Question question;
	private char key;
	private int select;
	private Random r = new Random();
	private boolean randomizer = true;
	
	public Test(Handler handler, Hud hud, Question question) {
		this.handler = handler;
		this.hud = hud;
		this.question = question;
	}
	
	public void keyPressed(KeyEvent e) {
		if(GameLoop.GameState == GameLoop.STATE.Test) {
			key = e.getKeyChar();
			if(key == 'a' || key == 'b' || key == 'c') {
				if(question.qlist.get(select).check(key)) {
					AudioPlayer.playSound("res/gem.wav");
					GameLoop.GameState = GameLoop.STATE.Game;
					for(int i = 0; i < handler.object.size(); i++) {
						GameObject tempObject = handler.object.get(i);
						if(tempObject.getID() == ID.Player) {
							if(hud.getLevel() == 1)
								Level.levelOne[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 2)
								Level.levelTwo[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 3)
								Level.levelThree[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 4)
								Level.levelFour[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 5)
								Level.levelFive[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 6)
								Level.levelSix[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 7)
								Level.levelSeven[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 8)
								Level.levelEight[tempObject.getMy()][tempObject.getMx()] = 0;
							else if(hud.getLevel() == 9)
								Level.levelNine[tempObject.getMy()][tempObject.getMx()] = 0;
						}
					}
					question.qlist.remove(select);
					hud.setScore(hud.getScore()+100);
					hud.setGems(hud.getGems()+1);
					randomizer = true;
				}
				else {
					AudioPlayer.playSound("res/hurt.wav");
					hud.setScore(hud.getScore()-33);
					hud.setHealth(hud.getHealth()-5);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void tick() {
		if(randomizer) {
			select = r.nextInt(question.qlist.size()) - 1;
			while(select >= question.qlist.size()) {
				select = r.nextInt(question.qlist.size()) - 1;
			}
			if(select<0) {
				select = 0;
			}
			//System.out.println("Size = "+question.qlist.size());
			//System.out.println("Index = "+select);
			randomizer = false;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(200, 230, 430, 400);
		g.setColor(Color.black);
		g.drawRect(200, 230, 430, 400);
		g.setFont(new Font("arial",2,50));
		g.drawString("Contesta!", 310, 290);
		g.setFont(new Font("arial",2,35));
		g.drawString(question.qlist.get(select).question, 230, 370);
		g.drawString(question.qlist.get(select).option1, 270, 420);
		g.drawString(question.qlist.get(select).option2, 270, 470);
		g.drawString(question.qlist.get(select).option3, 270, 520);
		g.setFont(new Font("arial",0,30));
		g.drawString("Utiliza el teclado!", 305, 590);
	}
}
