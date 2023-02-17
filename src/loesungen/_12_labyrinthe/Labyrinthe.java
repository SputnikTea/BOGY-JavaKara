package loesungen._12_labyrinthe;

import javakara.JavaKaraProgram;

public class Labyrinthe extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Labyrinthe();
		program.run("classes/aufgaben/_12_labyrinthe/world1.world");
		// oder:
		// program.run("classes/aufgaben/_12_labyrinthe/world2.world");
		// oder:
		// program.run("classes/aufgaben/_12_labyrinthe/world3.world");
	}

	@Override
	public void myMainProgram() {
		boolean ignoriereLochLinks = false;
		boolean ignoriereLochRechts = true;

		while (!kara.onLeaf()) {
			while ((ignoriereLochLinks || kara.treeLeft())
					&& (ignoriereLochRechts || kara.treeRight())) {
				if (!kara.treeFront()) {
					kara.move();
				}
				else {
					ignoriereLochLinks = !ignoriereLochLinks;
					ignoriereLochRechts = !ignoriereLochRechts;
					kara.turnLeft();
					kara.turnLeft();
				}
			}
			if (!ignoriereLochLinks && !kara.treeLeft()) {
				ignoriereLochLinks = true;
				ignoriereLochRechts = false;
				kara.turnLeft();
				kara.move();
				kara.move();
				kara.turnLeft();
			}
			else {
				ignoriereLochLinks = false;
				ignoriereLochRechts = true;
				kara.turnRight();
				kara.move();
				kara.move();
				kara.turnRight();
			}
		}
		kara.removeLeaf();
	}

}
