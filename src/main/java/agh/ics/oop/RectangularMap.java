package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height) {
        this.bottomLeftCorner = new Vector2d(0, 0);
        this.topRightCorner = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (super.canMoveTo(position)) {
            return position.precedes(this.topRightCorner) && position.follows(this.bottomLeftCorner);
        }
        return false;
    }
}
