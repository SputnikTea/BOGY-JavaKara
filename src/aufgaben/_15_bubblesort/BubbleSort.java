package aufgaben._15_bubblesort;

import javakara.JavaKaraProgram;

import java.util.Arrays;

public class BubbleSort extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new BubbleSort();
		program.run("src/aufgaben/_15_bubblesort/world1.world");
		// oder:
		// program.run("src/aufgaben/_15_bubblesort/world2.world");
		// oder:
		// program.run("src/aufgaben/_15_bubblesort/world3.world");
	}

	@Override
	public void myMainProgram() {
		// hier kommt das Hauptprogramm Ihrer L�sung hin
		int numberofleaf = 0;
		int noleaf = 0;
		int x = 0;
		int y = 0;
		int stopp = 0;
		int[] A = new int[world.getSizeY()];
		while (y < world.getSizeY()) {
			noleaf = 0;
			while (noleaf == 0 && x + 1 < world.getSizeX()) {
				noleaf++;
				if (world.isLeaf(x, y)) {
					numberofleaf++;
					x++;
					noleaf = 0;
				}

			}
			A[y] = numberofleaf;
			y++;
		}
		System.out.println(Arrays.toString(A));
		y = 0;
		int changedSomething = 1;
		while (changedSomething == 1) {
			changedSomething = 0;

			while (y < world.getSizeY())
				if (A[y] > A[y + 1]) {
					changedSomething = 1;

					while (stopp == 0) {

						if (!world.isLeaf(A[y], y)) {
							world.setLeaf(A[y], y, true);

						} else {
							stopp = 1;
						}

					}
					x = y + 1;
					stopp = 0;
					while (stopp == 0) {

						if (!world.isLeaf(A[x], y)) {
							world.setLeaf(A[x], y, true);//removeLeaf

						} else {
							stopp = 1;
						}
					}
				} else {
					y++;
				}
		}


	}
}

