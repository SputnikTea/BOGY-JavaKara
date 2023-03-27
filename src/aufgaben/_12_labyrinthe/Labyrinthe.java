package aufgaben._12_labyrinthe;

import javakara.JavaKaraProgram;

public class Labyrinthe extends JavaKaraProgram {

    public static void main(String[] args) {
        JavaKaraProgram program = new Labyrinthe();
        JavaKaraProgram.MIN_SLEEP_TIME = 75;
        // program.run("src/aufgaben/_12_labyrinthe/world1.world");
        // oder:
        // program.run("src/aufgaben/_12_labyrinthe/world2.world");
        // oder:
        // program.run("src/aufgaben/_12_labyrinthe/world3.world");
        program.run("src/aufgaben/_12_labyrinthe/world4.world");
    }

    @Override
    public void myMainProgram() {
        while (!kara.onLeaf()) {
            anReihenAnfangStellen();
            nachRechtsDrehen();
            nebenAusgangStellen();
            moveIntoNextRow();

        }
        kara.removeLeaf();
    }

    private void nachRechtsDrehen() {
        turn180();
    }

    private void anReihenAnfangStellen() {
        if (kara.treeLeft() || kara.treeRight()) {
            moveForwardUntilTree();
        } else {
            kara.turnRight();
            moveForwardUntilTree();
        }
    }

    private void moveForwardUntilTree() {
        while (!kara.treeFront()) {
            kara.move();
        }
    }

    void turn180() {
        kara.turnLeft();
        kara.turnLeft();
    }

    void moveIntoNextRow() {

        kara.setDirection(0);
        if (!kara.treeFront()) {
            kara.move();
            kara.move();
            kara.turnRight();
            if (!kara.onLeaf()) {
                kara.move();
            }
        }
            kara.turnLeft();

    }
        void nebenAusgangStellen () {
            while (kara.treeLeft() && kara.treeRight()) {
                kara.move();
            }
        }

    }


