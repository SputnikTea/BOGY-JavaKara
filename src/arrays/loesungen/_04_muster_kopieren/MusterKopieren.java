package arrays.loesungen._04_muster_kopieren;

import javakara.JavaKaraProgram;

public class MusterKopieren extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new MusterKopieren();
		program.run("src/arrays/aufgaben/_04_muster_kopieren/muster_kopieren.world");
	}

	@Override
	public void myMainProgram() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int x = 0; x < 4; x++) {
					for (int y = 0; y < 4; y++) {
						world.setLeaf(i * 4 + x, j * 4 + y, world.isLeaf(x, y));
					}
				}
			}
		}
	}

}
