package mathmaze.gameobject;

import mathmaze.gameparts.GameLoop;
import mathmaze.gameparts.Hud;

public class EnemySpawner {

	private Handler handler;
	private Hud hud;
	private boolean spawn1 = true;
	private boolean spawn2 = true;
	private boolean spawn3 = true;
	private boolean spawn4 = true;
	private boolean spawn5 = true;
	private boolean spawn6 = true;
	private boolean spawn7 = true;
	private boolean spawn8 = true;
	private boolean spawn9 = true;
	
	public EnemySpawner(Handler handler, Hud hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void resetSpawn() {
		spawn1 = true;
		spawn2 = true;
		spawn3 = true;
		spawn4 = true;
		spawn5 = true;
		spawn6 = true;
		spawn7 = true;
		spawn8 = true;
		spawn9 = true;
	}
	
	public void tick() {
		if(GameLoop.GameState == GameLoop.STATE.Game) {
			if(hud.getLevel() == 1 && spawn1) {
				handler.addObject(new VerticalEnemy(160,200,0,0,80,400,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(520,400,0,0,520,680,4,ID.Enemy));
				spawn1 = false;
			}
			if(hud.getLevel() == 2 && spawn2) {
				handler.addObject(new VerticalEnemy(80,200,0,0,80,280,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(160,200,0,0,80,280,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(240,200,0,0,80,280,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(320,200,0,0,80,280,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(680,400,0,0,440,760,4,ID.Enemy));
				spawn2 = false;
			}
			if(hud.getLevel() == 3 && spawn3) {
				handler.addObject(new HorizontalEnemy(80,680,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,600,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,520,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,440,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,360,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,280,0,0,80,160,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(320,600,0,0,240,400,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(320,520,0,0,240,400,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(320,440,0,0,240,400,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(520,320,0,0,280,360,4,ID.Enemy));
				spawn3 = false;
			}
			if(hud.getLevel() == 4 && spawn4 ) {
				//first three enemies
				handler.addObject(new VerticalEnemy(120,360,0,0,360,440,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(200,360,0,0,360,440,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(280,360,0,0,360,440,2,ID.Enemy));
				//last second enemies
				handler.addObject(new VerticalEnemy(680,360,0,0,360,440,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(720,360,0,0,360,440,2,ID.Enemy));
				//first horizontal enemies
				handler.addObject(new HorizontalEnemy(360,280,0,0,360,440,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,200,0,0,360,440,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,520,0,0,360,440,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,600,0,0,360,440,3,ID.Enemy));
				//second horizontal enemies
				handler.addObject(new HorizontalEnemy(560,120,0,0,560,640,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,280,0,0,560,640,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,200,0,0,560,640,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,520,0,0,560,640,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,600,0,0,560,640,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,680,0,0,560,640,3,ID.Enemy));
				spawn4 = false;
			}
			if(hud.getLevel() == 5 && spawn5) {
				handler.addObject(new HorizontalEnemy(440,400,0,0,80,760,15,ID.Enemy));
				spawn5 = false;
			}
			if(hud.getLevel() == 6 && spawn6) {
				handler.addObject(new HorizontalEnemy(80,640,0,0,80,760,12,ID.Enemy));
				handler.addObject(new HorizontalEnemy(160,520,0,0,160,680,12,ID.Enemy));
				handler.addObject(new VerticalEnemy(240,320,0,0,320,400,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,320,0,0,360,440,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(480,80,0,0,80,200,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(480,80,0,0,480,600,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(680,120,0,0,120,240,2,ID.Enemy));
				spawn6 = false;
			}
			if(hud.getLevel() == 7 && spawn7) {
				handler.addObject(new VerticalEnemy(400,120,0,0,120,320,3,ID.Enemy));
				handler.addObject(new VerticalEnemy(240,280,0,0,280,640,4,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,600,0,0,80,160,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,520,0,0,80,160,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,440,0,0,80,160,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(80,360,0,0,80,160,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(480,80,0,0,80,320,3,ID.Enemy));
				handler.addObject(new VerticalEnemy(600,160,0,0,160,320,3,ID.Enemy));
				handler.addObject(new VerticalEnemy(760,240,0,0,240,560,3,ID.Enemy));
				handler.addObject(new VerticalEnemy(320,480,0,0,480,680,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(280,760,0,0,280,480,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(480,560,0,0,480,680,3,ID.Enemy));
				spawn7 = false;
			}
			if(hud.getLevel() == 8 && spawn8) {
				handler.addObject(new HorizontalEnemy(360,80,0,0,360,760,8,ID.Enemy));
				handler.addObject(new HorizontalEnemy(160,280,0,0,160,760,8,ID.Enemy));
				handler.addObject(new HorizontalEnemy(160,480,0,0,160,760,8,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,680,0,0,360,560,8,ID.Enemy));
				handler.addObject(new VerticalEnemy(160,280,0,0,280,480,5,ID.Enemy));
				handler.addObject(new VerticalEnemy(360,80,0,0,80,680,8,ID.Enemy));
				handler.addObject(new VerticalEnemy(560,80,0,0,80,680,8,ID.Enemy));
				handler.addObject(new VerticalEnemy(760,479,0,0,80,480,5,ID.Enemy));
				spawn8 = false;
			}
			if(hud.getLevel() == 9 && spawn9) {
				handler.addObject(new VerticalEnemy(120,600,0,0,560,640,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(200,600,0,0,560,640,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(320,600,0,0,520,680,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(520,600,0,0,520,680,4,ID.Enemy));
				handler.addObject(new VerticalEnemy(640,600,0,0,560,640,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(720,600,0,0,560,640,2,ID.Enemy));
				handler.addObject(new VerticalEnemy(320,160,0,0,160,280,3,ID.Enemy));
				handler.addObject(new VerticalEnemy(520,160,0,0,160,280,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(200,720,0,0,200,280,2,ID.Enemy));
				handler.addObject(new HorizontalEnemy(360,120,0,0,360,480,3,ID.Enemy));
				handler.addObject(new HorizontalEnemy(560,720,0,0,560,640,2,ID.Enemy));
				spawn9 = false;
			}
		}
	}
}
