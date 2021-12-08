package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {

    @Test
    public void parseTest() {
        ArrayList<MoveDirection> expected1 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        assertEquals(expected1, OptionsParser.parse(new String[]{"f", "b", "r", "l", "forward", "backward", "right", "left"}));

        ArrayList<MoveDirection> expected2 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT));
        assertEquals(expected2, OptionsParser.parse(new String[]{"f", "b", "forward", "backward", "left", "r"}));

        IllegalArgumentException thrown1 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{"right ", " right", "right", "back ward", "b", "forwar", "f", "left", " ", "", "l", "r"});
        });
        assertEquals("right  is not legal move specification", thrown1.getMessage());

        IllegalArgumentException thrown2 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{"right", "right", "right", "back ward", "b", "forwar", "f", "left", " ", "", "l", "r"});
        });
        assertEquals("back ward is not legal move specification", thrown2.getMessage());

        IllegalArgumentException thrown3 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{"right", "right", "right", "backward", "b", "forwar", "f", "left", " ", "", "l", "r"});
        });
        assertEquals("forwar is not legal move specification", thrown3.getMessage());

        IllegalArgumentException thrown4 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{"right", "right", "right", "backward", "b", "forward", "f", " left", " ", "", "l", "r"});
        });
        assertEquals(" left is not legal move specification", thrown4.getMessage());

        IllegalArgumentException thrown5 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{""});
        });
        assertEquals(" is not legal move specification", thrown5.getMessage());

        IllegalArgumentException thrown6 = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(new String[]{" ", "", "a", "bb", "ccc", "dddd", "       ", "", "4341123"});
        });
        assertEquals("  is not legal move specification", thrown6.getMessage());
    }
}
