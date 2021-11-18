package agh.ics.oop;

public enum MapDirection {
    NORTH ("Północ", new Vector2d(0, 1), "▲"),
    EAST ("Wschód", new Vector2d(1, 0), "▶"),
    SOUTH ("Południe", new Vector2d(0, -1), "▼"),
    WEST ("Zachód", new Vector2d(-1, 0), "◀");

    private final String stringValue;
    private final Vector2d unitVector;
    private final String symbol;

    MapDirection(String stringValue, Vector2d unitVector, String symbol) {
        this.stringValue = stringValue;
        this.unitVector = unitVector;
        this.symbol = symbol;
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

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
