package loesungen._11_dreiecke;

import javakara.JavaKaraProgram;

public class Dreiecke extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Dreiecke();
		program.run("classes/aufgaben/_11_dreiecke/world1.world");
	}

	@Override
	public void myMainProgram() {
		final int HEIGHT = 5;

		int currentWidth = 1;
		boolean left2right = true;

		for (int y = 0; y < HEIGHT - 1; y++) {
			paintRow(currentWidth);
			gotoNextRow(left2right);
			left2right = !left2right;
			currentWidth = currentWidth + 2;
		}
		paintRow(currentWidth);
	}

	void gotoNextRow(boolean left2right) {
		if (left2right) {
			kara.turnRight();
			kara.move();
			kara.turnRight();
		}
		else {
			kara.turnLeft();
			kara.move();
			kara.turnLeft();
		}
	}

	void paintRow(int length) {
		for (int i = 0; i < length; i++) {
			kara.putLeaf();
			kara.move();
		}
	}
}
