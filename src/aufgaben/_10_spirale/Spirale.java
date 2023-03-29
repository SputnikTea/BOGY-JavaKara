package aufgaben._10_spirale;

import javakara.JavaKaraProgram;

public class Spirale extends JavaKaraProgram {

	public static void main(String[] args) {
		JavaKaraProgram program = new Spirale();
		program.run("src/aufgaben/_10_spirale/world1.world");
	}

	@Override
	public void myMainProgram() {
      int leafs=1;
	  int i=0;
	  while (leafs<21){
		  while (i<leafs){
			  kara.putLeaf();
			  kara.move();
			  i++;
		  }
		  kara.turnRight();
		  leafs++;
		  i=0;
	  }
	}

}
