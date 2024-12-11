package mathmaze.gameparts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import mathmaze.external.BufferedImageLoader;
import mathmaze.external.SpriteSheet;
import mathmaze.gameobject.Handler;

public class Level {
	
	private Hud hud;
	private Random r = new Random();
	public BufferedImage spriteSheet = null;
	public BufferedImage altSpriteSheet = null;
	public BufferedImage gemsSpriteSheet = null;
	public static BufferedImage enemySpriteSheet = null;
	public static BufferedImage wall = null;
	public static BufferedImage wall2 = null;
	public static BufferedImage wall3 = null;
	public static BufferedImage wall4 = null;
	public static BufferedImage wall5 = null;
	public static BufferedImage wall6 = null;
	public static BufferedImage gem = null;
	
	public static int[][] levelOne = new int[20][20];
	public static int[][] levelTwo = new int[20][20];
	public static int[][] levelThree = new int[20][20];
	public static int[][] levelFour = new int[20][20];
	public static int[][] levelFive = new int[20][20];
	public static int[][] levelSix = new int[20][20];
	public static int[][] levelSeven = new int[20][20];
	public static int[][] levelEight = new int[20][20];
	public static int[][] levelNine = new int[20][20];
	
	public Level(Handler handler, Hud hud) {
		this.hud = hud;
		loadLevel();
		initImageLoad();
	}
		  
	public void tick() {
		if(hud.getGems() == 5) {
			levelOne[15][16] = 5;
		}
		if(hud.getGems() == 10) {
			levelTwo[1][1] = 5;
		}
		if(hud.getGems() == 15) {
			levelThree[7][12] = 5;
		}
		if(hud.getGems() == 20) {
			levelFour[9][1] = 5;
		}
		if(hud.getGems() == 25) {
			levelFive[9][9] = 5;
		}
		if(hud.getGems() == 30) {
			levelSix[7][9] = 5;
 		}
		if(hud.getGems() == 35) {
			levelSeven[18][14] = 5;
 		}
		if(hud.getGems() == 40) {
			levelEight[1][18] = 5;
		}
		if(hud.getGems() == 45) {
			levelNine[8][18] = 5;
		}
	}
	
	public void cheat() {
		levelOne[4][2] = 5;
		levelTwo[18][2] = 5;
		levelThree[1][2] = 5;
		levelFour[9][2] = 5;
		levelFive[9][2] = 5;
		levelSix[17][10] = 5;
		levelSeven[7][8] = 5;
		levelEight[2][18] = 5;
		levelNine[8][2] = 5;
	}
	
	//si el estado es game, pinta el nivel
	public void render(Graphics g) {
		if(hud.getLevel() == 1) {
			paintLevel(g,levelOne,wall);
		}
		if(hud.getLevel() == 2) {
			paintLevel(g,levelTwo,wall4);
		}
		if(hud.getLevel() == 3) {
			paintLevel(g,levelThree,wall2);
		}
		if(hud.getLevel() == 4) {
			paintLevel(g,levelFour,wall5);
		}
		if(hud.getLevel() == 5) {
			paintLevel(g,levelFive,wall3);
		}
		if(hud.getLevel() == 6) {
			paintLevel(g,levelSix,wall6);
		}
		if(hud.getLevel() == 7) {
			paintLevel(g,levelSeven,wall);
		}
		if(hud.getLevel() == 8) {
			paintLevel(g,levelEight,wall4);
		}
		if(hud.getLevel() == 9) {
			paintLevel(g,levelNine,wall2);
		}
	}
	
	public void loadLevel() {
		try {
			File level = new File("level1.lvl");
			@SuppressWarnings("resource")
			Scanner get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelOne[i][j] = get.nextInt();
				}
			}
			level = new File("level2.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelTwo[i][j] = get.nextInt();
				}
			}
			level = new File("level3.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelThree[i][j] = get.nextInt();
				}
			}
			level = new File("level4.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelFour[i][j] = get.nextInt();
				}
			}
			level = new File("level5.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelFive[i][j] = get.nextInt();
				}
			}
			level = new File("level6.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelSix[i][j] = get.nextInt();
				}
			}
			level = new File("level7.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelSeven[i][j] = get.nextInt();
				}
			}
			level = new File("level8.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelEight[i][j] = get.nextInt();
				}
			}
			level = new File("level9.lvl");
			get = new Scanner(level);
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 20; j++) {
					levelNine[i][j] = get.nextInt();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[][] getMatrix(){
		if(hud.getLevel() == 1) {
			return levelOne;
		}
		if(hud.getLevel() == 2) {
			return levelTwo;
		}
		if(hud.getLevel() == 3) {
			return levelThree;
		}
		if(hud.getLevel() == 4) {
			return levelFour;
		}
		if(hud.getLevel() == 5) {
			return levelFive;
		}
		if(hud.getLevel() == 6) {
			return levelSix;
		}
		if(hud.getLevel() == 7) {
			return levelSeven;
		}
		if(hud.getLevel() == 8) {
			return levelEight;
		}
		if(hud.getLevel() == 9) {
			return levelNine;
		}
		return null;
	}
	
	public void initImageLoad() {
		//Carga sprite sheet
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("res/inca_sheet.png");
			altSpriteSheet = loader.loadImage("res/inca_sheet2.png");
			gemsSpriteSheet = loader.loadImage("res/gems_sheet.png");
			enemySpriteSheet = loader.loadImage("res/enemy.png");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		SpriteSheet ssAlt = new SpriteSheet(altSpriteSheet);
		SpriteSheet ssGems = new SpriteSheet(gemsSpriteSheet);
		wall = ss.grabImage(1,1,40,40);
		wall2 = ss.grabImage(2, 1, 40, 40);
		wall3 = ss.grabImage(3, 1, 40, 40);
		wall4 = ssAlt.grabImage(1, 1, 40, 40);
		wall5 = ssAlt.grabImage(2, 1, 40, 40);
		wall6 = ssAlt.grabImage(3, 1, 40, 40);
		gem = ssGems.grabImage(2, 2, 32, 32, true);
	}
	
	//metodo para pintar cualquier nivel con el color deseado en RGB para mejor 
	//customizacion del color deseado
	private void paintLevel(Graphics g, int[][] level, BufferedImage texture) {
		int x = 800/level.length;
		int y = 800/level.length;
		//initImageLoad();
		for(int i = 0; i < level.length; i++) {
			for(int j = 0; j < level.length; j++) {
				
				if(level[j][i] == 1) {
					g.drawImage(texture,x*i+30,y*j+30,null);
				
				}
				if(level[j][i] == 2) {
					g.drawImage(gem,x*i+34,y*j+34,null);
				}
				if(level[j][i] == 5) {
					g.setColor(new Color(r.nextInt(255),0,r.nextInt(255)));
					g.fillOval(x*i+30, y*j+30, x, y);
					g.setColor(Color.black);
					g.drawOval(x*i+30, y*j+30, x, y);
				}
			}
		}
	}
}
