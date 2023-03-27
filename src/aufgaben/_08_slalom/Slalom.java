package aufgaben._08_slalom;

import javakara.JavaKaraProgram;

public class Slalom extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Slalom();
		program.run("src/aufgaben/_08_slalom/world1.world");
		// oder:
		// program.run("src/aufgaben/_08_slalom/world2.world");
		// oder:
		// program.run("src/aufgaben/_08_slalom/world3.world");
	}

	@Override
	public void myMainProgram() {
		// hier kommt das Hauptprogramm Ihrer L�sung hin
	}

}
