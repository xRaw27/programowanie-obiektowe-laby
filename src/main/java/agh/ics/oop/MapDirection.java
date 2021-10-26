package agh.ics.oop;

public enum MapDirection {
    NORTH ("Północ", new Vector2d(0, 1)),
    EAST ("Wschód", new Vector2d(1, 0)),
    SOUTH ("Południe", new Vector2d(0, -1)),
    WEST ("Zachód", new Vector2d(-1, 0));

    private final String stringValue;
    private final Vector2d unitVector;

    MapDirection(String stringValue, Vector2d unitVector) {
        this.stringValue = stringValue;
        this.unitVector = unitVector;
    }

    public MapDirection next() {
        return MapDirection.values()[(this.ordinal() + 1) % 4];
    }

    public MapDirection previous() {
        return MapDirection.values()[(this.ordinal() + 3) % 4];
    }

    public Vector2d toUnitVector() {
        return this.unitVector;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
