package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class World {
    static String getMessage(Direction direction) {
        return switch (direction) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARDS -> "Zwierzak idzie do tyłu";
            case RIGHT -> "Zwierzak skręca w prawo";
            case LEFT -> "Zwierzak skręca w lewo";
        };
    }

    static void run(ArrayList<Direction> directions) {
        System.out.println("Start");
        for (Direction direction : directions) {
            System.out.println(getMessage(direction));
        }
        System.out.println("Stop");
    }

    static ArrayList<Direction> translateStringsToDirections(String[] args) {
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

//    ======================== bez użycia streama ========================
//    static ArrayList<Direction> translateStringsToDirections(String[] args) {
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
//        return directions
//    }

    public static void main(String[] args) {
        run(translateStringsToDirections(args));
    }
}
