package src.loesungen._00_kleeblaetter_aufnehmen;

import javakara.JavaKaraProgram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KleeblaetterAufnehmenTest {

    @Test
    void testMyMainProgram() {
        // Only a smoke test
        assertDoesNotThrow(() -> KleeblaetterAufnehmen.main(new String[]{}));
    }

    @Test
    void test_tesProgramm() {
        JavaKaraProgram testProgramm = KleeblaetterAufnehmen.testProgramm();
        testProgramm.run("src/aufgaben/_00_kleeblaetter_aufnehmen/world1.world");
        assertFalse(testProgramm.kara.onLeaf());
        assertTrue(testProgramm.kara.treeFront());
    }
}
