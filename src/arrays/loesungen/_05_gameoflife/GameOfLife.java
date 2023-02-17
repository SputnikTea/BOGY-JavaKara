package arrays.loesungen._05_gameoflife;

import javakara.JavaKaraProgram;

public class GameOfLife extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new GameOfLife();
		program.run("classes/aufgaben/_13_gameoflife/world1.world");
		// oder:
		// program.run("classes/aufgaben/_13_gameoflife/world2.world");
		// oder:
		// program.run("classes/aufgaben/_13_gameoflife/world3.world");
	}

	@Override
	public void myMainProgram() {
		final int SIZE_X = world.getSizeX();
		final int SIZE_Y = world.getSizeY();
		boolean[][] cells = new boolean[SIZE_Y][SIZE_X];
		boolean[][] newCells = new boolean[SIZE_Y][SIZE_X];

		// mit dem folgenden Code kann die Welt zufällig
		// initialisiert werden

		/*
		 * for (y = 1; y < SIZE_Y-1; y++) { for (x = 1; x < SIZE_X-1; x++) { int
		 * r = tools.random(1); world.setLeaf (x, y, r == 1); } }
		 * tools.checkState();
		 */

		for (int y = 1; y < SIZE_Y - 1; y++) {
			for (int x = 1; x < SIZE_X - 1; x++) {
				cells[y][x] = world.isLeaf(x, y);
			}
		}

		while (true) {
			for (int y = 1; y < SIZE_Y - 1; y++) {
				for (int x = 1; x < SIZE_X - 1; x++) {
					newCells[y][x] = newCellValue(cells, y, x);
				}
			}

			for (int y = 1; y < SIZE_Y - 1; y++) {
				for (int x = 1; x < SIZE_X - 1; x++) {
					cells[y][x] = newCells[y][x];
					world.setLeaf(x, y, cells[y][x]);
				}

			}
		}
	}

	int countNeighborsIncl(boolean[][] cells, int y, int x) {
		int count = 0;
		for (int i = y - 1; i <= y + 1; i++) {
			for (int j = x - 1; j <= x + 1; j++) {
				if (cells[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	boolean newCellValue(boolean[][] cells, int y, int x) {
		int neighbors = countNeighborsIncl(cells, y, x);
		if (cells[y][x]) {
			neighbors = neighbors - 1; // Zelle selbst zählt nicht
			return (neighbors == 2) || (neighbors == 3);
		}
		else {
			return (neighbors == 3);
		}
	}

}
