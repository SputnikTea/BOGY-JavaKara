package loesungen._05_blaettersuche_3;

import javakara.JavaKaraProgram;

public class KleeblattSuche3 extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new KleeblattSuche3();
		program.run("classes/aufgaben/_05_blaettersuche_3/world1.world");
		// oder:
		// program.run("classes/aufgaben/_05_blaettersuche_3/world2.world");
		// oder:
		// program.run("classes/aufgaben/_05_blaettersuche_3/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (!kara.onLeaf()) {
			if (!kara.treeLeft()) {
				kara.turnLeft();
				kara.move();
			}
			else if (!kara.treeFront()) {
				kara.move();
			}
			else if (!kara.treeRight()) {
				kara.turnRight();
				kara.move();
			}
		}
		kara.removeLeaf();
	}

}
