package arrays.loesungen._01_welt_spiegeln;

import javakara.JavaKaraProgram;

public class WeltSpiegelnHorizontal extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new WeltSpiegelnHorizontal();
		program.run("classes/arrays/aufgaben/_01_welt_spiegeln/horizontal-spiegeln.world");
	}

	@Override
	public void myMainProgram() {
		for (int y = 0; y < world.getSizeY(); y++) {
			for (int x = 0; x < world.getSizeX() / 2; x++) {
				boolean blattLinks = world.isLeaf(x, y);
				boolean blattRechts = world.isLeaf(world.getSizeX() - 1 - x, y);
				world.setLeaf(x, y, blattRechts);
				world.setLeaf(world.getSizeX() - 1 - x, y, blattLinks);
			}
		}
	}

}
