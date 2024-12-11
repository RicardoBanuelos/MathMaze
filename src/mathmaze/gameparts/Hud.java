package mathmaze.gameparts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import mathmaze.external.Files;

public class Hud {
	
	private int health = 100;
	private int score = 0;
	private int gems = 0;
	private int level = 1;
	private int filescore;
	
	private Files file = new Files();
	
	//actualiza las variables del hud
	public void tick() {
		health = GameLoop.clamp(health, 0, 100);
		if(score<0) {
			score = 0;
		}
		filescore = file.getScore();
	}
	
	//pinta nuestro hud
	public void render(Graphics g) {
		file.readFile();
		Font font1 = new Font("Arial",0,20);
		Font font2 = new Font("Arial",0,25);
		//rectangulo gris
		g.setColor(Color.DARK_GRAY);
		g.fillRect(875,30,280,800);
		//vida de cubi
		g.setColor(Color.white);
		g.drawRect(875,30,280,800);
		g.setColor(Color.red);
		g.fillRect(895, 70, 240, 75);
		g.setColor(new Color(75,255,0));
		g.fillRect(895, 70, (int)(health*2.4), 75);
		g.setColor(Color.white);
		g.drawRect(895, 70, 240, 75);
		//letras de health y puntaje
		g.setFont(font1);
		g.drawString("HEALTH", 895, 60);
		g.setFont(font2);
		g.drawString("Level: "+level, 895, 195);
		g.drawString("Score: "+score, 895, 225);
		g.drawString("Gems: "+gems, 895, 260);
		g.drawString("Press ESC to exit", 895, 820);
		g.drawString("Top Scorer:", 895, 325);
		g.drawString(file.getName(), 895, 370);
		g.drawString("with a score of "+file.getScore(), 895, 400);
		g.drawString("Every 5 gems you", 895, 450);
		g.drawString("collect unlocks the", 895, 480);
		g.drawString("next level!", 895, 510);
	}
	
	public void resetGame() {
		setHealth(100);
		setLevel(1);
		setScore(0);
		setGems(0);
	}
	
	public void writeScore(String name) {
		file.writeFile(name,getScore());
	}
	
	public int getFileScore() {
		return filescore;
	}
	
	//setters y getters para las variables
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
	public void setGems(int gems) {
		this.gems = gems;
	}
	public int getGems() {
		return gems;
	}
}
