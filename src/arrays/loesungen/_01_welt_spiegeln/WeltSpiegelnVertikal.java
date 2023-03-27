package arrays.loesungen._01_welt_spiegeln;

import javakara.JavaKaraProgram;

public class WeltSpiegelnVertikal extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new WeltSpiegelnVertikal();
		program.run("src/arrays/aufgaben/_01_welt_spiegeln/vertikal-spiegeln.world");
	}

	@Override
	public void myMainProgram() {
		for (int x = 0; x < world.getSizeX(); x++) {
			for (int y = 0; y < world.getSizeY() / 2; y++) {
				boolean blattOben = world.isLeaf(x, y);
				boolean blattUnten = world.isLeaf(x, world.getSizeY() - 1 - y);
				world.setLeaf(x, y, blattUnten);
				world.setLeaf(x, world.getSizeY() - 1 - y, blattOben);
			}
		}
	}

}
