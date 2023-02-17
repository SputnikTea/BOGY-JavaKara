package loesungen._09_bilder_invertieren;

import javakara.JavaKaraProgram;

public class BilderInvertieren extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new BilderInvertieren();
		program.run("classes/aufgaben/_09_bilder_invertieren/world1.world");
		// oder:
		// program.run("classes/aufgaben/_09_bilder_invertieren/world2.world");
		// oder:
		// program.run("classes/aufgaben/_09_bilder_invertieren/world3.world");
	}

	@Override
	public void myMainProgram() {
		boolean walkingLeft2Right = true;

		while (!(kara.treeFront() && (kara.treeLeft() || kara.treeRight()))) {
			if (walkingLeft2Right) {
				left2right();
			}
			else {
				right2left();
			}
			walkingLeft2Right = !walkingLeft2Right;
		}
	}

	void invert() {
		if (kara.onLeaf()) {
			kara.removeLeaf();
		}
		else {
			kara.putLeaf();
		}
	}

	void left2right() {
		walk();
		if (!kara.treeRight()) {
			kara.turnRight();
			kara.move();
			kara.turnRight();
		}
	}

	void right2left() {
		walk();
		if (!kara.treeLeft()) {
			kara.turnLeft();
			kara.move();
			kara.turnLeft();
		}
	}

	void walk() {
		invert();
		while (!kara.treeFront()) {
			kara.move();
			invert();
		}
	}

}
