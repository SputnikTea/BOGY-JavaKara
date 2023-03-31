package aufgaben._13_gameoflife;

import javakara.JavaKaraProgram;

import java.util.Arrays;

public class GameOfLife extends JavaKaraProgram {

    public static void main(String[] args) {
        JavaKaraProgram program = new GameOfLife();
        JavaKaraProgram.MIN_SLEEP_TIME = 3000;
        //program.run("src/aufgaben/_13_gameoflife/world1.world");
        // oder:
        program.run("src/aufgaben/_13_gameoflife/world2.world");
        // oder:
        // program.run("src/aufgaben/_13_gameoflife/world3.world");
    }

    @Override
    public void myMainProgram() {
        int i = 0;
        while (i < 1) {
          //  while (true) {
                PauseZwischenSchritten();
                int[] vonKleeblaetternBedeckt = new int[(world.getSizeY() * world.getSizeX())];
                int[] AnzahlNachbarfelder = new int[(world.getSizeY() * world.getSizeX())];
                ArrayWoKleeblaetterSind(vonKleeblaetternBedeckt);
                ArrayAnzahlNachbarfelder2(vonKleeblaetternBedeckt, AnzahlNachbarfelder);

                int countCol = 0;
                while (countCol < world.getSizeY()) {
                    int countrow = 0;
                    int[] row = new int[world.getSizeX()];
                    while (countrow < world.getSizeX()) {
                        row[countrow] = AnzahlNachbarfelder[(world.getSizeX() * countCol) + countrow];
                        countrow++;
                    }
                    System.out.println(Arrays.toString(row));
                    countCol++;
                }
              //  KleeblaetterNeuAnordnen(vonKleeblaetternBedeckt, AnzahlNachbarfelder);
            i++;
            }

        }
    //}
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
        while (Element < world.getSizeX() * world.getSizeY()) {
            y = 0;
            x = Element;
            if (vonKleeblaetternBedeckt[Element] == 0) {
                if (AnzahlNachbarfelder[Element] == 3) {
                    while (x + 1 > world.getSizeX()) {
                        x = x - world.getSizeX();
                        y++;
                    }
                    world.setLeaf(x, y, true);
                }
            } else {
                if (!(AnzahlNachbarfelder[Element] == 3) && !(AnzahlNachbarfelder[Element] == 2)) {
                    while (x + 1 > world.getSizeX()) {
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
            if (Element > world.getSizeX() - 1 && vonKleeblaetternBedeckt[Element - world.getSizeX()] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element > world.getSizeX() - 2 && vonKleeblaetternBedeckt[Element - world.getSizeX() + 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX()) + 1 && vonKleeblaetternBedeckt[Element + world.getSizeX() - 1] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX()) && vonKleeblaetternBedeckt[Element + world.getSizeX()] == 1) {
                AnzahlNachbarfelder[Element]++;
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX()) - 1 && vonKleeblaetternBedeckt[Element + world.getSizeX() + 1] == 1) {
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
                } else {
                    vonKleeblaetternBedeckt[x + (y * world.getSizeX())] = 0;
                }
                x++;
            }
            y++;
            x = 0;
        }
    }


    void ArrayAnzahlNachbarfelder2(int[] vonKleeblaetternBedeckt, int[] AnzahlNachbarfelder) {
        int Element = 0;
        while (Element < world.getSizeX() * world.getSizeY()) {
            AnzahlNachbarfelder[Element] = 0;
            if (Element < (world.getSizeY() * world.getSizeX()) - 1) {
                if (vonKleeblaetternBedeckt[Element + 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[0] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element > 0) {
                if (vonKleeblaetternBedeckt[Element - 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[(world.getSizeY() * world.getSizeX()) - 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element > world.getSizeX()) {
                if (vonKleeblaetternBedeckt[Element - world.getSizeX() - 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element + (world.getSizeX() * (world.getSizeY() - 1)) - 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element > world.getSizeX() - 1) {
                if (vonKleeblaetternBedeckt[Element - world.getSizeX()] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element + (world.getSizeX() * (world.getSizeY() - 1))] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element > world.getSizeX() - 2) {
                if (vonKleeblaetternBedeckt[Element - world.getSizeX() + 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element + 1 + (world.getSizeX() * (world.getSizeY() - 1))] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX()) + 1) {
                if (vonKleeblaetternBedeckt[Element + world.getSizeY() - 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element - 1 - (world.getSizeX() * (world.getSizeY() - 1))] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX())) {
                if (vonKleeblaetternBedeckt[Element + world.getSizeY()] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element - (world.getSizeX() * (world.getSizeY() - 1))] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            if (Element < ((world.getSizeY() - 1) * world.getSizeX()) - 1) {
                if (vonKleeblaetternBedeckt[Element + world.getSizeY() + 1] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            } else {
                if (vonKleeblaetternBedeckt[Element + 1 - (world.getSizeX() * (world.getSizeY() - 1))] == 1) {
                    AnzahlNachbarfelder[Element]++;
                }
            }
            Element++;
        }
    }
}
