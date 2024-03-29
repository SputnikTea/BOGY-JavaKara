package arrays.loesungen._03_welt_drehen;

import javakara.JavaKaraProgram;

public class WeltDrehenNachRechts extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new WeltDrehenNachRechts();
		program.run("src/arrays/aufgaben/_03_welt_drehen/drehen.world");
	}

	@Override
	public void myMainProgram() {
		boolean[][] neueWelt = new boolean[world.getSizeX()][world.getSizeY()];
		berechneNeueWelt(neueWelt);
		ersetzeAlteWelt(neueWelt);
	}

	private void ersetzeAlteWelt(boolean[][] neueWelt) {
		for (int y = 0; y < world.getSizeY(); y++) {
			for (int x = 0; x < world.getSizeX(); x++) {
				world.setLeaf(x, y, neueWelt[x][y]);
			}
		}
	}

	private void berechneNeueWelt(boolean[][] neueWelt) {
		for (int y = 0; y < world.getSizeY(); y++) {
			for (int x = 0; x < world.getSizeX(); x++) {
				neueWelt[x][y] = world.isLeaf(y, world.getSizeX() - 1 - x);
			}
		}
	}

}
