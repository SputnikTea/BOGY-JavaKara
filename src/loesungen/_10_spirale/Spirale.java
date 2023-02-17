package loesungen._10_spirale;

import javakara.JavaKaraProgram;

public class Spirale extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Spirale();
		program.run("classes/aufgaben/_10_spirale/world1.world");
	}

	@Override
	public void myMainProgram() {
		final int MAX_LENGTH = 20;
		int d = 1;

		while (d < MAX_LENGTH) {
			walk(d);
			kara.turnRight();
			d++;
		}
	}

	void walk(int distance) {
		for (int i = 0; i < distance; i++) {
			kara.putLeaf();
			kara.move();
		}
	}

}
