package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;

    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                this.updatePosition(newPosition);
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                this.updatePosition(newPosition);
            }
        }
    }

    private void updatePosition(Vector2d newPosition) {
        if (this.map.canMoveTo(newPosition)) {
            Vector2d oldPosition = this.position;
            this.position = newPosition;
            this.observers.forEach(observer -> observer.positionChanged(oldPosition, newPosition));
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.removeIf(observer::equals);
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    @Override
    public String getLabel() {
        return direction.getSymbol() + this.position;
    }

    @Override
    public String getImageSrc() {
        return direction.getImageSrc();
    }

    @Override
    public String toString() {
//        return "position = " + position + ", direction = " + direction;
        return direction.getSymbol();
    }
}
