package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Direction {
    FORWARD,
    BACKWARDS,
    RIGHT,
    LEFT;

    public static ArrayList<Direction> translateStringsToDirections(String[] args) {
        return Arrays.stream(args)
                .map(arg -> switch (arg) {
                    case "f" -> Direction.FORWARD;
                    case "b" -> Direction.BACKWARDS;
                    case "r" -> Direction.RIGHT;
                    case "l" -> Direction.LEFT;
                    default -> null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

//    ======================== bez użycia streama ========================
//    public static ArrayList<Direction> translateStringsToDirections(String[] args) {
//        ArrayList<Direction> directions = new ArrayList<>();
//
//        for (String arg : args) {
//            Direction d = switch (arg) {
//                case "f" -> Direction.FORWARD;
//                case "b" -> Direction.BACKWARDS;
//                case "r" -> Direction.RIGHT;
//                case "l" -> Direction.LEFT;
//                default -> null;
//            };
//
//            if (d != null) directions.add(d);
//        }
//
//        return directions;
//    }
