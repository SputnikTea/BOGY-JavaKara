package arrays.loesungen._02_welt_verschieben;

import javakara.JavaKaraProgram;

public class WeltVerschiebenNachLinks extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new WeltVerschiebenNachLinks();
		program.run("classes/arrays/aufgaben/_02_welt_verschieben/verschieben.world");
	}

	@Override
	public void myMainProgram() {
		int verschiebenUm = tools.intInput("Um wieviel verschieben?");

		for (int y = 0; y < world.getSizeY(); y++) {
			boolean[] neueZeile = berechneNeueZeile(verschiebenUm, y);
			schreibeNeueZeile(y, neueZeile);
		}
	}

	private void schreibeNeueZeile(int y, boolean[] neueZeile) {
		for (int x = 0; x < world.getSizeX(); x++) {
			world.setLeaf(x, y, neueZeile[x]);
		}
	}

	private boolean[] berechneNeueZeile(int verschiebenUm, int y) {
		boolean[] neueZeile = new boolean[world.getSizeX()];
		for (int x = 0; x < world.getSizeX(); x++) {
			int kopiereVonX = (x + verschiebenUm) % world.getSizeX();
			neueZeile[x] = world.isLeaf(kopiereVonX, y);
		}
		return neueZeile;
	}

}
