package loesungen._03_blaettersuche_1;

import javakara.JavaKaraProgram;

public class KleeblattSuche1 extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new KleeblattSuche1();
		program.run("classes/aufgaben/_03_blaettersuche_1/world1.world");
		// oder:
		// program.run("classes/aufgaben/_03_blaettersuche_1/world2.world");
		// oder:
		// program.run("classes/aufgaben/_03_blaettersuche_1/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (!kara.onLeaf()) {
			if (kara.treeFront()) {
				kara.turnLeft();
				kara.move();
				kara.turnRight();
				kara.move();
				kara.move();
				kara.turnRight();
				kara.move();
				kara.turnLeft();
			}
			else {
				kara.move();
			}
		}
		kara.removeLeaf();
	}

}
