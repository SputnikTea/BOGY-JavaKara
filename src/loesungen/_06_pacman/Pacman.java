package loesungen._06_pacman;

import javakara.JavaKaraProgram;

public class Pacman extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Pacman();
		program.run("classes/aufgaben/_06_pacman/world1.world");
		// oder:
		// program.run("classes/aufgaben/_06_pacman/world2.world");
	}

	@Override
	public void myMainProgram() {
		kara.removeLeaf();
		// Vorbedingung: Kara ist auf Kleeblatt dieses Feld, von dem Kara
		// Kleeblatt nimmt, nennen wir Feld X

		while (!kara.treeFront()) {
			// solange nicht vor Baum, nächstes Kleeblatt

			kara.move(); // das Feld gerade vor X prüfen
			if (!kara.onLeaf()) { // kein Kleeblatt vor X?
				turnAround(); // also das Feld links von X prüfen
				kara.move();
				kara.turnRight();
				kara.move();
				if (!kara.onLeaf()) { // links von X kein Kleeblatt?
					turnAround(); // dann muss es ja wohl rechts sein!
					kara.move();
					kara.move();
					if (!kara.onLeaf()) { // immer noch kein Kleeblatt?
						tools.showMessage("Kleeblatt-Spur endet nicht an einem Baum, \n"
								+ "sondern einfach irgendwo in der Welt!");
						break; // da Kara jetzt nicht auf Kleeblatt: Stop!
					}
				}
			}
			kara.removeLeaf(); // Vorbedingung: Kara ist auf Kleeblatt
		}
	}

	void turnAround() {
		kara.turnLeft();
		kara.turnLeft();
	}

}
