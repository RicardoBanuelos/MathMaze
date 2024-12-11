package mathmaze.external;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage image = sheet.getSubimage( (col*40)-40, (row*40)-40, width, height);
		return image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height, boolean item) {
		BufferedImage image = sheet.getSubimage( (col*32)-32, (row*32)-32, width, height);
		return image;
	}
}
