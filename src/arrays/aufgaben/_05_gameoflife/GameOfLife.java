package arrays.aufgaben._05_gameoflife;

import javakara.JavaKaraProgram;

public class GameOfLife extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new GameOfLife();
		program.run("src/aufgaben/_13_gameoflife/world1.world");
		// oder:
		// program.run("src/aufgaben/_13_gameoflife/world2.world");
		// oder:
		// program.run("src/aufgaben/_13_gameoflife/world3.world");
	}

	@Override
	public void myMainProgram() {
		// hier kommt das Hauptprogramm Ihrer L�sung hin
	}

}
