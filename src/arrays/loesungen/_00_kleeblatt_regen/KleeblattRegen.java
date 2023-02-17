package arrays.loesungen._00_kleeblatt_regen;

import javakara.JavaKaraProgram;

public class KleeblattRegen extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new KleeblattRegen();
		program.run();
	}

	@Override
	public void myMainProgram() {
		int i = 0;
		while (i < 15) {
			int x = tools.random(world.getSizeX() - 1);
			int y = tools.random(world.getSizeY() - 1);

			if (!world.isLeaf(x, y)) {
				world.setLeaf(x, y, true);
				i++;
			}
		}
	}

}
