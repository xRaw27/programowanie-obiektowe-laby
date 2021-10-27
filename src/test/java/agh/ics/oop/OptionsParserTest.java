package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    public void parseTest() {
        ArrayList<MoveDirection> expected = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        assertEquals(expected, OptionsParser.parse(new String[]{"f", "b", "r", "l", "forward", "backward", "right", "left"}));

        expected.clear();
        expected.addAll(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT)));
        assertEquals(expected, OptionsParser.parse(new String[]{"f", "b", "forward", "backward", "bakwaardwad", "bb", "leeft", "left", "r"}));

        expected.clear();
        expected.addAll(new ArrayList<>(Arrays.asList(MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT)));
        assertEquals(expected, OptionsParser.parse(new String[]{"r1ght", "right ", " right", "right", "back ward", "b", "forwar", "f", "left", " ", "", "l", "r"}));

        expected.clear();
        assertEquals(expected, OptionsParser.parse(new String[]{""}));

        expected.clear();
        assertEquals(expected, OptionsParser.parse(new String[]{" ", "", "a", "bb", "ccc", "dddd", "       ", "", "4341123"}));
    }

}
