package agh.ics.oop;

public enum MapDirection {
    NORTH ("Północ"),
    EAST ("Wschód"),
    SOUTH ("Południe"),
    WEST ("Zachód");

    private final String stringValue;

    MapDirection(String stringValue) {
        this.stringValue = stringValue;
    }

    public MapDirection next() {
        return MapDirection.values()[(this.ordinal() + 1) % 4];
    }

    public MapDirection previous() {
        return MapDirection.values()[(this.ordinal() + 3) % 4];
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
