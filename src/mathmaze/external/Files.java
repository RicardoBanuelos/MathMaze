package mathmaze.external;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Files {
	private String name = null;
	private int score = 0;

	public void writeFile(String nombre, int score) {
		try {
			FileWriter fw = new FileWriter("res/ranks.txt");
			fw.write(nombre);
			fw.write("\n");
			fw.write(Integer.toString(score));
			fw.close();
			System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void readFile() {
		File read = new File("res/ranks.txt");
		try {
			@SuppressWarnings("resource")
			Scanner get = new Scanner(read);
			this.name = get.nextLine();
			this.score = Integer.parseInt(get.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
}
