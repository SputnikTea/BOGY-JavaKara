package loesungen._02_tunnel_ausgang;

import javakara.JavaKaraProgram;

public class TunnelAusgangSuchen extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new TunnelAusgangSuchen();
		program.run("classes/aufgaben/_02_tunnel_ausgang/world1.world");
		// oder:
		// program.run("classes/aufgaben/_02_tunnel_ausgang/world2.world");
		// oder:
		// program.run("classes/aufgaben/_02_tunnel_ausgang/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (!(kara.treeLeft() && kara.treeRight())) {
			kara.move();
		}

		while (kara.treeLeft() && kara.treeRight()) {
			kara.move();
		}
	}

}
