package loesungen._16_mandelbrot;

import javakara.JavaKaraProgram;

public class Mandelbrot extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Mandelbrot();
		program.run("classes/aufgaben/_16_mandelbrot/world1.world");
	}

	final double ITERATIONS = 100;

	final double X_MIN = -2;
	final double X_MAX = 1.4;
	final double Y_MIN = -2;
	final double Y_MAX = 1.4;

	int KARA_WIDTH;
	int KARA_HEIGHT;

	@Override
	public void myMainProgram() {
		KARA_WIDTH = world.getSizeX();
		KARA_HEIGHT = world.getSizeY();

		world.clearAll();

		for (int row = 0; row < KARA_HEIGHT; row++) {
			for (int col = 0; col < KARA_WIDTH; col++) {
				double x = berechneApfelX(col);
				double y = berechneApfelY(row);

				int i = fahrstreckentest(x, y);
				if (i == ITERATIONS) {
					world.setLeaf(col, row, true);
				}
			}
		}
	}

	double berechneApfelX(int col) {
		return X_MIN + col * (X_MAX - X_MIN) / KARA_WIDTH;
	}

	double berechneApfelY(int row) {
		return Y_MIN + row * (Y_MAX - Y_MIN) / KARA_HEIGHT;
	}

	int fahrstreckentest(double x, double y) {
		double tmpX = 0, tmpY = 0;
		int i = 0;

		do {
			double tmp2X, tmp2Y;
			i++;
			tmp2X = tmpX * tmpX - tmpY * tmpY + x;
			tmp2Y = 2 * tmpX * tmpY + y;
			tmpX = tmp2X;
			tmpY = tmp2Y;
		}
		while (((tmpX * tmpX + tmpY * tmpY) <= 4) && (i < ITERATIONS));

		return i;
	}

}
