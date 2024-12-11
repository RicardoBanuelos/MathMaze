package mathmaze.gameparts;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 9034494958129720942L;

	public Window(int width, int height, String title, GameLoop game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//agrega game porque este se extiende de canvas, lo cual lo convierte en un componente que se pinta 
		//una y otra vez en nuestro JFrame
		frame.add(game);
		frame.setVisible(true);
		//llama el metodo start de nuestro juego lo cual corre el thread
		game.start();
	}

}
