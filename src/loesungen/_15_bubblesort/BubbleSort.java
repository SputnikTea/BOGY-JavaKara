package loesungen._15_bubblesort;

import javakara.JavaKaraProgram;

public class BubbleSort extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new BubbleSort();
		program.run("classes/aufgaben/_15_bubblesort/world1.world");
		// oder:
		// program.run("classes/aufgaben/_15_bubblesort/world2.world");
		// oder:
		// program.run("classes/aufgaben/_15_bubblesort/world3.world");
	}

	@Override
	public void myMainProgram() {
		int[] numbers = new int[world.getSizeY()];
		boolean numbersSorted = false;

		// wenn die Welt zu Beginn ein Balkendiagramm enthält:
		for (int y = 0; y < world.getSizeY(); y++) {
			numbers[y] = getNumber(y);
		}

		// sonst kann man auch eines erstellen lassen:
		// permutateNumbers(numbers);

		while (!numbersSorted) {
			numbersSorted = true;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] > numbers[i + 1]) {
					swap(numbers, i, i + 1);
					numbersSorted = false;
					showNumbers(numbers);
				}
			}
		}
	}

	int getNumber(int y) {
		int length = 0;
		for (int x = 0; x < world.getSizeX(); x++) {
			if (world.isLeaf(x, y)) {
				length++;
			}
		}
		return length;
	}

	void permutateNumbers(int[] numbers) {
		for (int y = 0; y < world.getSizeY(); y++) {
			numbers[y] = y;
		}
		for (int i = 0; i < world.getSizeY() * 10; i++) {
			int u = tools.random(numbers.length - 1);
			int v = tools.random(numbers.length - 1);
			swap(numbers, u, v);
		}
	}

	void showNumbers(int[] numbers) {
		for (int y = 0; y < world.getSizeY(); y++) {
			for (int x = 0; x < world.getSizeX(); x++) {
				world.setLeaf(x, y, (x < numbers[y]));
			}
		}
	}

	void swap(int[] numbers, int index1, int index2) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

}
