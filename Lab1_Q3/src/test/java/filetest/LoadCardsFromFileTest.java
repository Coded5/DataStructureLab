package test.filetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import logic.CardUtil;
import logic.UnitCard;

public class LoadCardsFromFileTest {

    @Test
    void testLoadCardsGrimora() {
        String path = Thread.currentThread().getContextClassLoader().getResource("grimora.txt").getPath();
        ArrayList<UnitCard> cards = CardUtil.getCardsFromFile(path);

        assertNotNull(cards);

        assertEquals("Bone Man", cards.get(0).getName());
    }

    @Test
    void testLoadBadText() {
        String path = Thread.currentThread().getContextClassLoader().getResource("badtext.txt").getPath();
        ArrayList<UnitCard> cards = CardUtil.getCardsFromFile(path);

        assertNull(cards);
    }

    @Test
    void testNotFound() {
        ArrayList<UnitCard> cards = CardUtil.getCardsFromFile("somewherethatdoesntexist");
        assertNull(cards);
    }

}
