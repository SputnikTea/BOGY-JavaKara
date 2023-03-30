package aufgaben._13_gameoflife;

import javakara.JavaKaraProgram;

public class GameOfLife extends JavaKaraProgram {

    public static void main(String[] args) {
        JavaKaraProgram program = new GameOfLife();
        JavaKaraProgram.MIN_SLEEP_TIME = 3000;
        //program.run("src/aufgaben/_13_gameoflife/world1.world");
        // oder:
        program.run("src/aufgaben/_13_gameoflife/world2.world");
        // oder:
         //program.run("src/aufgaben/_13_gameoflife/world3.world");
    }

    @Override
    public void myMainProgram() {
        while (true) {
           PauseZwischenSchritten();

            int[] vonKleeblaetternBedeckt = new int[(world.getSizeY() * world.getSizeX())];
            int[] AnzahlNachbarfelder = new int[(world.getSizeY() * world.getSizeX())];

            ArrayWoKleeblaetterSind(vonKleeblaetternBedeckt);


            ArrayAnzahlNachbarfelder(vonKleeblaetternBedeckt, AnzahlNachbarfelder);

            KleeblaetterNeuAnordnen(vonKleeblaetternBedeckt, AnzahlNachbarfelder);

        }

    }

    private static void PauseZwischenSchritten() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void KleeblaetterNeuAnordnen(int[] vonKleeblaetternBedeckt, int[] AnzahlNachbarfelder) {
        int y;
        int x;
        int Element = 0;
        while (Element< world.getSizeX() * world.getSizeY()) {
            y = 0;
            x = Element;
            if (vonKleeblaetternBedeckt[Element] == 0) {
                if (AnzahlNachbarfelder[Element] == 3) {
                    while (x+1> world.getSizeX()) {
                        x = x - world.getSizeX();
                        y++;
                    }

                    world.setLeaf(x, y, true);

                }
            }
            else {
                if (!(AnzahlNachbarfelder[Element] == 3) && !(AnzahlNachbarfelder[Element] == 2)) {
                    while (x+1  > world.getSizeX()) {
                        x = x - world.getSizeX();
                        y++;
                    }
                    world.setLeaf(x, y, false);

                }
            }
            Element++;
        }
    }

    void ArrayAnzahlNachbarfelder(int[] vonKleeblaetternBedeckt, int[] AnzahlNachbarfelder) {

        int Element = 0;
        while (Element < world.getSizeX() * world.getSizeY()) {

            AnzahlNachbarfelder[Element] = 0;

            if (Element < (world.getSizeY() * world.getSizeX()) - 1 && vonKleeblaetternBedeckt[Element + 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }

            if (Element > 0 && vonKleeblaetternBedeckt[Element - 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }

            if (Element > world.getSizeX() && vonKleeblaetternBedeckt[Element - world.getSizeX() - 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element > world.getSizeX() -1&& vonKleeblaetternBedeckt[Element - world.getSizeX()] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element > world.getSizeX() - 2 && vonKleeblaetternBedeckt[Element - world.getSizeX() + 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }

            if (Element < ((world.getSizeX() - 1) * world.getSizeY()) + 1 && vonKleeblaetternBedeckt[Element + world.getSizeY() - 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element < ((world.getSizeX() - 1) * world.getSizeY()) && vonKleeblaetternBedeckt[Element + world.getSizeY()] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element < ((world.getSizeX() - 1) * world.getSizeY()) - 1 && vonKleeblaetternBedeckt[Element + world.getSizeY() + 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }

            Element++;


        }
    }


    void ArrayWoKleeblaetterSind(int[] vonKleeblaetternBedeckt) {
        int y = 0;
        int x = 0;


        while (y < world.getSizeY()) {

            while (x < world.getSizeX()) {

                if (world.isLeaf(x, y)) {
                    vonKleeblaetternBedeckt[x + (y * world.getSizeX())] = 1;
                }
                else {
                    vonKleeblaetternBedeckt[x + (y * world.getSizeX())] = 0;
                }
                x++;
            }
            y++;
            x = 0;

        }
    }
}