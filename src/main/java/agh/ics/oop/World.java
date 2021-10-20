package agh.ics.oop;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        run(Direction.translateStringsToDirections(args));

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
