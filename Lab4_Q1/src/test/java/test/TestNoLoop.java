package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNoLoop {
    @Test
    void testNoLoop() throws FileNotFoundException { // 4 marks
        // You must provide the correct path for your file
        String abs_path = "/home/kami/Projects/DataStructureLabs/Lab4_Q1/src/main/java/main/ShiftableList.java";
        File f = new File(abs_path);
        Scanner s = new Scanner(f);

        boolean foundLoop = false;
        String line = "";
        while (s.hasNextLine()) {
            line = s.nextLine();
            if (line.contains("shift(DListNode")) {
                break;
            }
        }

        while (s.hasNextLine()) {
            if (line.contains("for") || line.contains("while")) {
                foundLoop = true;
                break;
            }
            line = s.nextLine();
        }
        s.close();
        assertFalse(foundLoop);

    }

}
