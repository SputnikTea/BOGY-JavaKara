package loesungen._04_blaettersuche_2;

import javakara.JavaKaraProgram;

public class KleeblattSuche2 extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new KleeblattSuche2();
		program.run("classes/aufgaben/_04_blaettersuche_2/world1.world");
		// oder:
		// program.run("classes/aufgaben/_04_blaettersuche_2/world2.world");
		// oder:
		// program.run("classes/aufgaben/_04_blaettersuche_2/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (!kara.onLeaf()) {
			if (kara.treeFront()) {
				kara.turnLeft();
				kara.move();
				kara.turnRight();
				kara.move();

				followTrees();

				kara.turnLeft();
				kara.move();
				kara.turnRight();
			}
			else {
				kara.move();
			}
		}
		kara.removeLeaf();
	}

	void followTrees() {
		while (kara.treeRight()) {
			kara.move();
		}
	}
}
