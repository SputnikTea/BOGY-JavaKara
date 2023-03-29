package aufgaben._13_gameoflife;

import javakara.JavaKaraProgram;

import java.util.Arrays;

public class GameOfLife extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new GameOfLife();
		program.run("src/aufgaben/_13_gameoflife/world1.world");
		// oder:
		// program.run("src/aufgaben/_13_gameoflife/world2.world");
		// oder:
		// program.run("src/aufgaben/_13_gameoflife/world3.world");
	}

	@Override
	public void myMainProgram() {

		int[] vonKleeblaetternBedeckt = new int[world.getSizeY() * world.getSizeX()];
		int[] AnzahlNachbarfelder = new int[world.getSizeY() * world.getSizeX()];

		ArrayWoKleeblaetterSind(vonKleeblaetternBedeckt);

		int AnzahlNachbarfelderV=0;
		int Element=0;
		while(Element< world.getSizeX()* world.getSizeY()){
			if(vonKleeblaetternBedeckt[Element]==1){
				AnzahlNachbarfelderV=0;
				if(vonKleeblaetternBedeckt[Element]< (world.getSizeY()* world.getSizeX())-1 && vonKleeblaetternBedeckt[Element+1]==1){
					AnzahlNachbarfelderV++;
				}
				if(vonKleeblaetternBedeckt[Element]>0 && vonKleeblaetternBedeckt[Element-1]==1){
					AnzahlNachbarfelderV++;
				}
				if(vonKleeblaetternBedeckt[Element]> world.getSizeX()+1 && vonKleeblaetternBedeckt[Element- world.getSizeX()-1]==1){
					AnzahlNachbarfelderV++;
				}
				if(vonKleeblaetternBedeckt[Element]> world.getSizeX() && vonKleeblaetternBedeckt[Element- world.getSizeX()]==1){
					AnzahlNachbarfelderV++;
				}
				if(vonKleeblaetternBedeckt[Element]> world.getSizeX()-1 && vonKleeblaetternBedeckt[Element- world.getSizeX()+1]==1) {
					AnzahlNachbarfelderV++;

				}
					if(vonKleeblaetternBedeckt[Element]< (world.getSizeX()* world.getSizeY()) - world.getSizeX()-1&& vonKleeblaetternBedeckt[Element+ world.getSizeX()-1]==1){
						AnzahlNachbarfelderV++;
					}
					if(vonKleeblaetternBedeckt[Element]< (world.getSizeX()* world.getSizeY()) - world.getSizeX() && vonKleeblaetternBedeckt[Element+ world.getSizeX()]==1){
						AnzahlNachbarfelderV++;
					}
					if(vonKleeblaetternBedeckt[Element]< (world.getSizeX()* world.getSizeY()) - world.getSizeX()+1 && vonKleeblaetternBedeckt[Element+ world.getSizeX()+1]==1){
						AnzahlNachbarfelderV++;
					}
				Element++;
				AnzahlNachbarfelder[Element]=AnzahlNachbarfelderV;
				System.out.println(AnzahlNachbarfelderV);


			}
		}
	}

	private void ArrayWoKleeblaetterSind(int[] vonKleeblaetternBedeckt) {
		int y = 0;
		int x=0;
		int yWert=0;

		while (y < world.getSizeY()) {

			while (x < world.getSizeX()) {
				System.out.println(x);
			if(world.isLeaf(x,y)){
				vonKleeblaetternBedeckt[x+yWert]=1;
			}
			else{
				vonKleeblaetternBedeckt[x+yWert]=0;
			}
			x++;
			}
			y++;
			x=0;
			yWert=y* world.getSizeX();
			System.out.println(Arrays.toString(vonKleeblaetternBedeckt));
		}
	}
}