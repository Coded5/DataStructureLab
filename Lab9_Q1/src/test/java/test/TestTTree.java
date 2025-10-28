package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.*;

class TestTTree {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testPredictLevel1() {
        TTree t = new TTree(1);
        t.theArray[0][0].name = "Chelsea";
        t.theArray[0][0].ranking = 3;
        t.theArray[0][1].name = "Man U";
        t.theArray[0][1].ranking = 5;

        t.predictResult();
        assertEquals("Chelsea", t.theArray[1][0].name);
        assertEquals(3, t.theArray[1][0].ranking);
        assertEquals("Chelsea", t.winner.name);
        assertEquals(3, t.winner.ranking);

        // change initial ranking
        t.theArray[0][0].ranking = 7;
        t.predictResult();
        assertEquals("Man U", t.theArray[1][0].name);
        assertEquals(5, t.theArray[1][0].ranking);
        assertEquals("Man U", t.winner.name);
        assertEquals(5, t.winner.ranking);

    }

    @Test
    void testPredictLevel2() {
        TTree t = new TTree(2);
        t.theArray[0][0].name = "Chelsea";
        t.theArray[0][0].ranking = 3;

        t.theArray[0][1].name = "Man U";
        t.theArray[0][1].ranking = 5;

        t.theArray[0][2].name = "Man City";
        t.theArray[0][2].ranking = 1;

        t.theArray[0][3].name = "Spurs";
        t.theArray[0][3].ranking = 7;

        t.predictResult();
        assertEquals("Chelsea", t.theArray[1][0].name);
        assertEquals(3, t.theArray[1][0].ranking);
        assertEquals("Man City", t.theArray[1][1].name);
        assertEquals(1, t.theArray[1][1].ranking);
        assertEquals("Man City", t.theArray[2][0].name);
        assertEquals(1, t.theArray[2][0].ranking);
        assertEquals("Man City", t.winner.name);
        assertEquals(1, t.winner.ranking);

        // change some initial rankings
        t.theArray[0][1].ranking = 1;
        t.theArray[0][2].ranking = 9;
        t.predictResult();
        assertEquals("Man U", t.theArray[1][0].name);
        assertEquals(1, t.theArray[1][0].ranking);
        assertEquals("Spurs", t.theArray[1][1].name);
        assertEquals(7, t.theArray[1][1].ranking);
        assertEquals("Man U", t.theArray[2][0].name);
        assertEquals(1, t.theArray[2][0].ranking);
        assertEquals("Man U", t.winner.name);
        assertEquals(1, t.winner.ranking);

    }

    @Test
    void testPredictLevel3() {
        TTree t = new TTree(3);
        t.theArray[0][0].name = "Chelsea";
        t.theArray[0][0].ranking = 3;

        t.theArray[0][1].name = "Man U";
        t.theArray[0][1].ranking = 5;

        t.theArray[0][2].name = "Man City";
        t.theArray[0][2].ranking = 1;

        t.theArray[0][3].name = "Spurs";
        t.theArray[0][3].ranking = 7;

        t.theArray[0][4].name = "Liverpool";
        t.theArray[0][4].ranking = 2;

        t.theArray[0][5].name = "Arsenal";
        t.theArray[0][5].ranking = 4;

        t.theArray[0][6].name = "Newcastle";
        t.theArray[0][6].ranking = 6;

        t.theArray[0][7].name = "Fulham";
        t.theArray[0][7].ranking = 8;

        t.predictResult();
        assertEquals("Chelsea", t.theArray[1][0].name);
        assertEquals(3, t.theArray[1][0].ranking);
        assertEquals("Man City", t.theArray[1][1].name);
        assertEquals(1, t.theArray[1][1].ranking);
        assertEquals("Liverpool", t.theArray[1][2].name);
        assertEquals(2, t.theArray[1][2].ranking);
        assertEquals("Newcastle", t.theArray[1][3].name);
        assertEquals(6, t.theArray[1][3].ranking);

        assertEquals("Man City", t.theArray[2][0].name);
        assertEquals(1, t.theArray[2][0].ranking);
        assertEquals("Liverpool", t.theArray[2][1].name);
        assertEquals(2, t.theArray[2][1].ranking);

        assertEquals("Man City", t.theArray[3][0].name);
        assertEquals(1, t.theArray[3][0].ranking);
        assertEquals("Man City", t.winner.name);
        assertEquals(1, t.winner.ranking);

        // change some initial rankings
        t.theArray[0][2].ranking = 4;
        t.theArray[0][5].ranking = 1;
        t.predictResult();
        assertEquals("Chelsea", t.theArray[1][0].name);
        assertEquals(3, t.theArray[1][0].ranking);
        assertEquals("Man City", t.theArray[1][1].name);
        assertEquals(4, t.theArray[1][1].ranking);
        assertEquals("Arsenal", t.theArray[1][2].name);
        assertEquals(1, t.theArray[1][2].ranking);
        assertEquals("Newcastle", t.theArray[1][3].name);
        assertEquals(6, t.theArray[1][3].ranking);

        assertEquals("Chelsea", t.theArray[2][0].name);
        assertEquals(3, t.theArray[2][0].ranking);
        assertEquals("Arsenal", t.theArray[2][1].name);
        assertEquals(1, t.theArray[2][1].ranking);

        assertEquals("Arsenal", t.theArray[3][0].name);
        assertEquals(1, t.theArray[3][0].ranking);
        assertEquals("Arsenal", t.winner.name);
        assertEquals(1, t.winner.ranking);

    }

}
