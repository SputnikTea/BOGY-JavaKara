package loesungen._14_lindenmayer;

import javakara.JavaKaraProgram;

public class Lindenmayer extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Lindenmayer();
		program.run("classes/aufgaben/_14_lindenmayer/world1.world");
	}

	@Override
	public void myMainProgram() {
		final String GENERATOR_FIND = "F";
		final String GENERATOR_REPLACE = "FLFRFRFLF";
		final int ITERATIONS = 3;

		String string = "FF";

		for (int i = 0; i < ITERATIONS; i++) {
			world.clearAll();
			kara.setPosition(0, world.getSizeY() - 1);
			interpret(string, 3);
			tools.sleep(500);

			string = replace(string, GENERATOR_FIND, GENERATOR_REPLACE);
		}

		world.clearAll();
		kara.setPosition(0, world.getSizeY() - 1);
		interpret(string, 3);
	}

	void forward(int n) {
		for (int i = 0; i < n; i++) {
			if (!kara.onLeaf()) {
				kara.putLeaf();
			}
			kara.move();
		}
	}

	void interpret(String string, int stepLength) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'F') {
				forward(stepLength);
			}
			else if (string.charAt(i) == 'L') {
				kara.turnLeft();
			}
			else if (string.charAt(i) == 'R') {
				kara.turnRight();
			}
		}
	}

	String replace(String string, String find, String replace) {
		String result = "";
		int index = 0;

		while (index <= string.length() - find.length()) {
			String currentSubString = string.substring(index,
					index + find.length());

			if (currentSubString.equals(find)) {
				result += replace;
				index += find.length();
			}
			else {
				result += currentSubString;
				index++;
			}
		}

		return result;
	}
}
