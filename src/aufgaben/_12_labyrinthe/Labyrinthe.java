package aufgaben._12_labyrinthe;

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
		// hier kommt das Hauptprogramm Ihrer Lösung hin
	}

}
