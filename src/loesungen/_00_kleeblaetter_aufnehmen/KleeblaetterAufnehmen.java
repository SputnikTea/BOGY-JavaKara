package src.loesungen._00_kleeblaetter_aufnehmen;

import javakara.JavaKaraProgram;

public class KleeblaetterAufnehmen extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new KleeblaetterAufnehmen();
		program.run("src/aufgaben/_00_kleeblaetter_aufnehmen/world1.world");
		// oder:
		// program.run("classes/aufgaben/_00_kleeblaetter_aufnehmen/world2.world");
		// oder:
		// program.run("classes/aufgaben/_00_kleeblaetter_aufnehmen/world3.world");
	}

	static public JavaKaraProgram testProgramm() {
		return new KleeblaetterAufnehmen();
	}

	@Override
	public void myMainProgram() {
		invertLeaf();
		while (!kara.treeFront()) {
			kara.move();
			invertLeaf();
		}
	}

	void invertLeaf() {
		if (kara.onLeaf()) {
			kara.removeLeaf();
		}
		else {
			kara.putLeaf();
		}
	}
}
