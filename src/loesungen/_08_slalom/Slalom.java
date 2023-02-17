package loesungen._08_slalom;

import javakara.JavaKaraProgram;

public class Slalom extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Slalom();
		program.run("classes/aufgaben/_08_slalom/world1.world");
		// oder:
		// program.run("classes/aufgaben/_08_slalom/world2.world");
		// oder:
		// program.run("classes/aufgaben/_08_slalom/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (true) {
			while (kara.treeLeft() && !kara.treeRight()) {
				viertelDrehungLinks();
			}
			viertelDrehungRechts();
			while (!kara.treeLeft() && kara.treeRight()) {
				viertelDrehungRechts();
			}
			viertelDrehungLinks();
		}
	}

	void viertelDrehungLinks() {
		kara.move();
		kara.turnLeft();
		kara.move();
	}

	void viertelDrehungRechts() {
		kara.move();
		kara.turnRight();
		kara.move();
	}

}
