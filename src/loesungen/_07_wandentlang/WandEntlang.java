package loesungen._07_wandentlang;

import javakara.JavaKaraProgram;

public class WandEntlang extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new WandEntlang();
		program.run("classes/aufgaben/_07_wandentlang/world1.world");
		// oder:
		// program.run("classes/aufgaben/_07_wandentlang/world2.world");
		// oder:
		// program.run("classes/aufgaben/_07_wandentlang/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (true) {
			if (kara.treeFront() && kara.treeRight()) {
				kara.turnLeft();
			}
			else if (!kara.treeFront()) {
				if (kara.treeRight()) {
					kara.move();
				}
				else {
					kara.turnRight();
					kara.move();
				}
			}
		}
	}

}
