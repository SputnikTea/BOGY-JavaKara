package loesungen._01_tunnel_eingang;

import javakara.JavaKaraProgram;

public class TunnelEingangSuchen extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new TunnelEingangSuchen();
		program.run("classes/aufgaben/_01_tunnel_eingang/world1.world");
		// oder:
		// program.run("classes/aufgaben/_01_tunnel_eingang/world2.world");
		// oder:
		// program.run("classes/aufgaben/_01_tunnel_eingang/world3.world");
	}

	@Override
	public void myMainProgram() {
		while (!(kara.treeLeft() && kara.treeRight())) {
			kara.move();
		}
	}

}
