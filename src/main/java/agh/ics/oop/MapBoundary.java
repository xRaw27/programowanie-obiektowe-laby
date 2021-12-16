package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> mapElementVectorsSortedByX = new TreeSet<>(Vector2d::compareByX);
    private final SortedSet<Vector2d> mapElementVectorsSortedByY = new TreeSet<>(Vector2d::compareByY);
    private final GrassField map;

    public MapBoundary(GrassField map) {
        this.map = map;
    }

    public Vector2d getBottomLeftCorner() {
        return new Vector2d(this.mapElementVectorsSortedByX.first().x, this.mapElementVectorsSortedByY.first().y);
    }

    public Vector2d getTopRightCorner() {
        return new Vector2d(this.mapElementVectorsSortedByX.last().x, this.mapElementVectorsSortedByY.last().y);
    }

    public void addPositionVector(Vector2d position) {
        this.mapElementVectorsSortedByX.add(position);
        this.mapElementVectorsSortedByY.add(position);

        this.map.mapBoundariesChanged();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.mapElementVectorsSortedByX.remove(newPosition);
        this.mapElementVectorsSortedByX.add(newPosition);

        this.mapElementVectorsSortedByY.remove(newPosition);
        this.mapElementVectorsSortedByY.add(newPosition);

        this.map.mapBoundariesChanged();
    }
}
