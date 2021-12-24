package agh.ics.oop;

import java.util.Random;

public enum MapDirection {
    NORTH ("North", new Vector2d(0, 1), "N", "src/main/resources/animal_up.png"),
    NORTHEAST ("Northeast", new Vector2d(1, 1), "NE", "src/main/resources/animal_up.png"),
    EAST ("East", new Vector2d(1, 0), "E", "src/main/resources/animal_right.png"),
    SOUTHEAST ("Southeast", new Vector2d(1, -1), "SE", "src/main/resources/animal_right.png"),
    SOUTH ("South", new Vector2d(0, -1), "S", "src/main/resources/animal_down.png"),
    SOUTHWEST ("Southwest", new Vector2d(-1, -1), "SW", "src/main/resources/animal_down.png"),
    WEST ("West", new Vector2d(-1, 0), "W", "src/main/resources/animal_left.png"),
    NORTHWEST ("Northwest", new Vector2d(-1, 1), "NW", "src/main/resources/animal_left.png");

    private final String stringValue;
    private final Vector2d unitVector;
    private final String symbol;
    private final String imageSrc;

    MapDirection(String stringValue, Vector2d unitVector, String symbol, String imageSrc) {
        this.stringValue = stringValue;
        this.unitVector = unitVector;
        this.symbol = symbol;
        this.imageSrc = imageSrc;
    }

    public MapDirection rotate(Integer rotation) {
        return MapDirection.values()[(this.ordinal() + rotation) % 8];
    }

    public static MapDirection randomDirection() {
        Random random = new Random();
        return MapDirection.values()[random.nextInt(8)];
    }

//    public MapDirection next() {
//        return MapDirection.values()[(this.ordinal() + 1) % 4];
//    }
//
//    public MapDirection previous() {
//        return MapDirection.values()[(this.ordinal() + 3) % 4];
//    }

    public Vector2d toUnitVector() {
        return this.unitVector;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getImageSrc() {
        return this.imageSrc;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
