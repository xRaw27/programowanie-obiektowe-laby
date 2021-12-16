package agh.ics.oop;

public class Grass implements IMapElement{
    private final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String getLabel() {
        return "Grass";
    }

    @Override
    public String getImageSrc() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String toString() {
        return "*";
    }
}
