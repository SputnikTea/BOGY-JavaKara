package src.aufgaben._12_labyrinthe;

import javakara.JavaKaraProgram;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES;

@Execution(ExecutionMode.CONCURRENT)
public class LabyrintheTest {


    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES)
    void should_solve_labyrinthe() {
        JavaKaraProgram testProgram = aufgaben._12_labyrinthe.Labyrinthe.testProgram();
        testProgram.run("src/aufgaben/_12_labyrinthe/world1.world");
        assertTrue(testProgram.kara.onLeaf());
    }
}