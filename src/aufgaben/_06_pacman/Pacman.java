package aufgaben._06_pacman;

import javakara.JavaKaraProgram;

public class Pacman extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Pacman();
		program.run("src/aufgaben/_06_pacman/world1.world");
		// oder:
		// program.run("src/aufgaben/_06_pacman/world2.world");
	}

	@Override
	public void myMainProgram() {
		// hier kommt das Hauptprogramm Ihrer L�sung hin
	}

}
