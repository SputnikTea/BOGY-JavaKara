package aufgaben._15_bubblesort;

import javakara.JavaKaraProgram;

import java.util.Arrays;

public class BubbleSort extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new BubbleSort();
		JavaKaraProgram.MIN_SLEEP_TIME = 20000;
		program.run("src/aufgaben/_15_bubblesort/world1.world");
		// oder:
		// program.run("src/aufgaben/_15_bubblesort/world2.world");
		// oder:
		 //program.run("src/aufgaben/_15_bubblesort/world3.world");
	}

	@Override
	public void myMainProgram() {

		int x = 0;
		int y = 0;
		int[] A = countLeafsPerRow();
		System.out.println(Arrays.toString(A));


		int Tauschvariabel = 0;
		while (x+1 < world.getSizeY()) {
			if (A[x] > A[x + 1]) {
				Tauschvariabel = A[x];
				A[x] = A[x + 1];
				A[x + 1] = Tauschvariabel;
				x = 0;
				System.out.println(Arrays.toString(A));
			} else {
				x++;
			}
		}


		world.clearAll();
		y = 0;
		while (y< world.getSizeY()) {
			x=0;
			while (x < A[y]) {
				world.setLeaf(x, y, true);
				x++;
			}
			y++;
		}
	}

	private int[] countLeafsPerRow() {
		int[] A = new int[world.getSizeY()];
		for(int row=0; row < world.getSizeY(); row++){
			int leafCount =0;
			int column = 0;
			while (column<world.getSizeX() && world.isLeaf(column, row)) {
				leafCount++;
				column++;
			}
			A[row] = leafCount;
		}
		return A;
	}
}